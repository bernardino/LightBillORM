package dei.gps.lightbillorm;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.activeandroid.query.Select;

import dei.gps.model.Plug;
import dei.gps.model.Routine;

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
		r.save();
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
		
		r.addPlug(p);
		
		Log.d("CENAS ONCLICK", ""+p.getId());
		
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