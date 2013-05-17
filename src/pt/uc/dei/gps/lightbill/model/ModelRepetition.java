package pt.uc.dei.gps.lightbill.model;

import pt.uc.dei.gps.lightbill.model.utils.RepetitionsUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;


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
		if((this.days & RepetitionsUtils.MONDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasTuesday() {
		if((this.days & RepetitionsUtils.TUESDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasWednesday() {
		if((this.days & RepetitionsUtils.WEDNESDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasThursday() {
		if((this.days & RepetitionsUtils.THURSDAY) == 1)
			return true;
		return false;
	}
	public boolean hasFriday() {
		if((this.days & RepetitionsUtils.FRIDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasSaturday() {
		if((this.days & RepetitionsUtils.SATURDAY) == 1)
			return true;
		return false;
	}
	
	public boolean hasSunday() {
		if((this.days & RepetitionsUtils.SUNDAY) == 1)
			return true;
		return false;
	}
}
