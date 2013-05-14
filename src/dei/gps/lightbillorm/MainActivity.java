package dei.gps.lightbillorm;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.activeandroid.query.Select;

import dei.gps.dao.RepetitionDAO;
import dei.gps.dao.RoutineDAO;
import dei.gps.model.Plug;
import dei.gps.model.Repetition;
import dei.gps.model.Routine;
import dei.gps.utils.Repetitions;

public class MainActivity extends Activity {
	Routine r;
	int cenas=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//getApplicationContext().deleteDatabase("LightBill.db");
		getApplicationContext().deleteDatabase("LightBill2.db");
		
		/* Vai buscar uma rotina, e se nao houver nenhuma cria */
		r = new Select().from(Routine.class).executeSingle();
		if(r==null)
			r = new Routine();
		Plug p = new Select().from(Plug.class).where("Id = ?", 3).executeSingle();
		if(p==null)
			System.out.println("P NULL");
		
		RoutineDAO routineDAO = new RoutineDAO();
		boolean ok = routineDAO.removePlugFromRoutine(p, r);
		if(!ok)
			System.out.println("BODE");
		r.save();
		
		/* Testing RepetitionsDAO */
		RepetitionDAO repetitionDAO = new RepetitionDAO();
		repetitionDAO.getRepetitionByDays(true, false, false, false, false, false, false);
		repetitionDAO.getRepetitionByDays(true, true, false, false, false, false, false);
		
		List<Repetition> list = repetitionDAO.getRepetitionsByWeekDay(Repetitions.MONDAY);
		for(Repetition r:list)
			System.out.println(r.getDays());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void cenas(View view) {
		Plug p = new Plug();
		p.setIsaId(cenas++);
		p.save();
		
		try {
			r.addPlug(p);
		} catch(Exception e) {
			
		}
		r.setEndDate(new Date(2013, 5, 10));
		r.setStartTime(new Timestamp(2014,4,12,5,12,12,12).getTime());
		
		System.out.println(new java.util.Date(2012-1900, 4, 15, 12, 12).toGMTString());
		
		Log.d("DATES", ""+r.getEndDate().toGMTString());
		Log.d("DATES", ""+new Timestamp(r.getStartTime()).toGMTString()+new Timestamp(r.getStartTime()).toLocaleString());
		Log.d("CENAS ONCLICK", ""+p.getId());
		System.out.println(new java.sql.Time(12, 12, 12).toGMTString()+new Timestamp(r.getStartTime()).toLocaleString()+new Timestamp(2014-1900,4,12,5,12,12,12).toGMTString());
		
		List<Plug> list = r.getPlugs();
		System.out.println("LIST SIZE: "+list.size());
		for(Plug pp:list)
			System.out.println(pp.getIsaId());
		
		/* Duas maneiras diferentes de ir buscar as plugs associadas a uma rotina 
		List<Plug> list = r.getPlugs();
		for(Plug p:list)
			Log.d("CENAS ONCLICK", " "+p.getId());
		list = new Select().from(Plug.class).where("routine = ?",r.getId()).execute();
		for(Plug p:list)
			Log.d("CENAS ONCLICK", ""+p.getId());
		*/
	}
}