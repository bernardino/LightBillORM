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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getApplicationContext().deleteDatabase("LightBill.db");
		
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
		Plug c = new Plug();
		c.setRoutine(r);
		c.save();
		
		Log.d("CENAS ONCLICK", ""+c.getId());
		
		/* Duas maneiras diferentes de ir buscar as plugs associadas a uma rotina */
		List<Plug> list = r.getPlugs();
		for(Plug p:list)
			Log.d("CENAS ONCLICK", " "+p.getId());
		list = new Select().from(Plug.class).where("routine = ?",r.getId()).execute();
		for(Plug p:list)
			Log.d("CENAS ONCLICK", ""+p.getId());
	}
}