package dei.gps.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import dei.gps.utils.Repetitions;

@Table(name="Repetitions")
public class Repetition extends Model {
	@Column(name="days")
	private int days;
	
	public Repetition() {
		super();
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}

	public boolean hasMonday() {
		if((this.days & Repetitions.MONDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasTuesday() {
		if((this.days & Repetitions.TUESDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasWednesday() {
		if((this.days & Repetitions.WEDNESDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasThursday() {
		if((this.days & Repetitions.THURSDAY) == 1)
			return true;
		return false;
	}
	public boolean hasFriday() {
		if((this.days & Repetitions.FRIDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasSaturday() {
		if((this.days & Repetitions.SATURDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasSunday() {
		if((this.days & Repetitions.SUNDAY) == 1)
			return true;
		return false;
	}
}
