package dei.gps.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="Routines")
public class Routine extends Model {
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="startTime")
	private Date startTime;
	@Column(name="endTime")
	private Date endTime;
	@Column(name="onInterval")
	private int onInterval;
	@Column(name="offInterval")
	private int offInterval;
	@Column(name="startDate")
	private Date startDate;
	@Column(name="endDate")
	private Date endDate;
	/* There's no boolean type in SQLite */
	@Column(name="active")
	private int active;
	@Column(name="repetition")
	private Repetition repetition;

	public Routine() {
		super();
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public Repetition getRepetition() {
		return repetition;
	}

	public void setRepetition(Repetition repetition) {
		this.repetition = repetition;
	}

	public void addPlug(Plug p) {
		/* Get all the Plugs of this routine */
		List<PlugsRoutines> list = getMany(PlugsRoutines.class, "routine");
		
		for(PlugsRoutines pr:list)
			if(pr.getPlug() == p)
				return;
		
		PlugsRoutines pr = new PlugsRoutines();
		pr.save();
		pr.setPlug(p);
		pr.setRoutine(this);
		/* Save to DB */
		pr.save();

	}

	public List<Plug> getPlugs() {
		List<PlugsRoutines> list = getMany(PlugsRoutines.class, "routine");
		
		List<Plug> plugs = new ArrayList<Plug>();
		for(PlugsRoutines pr:list)
			plugs.add(pr.getPlug());

		return plugs;
	}
	
	public List<Exception> getExceptions() {
		return getMany(Exception.class, "routine");
	}
}
