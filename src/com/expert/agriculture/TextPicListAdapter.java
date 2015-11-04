package com.expert.agriculture;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TextPicListAdapter extends ArrayAdapter<String>{
	
	private final Activity context;
	private final ArrayList<String> itemname;
	private final ArrayList<Integer> imgid;
	
	public TextPicListAdapter(Activity context, ArrayList<String> itemname, ArrayList<Integer> imgid) {
		super(context, R.layout.listview_item, itemname);
		// TODO Auto-generated constructor stub
		
		this.context=context;
		this.itemname=itemname;
		this.imgid=imgid;
	}
	
	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.listview_item, null,true);
		
		TextView txtTitle = (TextView) rowView.findViewById(R.id.textLine);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		
		txtTitle.setText(itemname.get(position));
		imageView.setImageResource(imgid.get(position));			
		return rowView;
		
	};

}
