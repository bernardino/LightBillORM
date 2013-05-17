package pt.uc.dei.gps.lightbill.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * <b>Routine</b> table representation object.
 * 
 * @author bernardino
 *
 */
@Table(name="Routines")
public class ModelRoutine extends Model {
	@Column(name="name", unique=true)
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="startTime")
	private long startTime;
	@Column(name="endTime")
	private long endTime;
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
	private ModelRepetition repetition;

	public ModelRoutine() {
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
	
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
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
	
	public ModelRepetition getRepetition() {
		return repetition;
	}

	public void setRepetition(ModelRepetition repetition) {
		this.repetition = repetition;
	}

	public void addPlug(ModelPlug p) throws java.lang.Exception {
		/* Get all the Plugs of this routine */
		List<ModelPlugsRoutines> list = getMany(ModelPlugsRoutines.class, "routine");
		
		for(ModelPlugsRoutines pr:list)
			if(pr.getPlug() == p)
				return;
		
		ModelPlugsRoutines pr = new ModelPlugsRoutines();
		pr.save();
		pr.setPlug(p);
		pr.setRoutine(this);
		/* Save to DB */
		pr.save();

	}

	public List<ModelPlug> getPlugs() {
		List<ModelPlugsRoutines> list = getMany(ModelPlugsRoutines.class, "routine");
		
		List<ModelPlug> plugs = new ArrayList<ModelPlug>();
		for(ModelPlugsRoutines pr:list)
			plugs.add(pr.getPlug());

		return plugs;
	}
	
	public List<ModelRoutineException> getExceptions() {
		return getMany(ModelRoutineException.class, "routine");
	}
}
