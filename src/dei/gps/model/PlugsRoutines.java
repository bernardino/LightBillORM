package dei.gps.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

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
