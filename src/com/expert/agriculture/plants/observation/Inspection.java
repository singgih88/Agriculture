package com.expert.agriculture.plants.observation;

import com.expert.agriculture.plants.pests.Diagnosis;

public class Inspection {
	
	private boolean isSaved = false;
	private Diagnosis diagnosis;
	private State state;
	
	public Inspection(String plantName, int idTerritory)
	{
		state = new State();
		state.plantName = plantName;
		state.idTerritory = idTerritory;
	}

	private class State
	{
		public String plantName;
		public int idTerritory;
		public int size;
		public String lifeCycle;
		public String dataInspection;
		public String rootStateColor;
		public String rootStateMec;
		public String leafStateColor;
		public String leafStateMec;
		public String steamStateColor;
		public String steamStateMec;
		public String seedStateColor;
		public String seedStateMec;
		public String budStateColor;
		public String budStateMec;
		public String bearingStateColor;
		public String bearingStateMec;
		public String plantStateColor;
		public String plantStateMec;
		public String youngGroughtStateColor;
		public String youngGroughtStateMec;
			
	}
}
