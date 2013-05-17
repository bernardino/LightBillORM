package pt.uc.dei.gps.lightbill.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;


/**
 * <b>PlugsRoutines</b> table representation object. This is the table to store
 * the <i>many-to-many</i> relationship between plugs and routines.
 * 
 * @author bernardino
 *
 */
@Table(name="PlugsRoutines")
public class ModelPlugsRoutines extends Model {
	@Column(name="plug")
	private ModelPlug plug;
	@Column(name="routine")
	private ModelRoutine routine;
	
	public ModelPlugsRoutines(){
		super();
	}

	public ModelPlug getPlug() {
		return plug;
	}

	public void setPlug(ModelPlug plug) {
		this.plug = plug;
	}

	public ModelRoutine getRoutine() {
		return routine;
	}

	public void setRoutine(ModelRoutine routine) {
		this.routine = routine;
	}
	
	
}
