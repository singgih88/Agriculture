package com.expert.agriculture.plants.observation;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

public class SingleChoiceListDialog extends DialogFragment {
	
	 private CharSequence[] mcs;
	 private String mTitle;
	 
	SingleChoiceListDialog ( String title, ArrayList<String> data)	{
		
		mcs = data.toArray(new CharSequence[data.size()]);
		mTitle = title;
	}
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(mTitle)
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // FIRE ZE MISSILES!
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               })
               .setSingleChoiceItems(mcs, 0, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Log.d("Log", "User clicked item with index " + which);
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    


}
