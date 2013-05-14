package dei.gps.dao;

import java.util.List;

import com.activeandroid.query.Select;

import dei.gps.model.Plug;
import dei.gps.model.PlugsRoutines;
import dei.gps.model.Repetition;
import dei.gps.model.Routine;
import dei.gps.model.RoutineException;

/**
 * This is the class to access and query the <b>Routine</b> table.
 * 
 * @author bernardino
 *
 */
public class RoutineDAO {
	
	public Routine createRoutine() {
		Routine r = new Routine();
		/*TODO: No r.save()? And save through update method? */
		r.save();
		
		return r;
	}
	
	public boolean updateRoutine(Routine r) {
		r.save();
		return true;
	}
	
	public boolean removeRoutine(Routine r) {
		try {
			/* We also have to delete this instance from PlugsRoutines */
			List<PlugsRoutines> list = new Select().from(PlugsRoutines.class).where("routine = ?", r.getId()).execute();
			for(PlugsRoutines pr:list)
				pr.delete();
			
			/* We also have to delete this instance from RoutineExceptions */
			List<RoutineException> exceptions = new Select().from(RoutineException.class).where("routine = ?", r.getId()).execute();
			for(RoutineException re:exceptions)
				re.delete();
		} catch(Exception e) {
			return false;
		}
		r.delete();
		
		return true;
	}
	
	public Routine getRoutineByName(String name) {
		try {
			/* name is unique */
			Routine r = new Select().from(Routine.class).where("name = ?", name).executeSingle();
			return r;
		} catch(Exception e) {
			return null;
		}
	}
	
	public boolean addPlugToRoutine(Plug p, Routine r) {
		try {
			r.addPlug(p);
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean removePlugFromRoutine(Plug p, Routine r) {
		try {
			PlugsRoutines pr = new Select().from(PlugsRoutines.class).where("routine = ?", r.getId()).where("plug = ?", p.getId()).executeSingle();
			pr.delete();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean addRepetitionToRoutine(Routine routine, Repetition repetition) {
		try {
			routine.setRepetition(repetition);
			routine.save();
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean addExceptionToRoutine(Routine routine, RoutineException re ) {
		try {
			re.setRoutine(routine);
			re.save();
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
