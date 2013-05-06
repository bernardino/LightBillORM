package dei.gps.model;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="Routines")
public class Routine extends Model {
	@Column(name="name")
	private String name;

	public Routine() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Plug> getPlugs() {
		return getMany(Plug.class, "routine");
	}
	
	

}
