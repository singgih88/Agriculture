package com.expert.agriculture;

import com.expert.agriculture.plants.observation.PlantObservationActivity;
import com.expert.agriculture.plants.pests.PlantDiagnosticActivity;
import com.expert.agriculture.plants.pests.DialogActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 GridView gridview = (GridView) findViewById(R.id.gridview);
		 gridview.setAdapter(new ImageAdapter(this));
		 gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			 
          	@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
          		switch (position)
          		{
	          		case 2: 
	                {
	                	Toast.makeText(MainActivity.this, "You Clicked at "+ position, Toast.LENGTH_SHORT).show();
	                	Intent intent = new Intent(MainActivity.this, PlantObservationActivity.class);	
	                	startActivity(intent);
	                	break;
	                }
	          		case 1: 
	          		{
	          			Toast.makeText(MainActivity.this, "You Clicked at "+ position, Toast.LENGTH_SHORT).show();
	                    Intent intent = new Intent(MainActivity.this, DialogActivity.class);	
	                    startActivity(intent);
	                    break;
	          		}
	          		case 0: 
	          		{
	          			Toast.makeText(MainActivity.this, "You Clicked at "+ position, Toast.LENGTH_SHORT).show();
	                    Intent intent = new Intent(MainActivity.this, PlantDiagnosticActivity.class);	
	                    startActivity(intent);
	                    break;
	          		}
          		}
			}
         });
}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
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
}
