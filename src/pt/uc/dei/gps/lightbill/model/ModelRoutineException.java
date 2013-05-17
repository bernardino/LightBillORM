package pt.uc.dei.gps.lightbill.model;

import java.sql.Date;
import java.sql.Time;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * <b>RoutineException</b> table representation object. This object has its respective Routine object.
 * 
 * @author bernardino
 *
 */
@Table(name="Exceptions")
public class ModelRoutineException extends Model {
	@Column(name="routine")
	private ModelRoutine routine;
	@Column(name="startTime")
	private Time startTime;
	@Column(name="endTime")
	private Time endTime;
	@Column(name="date")
	private Date date;
	@Column(name="onInterval")
	private int onInterval;
	@Column(name="offInterval")
	private int offInterval;

	public ModelRoutineException() {
		super();
	}
	
	public ModelRoutine getRoutine() {
		return this.routine;
	}

	public void setRoutine(ModelRoutine routine) {
		this.routine = routine;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOnInterval() {
		return onInterval;
	}

	public void setOnInterval(int onInterval) {
		this.onInterval = onInterval;
	}

	public int getOffInterval() {
		return offInterval;
	}

	public void setOffInterval(int offInterval) {
		this.offInterval = offInterval;
	}
}
