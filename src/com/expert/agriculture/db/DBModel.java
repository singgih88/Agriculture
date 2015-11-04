package com.expert.agriculture.db;


import java.io.IOException;


import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQueryBuilder;


public class DBModel extends SQLiteAssetHelper {
	
	public SQLiteDatabase DB;
	public String DBPath;
	public static String DBName = "PlantDB";
	public static final int version = '1';
	public static Context currentContext;
	public static String tableName = "PlantParts";
	
	public DBModel(Context context) {
		super(context, DBName, null, version);
	}
	
	
	public DBModel(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	public SQLiteDatabase getDB()
	{
		return DB;
	}
	
	public int getUpgradeVersion() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"MAX (version)"};
        String sqlTables = "upgrades";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        int v = 0;
        c.moveToFirst();
        if (!c.isAfterLast()) {
            v = c.getInt(0);
        }
        c.close();
        return v;
    }


	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
		

	public void createDatabase(){
		DB = this.getReadableDatabase();
	}
			 
		 
	    @Override
		public synchronized void close() {
	 
	    	    if(DB != null)
	    	    	DB.close();
	 
	    	    super.close();
	 
		}
	    
}
