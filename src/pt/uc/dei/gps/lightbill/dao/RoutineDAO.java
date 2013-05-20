package pt.uc.dei.gps.lightbill.dao;

import java.util.List;

import pt.uc.dei.gps.lightbill.model.ModelPlug;
import pt.uc.dei.gps.lightbill.model.ModelPlugsRoutines;
import pt.uc.dei.gps.lightbill.model.ModelRepetition;
import pt.uc.dei.gps.lightbill.model.ModelRoutine;
import pt.uc.dei.gps.lightbill.model.ModelRoutineException;

import com.activeandroid.query.Select;


/**
 * This is the class to access and query the <b>Routine</b> table.
 * 
 * @author bernardino
 *
 */
public class RoutineDAO {
	
	public ModelRoutine createRoutine() {
		ModelRoutine r = new ModelRoutine();
		/*TODO: No r.save()? And save through update method? */
		/*TODO: Verify overlaping routines! */
		r.save();
		
		return r;
	}
	
	public boolean updateRoutine(ModelRoutine r) {
		r.save();
		return true;
	}
	
	public boolean removeRoutine(ModelRoutine r) {
		try {
			/* We also have to delete this instance from PlugsRoutines */
			List<ModelPlugsRoutines> list = new Select().from(ModelPlugsRoutines.class).where("routine = ?", r.getId()).execute();
			for(ModelPlugsRoutines pr:list)
				pr.delete();
			
			/* We also have to delete this instance from RoutineExceptions */
			List<ModelRoutineException> exceptions = new Select().from(ModelRoutineException.class).where("routine = ?", r.getId()).execute();
			for(ModelRoutineException re:exceptions)
				re.delete();
		} catch(Exception e) {
			return false;
		}
		r.delete();
		
		return true;
	}
	
	public ModelRoutine getRoutineByName(String name) {
		try {
			/* name is unique */
			ModelRoutine r = new Select().from(ModelRoutine.class).where("name = ?", name).executeSingle();
			return r;
		} catch(Exception e) {
			return null;
		}
	}
	
	public boolean addPlugToRoutine(ModelPlug p, ModelRoutine r) {
		try {
			r.addPlug(p);
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean removePlugFromRoutine(ModelPlug p, ModelRoutine r) {
		try {
			ModelPlugsRoutines pr = new Select().from(ModelPlugsRoutines.class).where("routine = ?", r.getId()).where("plug = ?", p.getId()).executeSingle();
			pr.delete();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean addRepetitionToRoutine(ModelRoutine routine, ModelRepetition repetition) {
		try {
			routine.setRepetition(repetition);
			routine.save();
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean addExceptionToRoutine(ModelRoutine routine, ModelRoutineException re ) {
		try {
			re.setRoutine(routine);
			re.save();
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
