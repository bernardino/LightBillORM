package pt.uc.dei.gps.lightbill.dao;

import java.util.List;

import pt.uc.dei.gps.lightbill.model.ModelRepetition;
import pt.uc.dei.gps.lightbill.model.utils.RepetitionsUtils;

import com.activeandroid.query.Select;


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
	public ModelRepetition getRepetitionById(int id) {
		return new Select().from(ModelRepetition.class).where("Id = ?", id).executeSingle();
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
	public ModelRepetition getRepetitionByDays(
			boolean monday,
			boolean tuesday,
			boolean wednesday,
			boolean thursday,
			boolean friday,
			boolean saturday,
			boolean sunday) {
		
		int days = 0;
		if(monday)
			days = days | RepetitionsUtils.MONDAY;
		if(tuesday)
			days = days | RepetitionsUtils.TUESDAY;
		if(wednesday)
			days = days | RepetitionsUtils.WEDNESDAY;
		if(thursday)
			days = days | RepetitionsUtils.THURSDAY;
		if(friday)
			days = days | RepetitionsUtils.FRIDAY;
		if(saturday)
			days = days | RepetitionsUtils.SATURDAY;
		if(sunday)
			days = days | RepetitionsUtils.SUNDAY;
		
		ModelRepetition r = new Select().from(ModelRepetition.class).where("days = ?", days).executeSingle();
		
		/* Create new if it does not exist */
		if(r==null) {
			r = new ModelRepetition();
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
	public List<ModelRepetition> getRepetitionsByWeekDay(int WEEKDAY) {
		List<ModelRepetition> repetitions = new Select().from(ModelRepetition.class).where("(days & "+WEEKDAY+") = "+WEEKDAY).execute();
		
		return repetitions;
	}
}
