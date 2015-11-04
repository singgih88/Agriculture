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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PlantDiagnosticActivity extends Activity {

	
	private  Context context;
	private  String[] values;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_plant_diagnostic);
       ImageView imageView = (ImageView)findViewById(R.id.pest_result);
       imageView.setImageResource(R.drawable.root_aphids);
       TextView pestName = (TextView) findViewById(R.id.pest_name);
       pestName.setText("Root aphids");
       TextView pestDescription = (TextView) findViewById(R.id.pest_description);
       pestDescription.setText("Plants heavily attacked by this aphid may wilt during the day. "
       		+ "The developing heads remain soft, fail to develop properly, and yields are reduced. "
       		+ "Extremely heavy aphid populations over a prolonged period can cause collapse and death of the plant."
       		+ " Individual rootlets turn brown and die."
       		+ " Masses of white, woolly material and aphids are present on roots.");
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                .add(R.id.container, new PlaceholderFragment()).commit();
//        }
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