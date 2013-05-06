package dei.gps.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="Plug")
public class Plug extends Model {
	@Column(name="name")
	private String name;
	@Column(name="routine")
	private Routine routine;
	
	public Plug() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}
	
	

}
