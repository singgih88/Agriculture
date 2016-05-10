package com.expert.agriculture.plants.observation;
import java.io.IOException;
import java.util.ArrayList;
import com.expert.agriculture.TextPicListAdapter;
import com.expert.agriculture.R;
import com.expert.agriculture.TextListAdapter;

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
	
	private ListView mCategoriesView ;
	private ArrayList<String> mItemNames; 
	private ObservationController mObsController;

		
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	   	 
    	mObsController = new  ObservationController(getApplicationContext());	
    	mItemNames = mObsController.getPlantList();
    	setContentView(R.layout.listview);
    	mCategoriesView  = (ListView) findViewById(R.id.list);
    	TextListAdapter adapter = new TextListAdapter(this, mItemNames);    	    	
    	mCategoriesView.setAdapter(adapter);
    	
    	mCategoriesView.setOnItemClickListener(new OnItemClickListener() {
    		@Override
    		public void onItemClick(AdapterView<?> parent, View view,
    				int position, long id) {
    			     int itemPosition     = position;
    			// ListView Clicked item value
    			String  itemValue    = (String) mCategoriesView.getItemAtPosition(position);
    			Toast.makeText(getApplicationContext(),
    					"Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
    			.show();
    			ArrayList<String> teritoryList = mObsController.getTeritoryList(itemValue);
    			if (teritoryList.size() == 1)
    			{
    				//startPlantObservation();
    			}
    			else
    			{
    				showTeritoryDialog(teritoryList);
    			}    			
    		}

    	}); 
	}

    private void showTeritoryDialog(ArrayList<String> teritoryList)
    {
    	SingleChoiceListDialog teritoryDialog = new SingleChoiceListDialog("Choose teritory", teritoryList);
    	teritoryDialog.show(getFragmentManager(), "Teritory");
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