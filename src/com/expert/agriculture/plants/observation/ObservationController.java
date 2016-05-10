package com.expert.agriculture.plants.observation;

import java.util.ArrayList;

import android.content.Context;

public class ObservationController {
	
	private ArrayList<String> plantList;
	private PlanningDataProvider planningDataProvider;
	
	public ObservationController(Context context)
	{
		planningDataProvider = new PlanningDataProvider(context);
		plantList = planningDataProvider.getPlantsList();
	}
	
	public ArrayList<String> getPlantList()
	{
		return plantList;
	}
	
	public ArrayList<String> getTeritoryList(String plantName)
	{
		return planningDataProvider.getTeritoryList(plantName);
	}

}
