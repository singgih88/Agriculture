package com.expert.agriculture.plants.pests;
import com.expert.agriculture.R;
import com.expert.agriculture.R.id;
import com.expert.agriculture.R.layout;
import com.expert.agriculture.R.menu;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import eu.deustotech.clips.Environment;
import eu.deustotech.clips.CLIPSError;

import com.expert.agriculture.CLIPSManager.ClEnviroment;

public class PlantDiagnosticActivity extends Activity {
	private  Context context;
	private  String[] values;
	private static final String FILE_NAME = "pests.clp";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plant_diagnostic);
		// And now, basic usage...
		final TextView lbl = (TextView) findViewById(R.id.pest_name);
		lbl.setText( "CLIPS version: " + Environment.getCLIPSVersion());
		String rulesFilePath;
		try {
			rulesFilePath = getFilesDir().getAbsolutePath() + "/" + FILE_NAME;
			
			// And now, a little more complex usage...
			final ClEnviroment test = new ClEnviroment(rulesFilePath);
			test.getRules();
			test.stop();
		} catch (CLIPSError e) {
			Log.d(ClEnviroment.tag, e.getMessage());
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diagnostic_menu, menu);
		return true;
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() { }

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			return null;
		}
	}
}