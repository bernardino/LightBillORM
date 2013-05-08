package dei.gps.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="Plugs")
public class Plug extends Model {
	@Column(name="ISA_ID")
	private int IsaId;
	@Column(name="TAG_ID")
	private int TagId;
	@Column(name="name")
	private String name;
	
	public Plug() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsaId() {
		return IsaId;
	}

	public void setIsaId(int isaId) {
		IsaId = isaId;
	}

	public int getTagId() {
		return TagId;
	}

	public void setTagId(int tagId) {
		TagId = tagId;
	}

}
