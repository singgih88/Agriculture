package com.expert.agriculture;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TextListAdapter extends ArrayAdapter<String>{
	
	private final Activity context;
	private final ArrayList<String> itemname;
		
	public TextListAdapter(Activity context, ArrayList<String> itemname) {
		super(context, R.layout.listtext_item, itemname);
		// TODO Auto-generated constructor stub
		
		this.context=context;
		this.itemname=itemname;
	}
	
	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.listtext_item, null,true);
		
		TextView txtTitle = (TextView) rowView.findViewById(R.id.onetextLine);
				
		txtTitle.setText(itemname.get(position));		
		return rowView;
		
	};

}
