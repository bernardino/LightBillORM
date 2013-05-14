package dei.gps.dao;

import java.util.List;

import com.activeandroid.query.Select;

import dei.gps.model.Plug;
import dei.gps.model.PlugsRoutines;

/**
 *  This is the class to access and query the <b>Plug</b> table.
 * 
 * @author bernardino
 *
 */
public class PlugDAO {
	public Plug getPlugByIsaId(int isaId) {
		return new Select().from(Plug.class).where("isaId = ?", isaId).executeSingle();
	}
	
	public boolean removePlug(Plug p) {
		try { 
			/* Remove plug from PlugsRoutines */
			List<PlugsRoutines> list = new Select().from(PlugsRoutines.class).where("plug = ?", p.getId()).execute();
			for(PlugsRoutines pr:list)
				pr.delete();
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
