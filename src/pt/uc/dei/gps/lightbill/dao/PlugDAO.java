package pt.uc.dei.gps.lightbill.dao;

import java.util.List;

import pt.uc.dei.gps.lightbill.model.ModelPlug;
import pt.uc.dei.gps.lightbill.model.ModelPlugsRoutines;

import com.activeandroid.query.Select;


/**
 *  This is the class to access and query the <b>Plug</b> table.
 * 
 * @author bernardino
 *
 */
public class PlugDAO {
	public ModelPlug getPlugByIsaId(int isaId) {
		return new Select().from(ModelPlug.class).where("isaId = ?", isaId).executeSingle();
	}
	
	public boolean removePlug(ModelPlug p) {
		try { 
			/* Remove plug from PlugsRoutines */
			List<ModelPlugsRoutines> list = new Select().from(ModelPlugsRoutines.class).where("plug = ?", p.getId()).execute();
			for(ModelPlugsRoutines pr:list)
				pr.delete();
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
