package com.expert.agriculture.plants.observation;

import java.util.ArrayList;

import com.expert.agriculture.db.DBModel;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class PlanningDataProvider {

	private DBModel dbHelper;
	public PlanningDataProvider(Context context)
	{
		openDB(context);
	}

	public ArrayList<String> getPlantsList()
	{
		ArrayList<String> plant_list = new ArrayList<String>();		
		Cursor c = dbHelper.getDB().rawQuery("SELECT name_plant FROM plant", null);
		if (c != null ) {
			if (c.moveToFirst()) {
				do {
					String plant_name = c.getString(c.getColumnIndex("name_plant"));
					plant_list.add(plant_name);
				}while (c.moveToNext());
			}
		}		
		return plant_list;		
	}
	
	public ArrayList<String> getTeritoryList(String plantName)
	{
		ArrayList<String> teritory_list = new ArrayList<String>();		
		Cursor c = dbHelper.getDB().rawQuery("SELECT id_teritory FROM planting WHERE name_plant = '" + plantName + "'", null);
		if (c != null ) {
			if (c.moveToFirst()) {
				do {
					String teritory_id = c.getString(c.getColumnIndex("id_teritory"));
					teritory_list.add(teritory_id);
				}while (c.moveToNext());
			}
		}		
		return teritory_list;		
	}	
	
	private void openDB(Context context)
	{
		dbHelper = new DBModel(context);
		dbHelper.createDatabase();
	}
	
	

}
