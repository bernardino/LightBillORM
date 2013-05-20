package pt.uc.dei.gps.lightbill.model;

import pt.uc.dei.gps.lightbill.model.utils.RepetitionsUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * <b>Repetitions</b> table representation object.
 * 
 * @author bernardino
 *
 */
@Table(name="Repetitions")
public class ModelRepetition extends Model {
	@Column(name="days")
	private int days;
	
	public ModelRepetition() {
		super();
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}

	public boolean hasMonday() {
		if((this.days & RepetitionsUtils.MONDAY) == RepetitionsUtils.MONDAY)
			return true;
		return false;
	}
	
	public boolean hasTuesday() {
		if((this.days & RepetitionsUtils.TUESDAY) == RepetitionsUtils.TUESDAY)
			return true;
		return false;
	}
	
	public boolean hasWednesday() {
		if((this.days & RepetitionsUtils.WEDNESDAY) == RepetitionsUtils.WEDNESDAY)
			return true;
		return false;
	}
	
	public boolean hasThursday() {
		if((this.days & RepetitionsUtils.THURSDAY) == RepetitionsUtils.THURSDAY)
			return true;
		return false;
	}
	public boolean hasFriday() {
		if((this.days & RepetitionsUtils.FRIDAY) == RepetitionsUtils.FRIDAY)
			return true;
		return false;
	}
	
	public boolean hasSaturday() {
		if((this.days & RepetitionsUtils.SATURDAY) == RepetitionsUtils.SATURDAY)
			return true;
		return false;
	}
	
	public boolean hasSunday() {
		if((this.days & RepetitionsUtils.SUNDAY) == RepetitionsUtils.SUNDAY)
			return true;
		return false;
	}
}
