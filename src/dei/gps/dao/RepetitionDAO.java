package dei.gps.dao;

import java.util.List;

import com.activeandroid.query.Select;

import dei.gps.model.Repetition;
import dei.gps.utils.Repetitions;

/**
 * This is the class to access and query the <b>Repetition</b> table.
 * 
 * @author bernardino
 *
 */
public class RepetitionDAO {
	
	/**
	 * Method to query the Repetition table, searching for a specific ID.
	 * @param id
	 * @return The <b>Repetition</b> object if there is one with that ID. Otherwise, it returns <b>null</b>.
	 */
	public Repetition getRepetitionById(int id) {
		return new Select().from(Repetition.class).where("Id = ?", id).executeSingle();
	}
	
	/**
	 * Method to query the Repetition table, searching for a repetition day pattern.
	 * @param monday
	 * @param tuesday
	 * @param wednesday
	 * @param thursday
	 * @param friday
	 * @param saturday
	 * @param sunday
	 * @return The <b>Repetition</b> object if there is one with that pattern. Otherwise, it returns <b>null</b>.
	 */
	public Repetition getRepetitionByDays(
			boolean monday,
			boolean tuesday,
			boolean wednesday,
			boolean thursday,
			boolean friday,
			boolean saturday,
			boolean sunday) {
		
		int days = 0;
		if(monday)
			days = days | Repetitions.MONDAY;
		if(tuesday)
			days = days | Repetitions.TUESDAY;
		if(wednesday)
			days = days | Repetitions.WEDNESDAY;
		if(thursday)
			days = days | Repetitions.THURSDAY;
		if(friday)
			days = days | Repetitions.FRIDAY;
		if(saturday)
			days = days | Repetitions.SATURDAY;
		if(sunday)
			days = days | Repetitions.SUNDAY;
		
		Repetition r = new Select().from(Repetition.class).where("days = ?", days).executeSingle();
		
		/* Create new if it does not exist */
		if(r==null) {
			r = new Repetition();
			r.setDays(days);
			r.save();
		}
		
		return r;
	}
	
	/**
	 * Method to query the Repetition table, searching for all the objects with a specific week day.
	 * @param WEEKDAY
	 * @return A List<Repetition\> object with all the Repetition object found. If none are found, the list will be <b>empty</b>.
	 */
	public List<Repetition> getRepetitionsByWeekDay(int WEEKDAY) {
		List<Repetition> repetitions = new Select().from(Repetition.class).where("(days & "+WEEKDAY+") = "+WEEKDAY).execute();
		
		return repetitions;
	}
}
