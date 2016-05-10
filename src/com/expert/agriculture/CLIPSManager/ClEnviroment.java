package com.expert.agriculture.CLIPSManager;

import android.util.Log;
import eu.deustotech.clips.CLIPSError;
import eu.deustotech.clips.Environment;

public class ClEnviroment {
	
	
	public static final String tag = "CLIPSTest";
	private Environment clips;
	
	public ClEnviroment( String filepath ) throws CLIPSError {
		this.clips = new Environment();
		this.clips.load(filepath);
		Log.d(ClEnviroment.tag, "Loading .clp...\n\n");
		this.clips.reset();
	}
	
	public void stop() {
		this.clips.destroy();
	}
	
	public void getRules()
	{
		Log.d(ClEnviroment.tag, this.clips.RULES);
	}
	

}
