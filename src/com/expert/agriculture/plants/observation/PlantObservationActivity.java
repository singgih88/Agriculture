package com.expert.agriculture.plants.observation;
import java.io.IOException;
import java.util.ArrayList;

import com.expert.agriculture.TextPicListAdapter;
import com.expert.agriculture.R;
import com.expert.agriculture.db.DBModel;


import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class PlantObservationActivity extends Activity {
	
	private ListView categoriesView ;
	private ArrayList<String> itemnames = new ArrayList<String>();
	private ArrayList<Integer> imgids = new ArrayList<Integer>();
	private String tableName = "plant";
		
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	   	 
    	openAndQueryDatabase();  	
    	
    	setContentView(R.layout.listview);
    	categoriesView  = (ListView) findViewById(R.id.list);
    	TextPicListAdapter adapter = new TextPicListAdapter(this, itemnames, imgids);    	    	
    	categoriesView.setAdapter(adapter);
    	
    	categoriesView.setOnItemClickListener(new OnItemClickListener() {
    		@Override
    		public void onItemClick(AdapterView<?> parent, View view,
    				int position, long id) {
    			     int itemPosition     = position;
    			// ListView Clicked item value
    			String  itemValue    = (String) categoriesView.getItemAtPosition(position);
    			Toast.makeText(getApplicationContext(),
    					"Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
    					.show();
    			}

    	}); 
    }
	
    
	private void openAndQueryDatabase() {

		DBModel dbHelper = new DBModel(this.getApplicationContext());
		dbHelper.createDatabase();

		Toast.makeText(getApplicationContext(), "DB recieved " , Toast.LENGTH_LONG).show();

		Cursor c = dbHelper.getDB().rawQuery("SELECT name_plant FROM " + 	tableName, null);
		if (c != null ) {
			if (c.moveToFirst()) {
				do {
					String plant_name = c.getString(c.getColumnIndex("name_plant"));
					itemnames.add(plant_name);
				}while (c.moveToNext());
			}
		}
		c = dbHelper.getDB().rawQuery("SELECT picture_plant FROM " + 	tableName, null);
		if (c != null ) {
			if (c.moveToFirst()) {
				do {
					String plantPicture = c.getString(c.getColumnIndex("picture_plant"));
					int id = getResources().getIdentifier(plantPicture, "drawable", getBaseContext().getPackageName());
					imgids.add(id);    					
				}while (c.moveToNext());
			}
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
//              View rootView = inflater.inflate(R.layout.fragment_display_message,
//                      container, false);
//              return rootView;
        	return null;
        }
    }
}