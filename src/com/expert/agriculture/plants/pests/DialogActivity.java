package com.expert.agriculture.plants.pests;

import com.expert.agriculture.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DialogActivity extends Activity {

	
	private  Context context;
	private  String[] values;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.radiodialoge_view);
       ImageView imageView = (ImageView)findViewById(R.id.symt_img);
       imageView.setImageResource(R.drawable.cheved_roots);
       
       final RadioGroup rg = (RadioGroup) findViewById(R.id.radioquestion);       
       rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {      
        @Override
        public void onCheckedChanged(RadioGroup arg0, int arg1) {
         // TODO Auto-generated method stub
         int id=arg0.getCheckedRadioButtonId();
         RadioButton selectedRedioButton = (RadioButton) findViewById(id);
         Toast.makeText(getApplicationContext(), "You have selected "+selectedRedioButton.getText().toString(), Toast.LENGTH_LONG).show();
        }
       });
       
	}
}
