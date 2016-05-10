package com.expert.agriculture;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View gridView;
    	LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
        	gridView = new  View(mContext);
        	
        	gridView = inflater.inflate(R.layout.grid_single, null);
        	ImageView imageView = (ImageView)gridView.findViewById(R.id.grid_image);
            imageView.setImageResource(mThumbIds[position]);
            TextView textView = (TextView) gridView.findViewById(R.id.grid_text);
            textView.setText(mPackages[position]);
           
        } else {
        	gridView = (View) convertView;
        }
       
        return gridView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2,  R.drawable.sample_3
            
    };
    
    // references to our images
    private String [] mPackages = {
            "Plant Pests Diagnostic", "Plant Diseases",
            "Plant Monitoring", "System Maintenance"
    };

}