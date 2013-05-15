package dei.gps.model;

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
public class PlugsRoutines extends Model {
	@Column(name="plug")
	private Plug plug;
	@Column(name="routine")
	private Routine routine;
	
	public PlugsRoutines(){
		super();
	}

	public Plug getPlug() {
		return plug;
	}

	public void setPlug(Plug plug) {
		this.plug = plug;
	}

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}
	
	
}
