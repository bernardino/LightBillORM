package dei.gps.model;

import java.sql.Date;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="Exceptions")
public class Exception extends Model {
	@Column(name="routine")
	private Routine routine;
	@Column(name="startTime")
	private Date startTime;
	@Column(name="endTime")
	private Date endTime;
	@Column(name="date")
	private Date date;
	@Column(name="onInterval")
	private int onInterval;
	@Column(name="offInterval")
	private int offInterval;

	public Exception() {
		super();
	}
	
	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
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
