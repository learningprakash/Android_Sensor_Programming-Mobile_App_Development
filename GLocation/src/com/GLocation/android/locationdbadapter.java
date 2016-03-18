package com.GLocation.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class locationdbadapter {

	locationhelper helper;
	public locationdbadapter(MainActivity mainActivity) {
		// TODO Auto-generated constructor stub
		helper = new locationhelper(mainActivity);
	}
	public long insertdata( String timestamp,double latti, double longi, double speed)
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues contentvalue = new ContentValues();
		contentvalue.put(locationhelper.TIME_STAMP, timestamp);
		contentvalue.put(locationhelper.LATTITUDE, latti);
		contentvalue.put(locationhelper.LONGITUDE, longi);
		contentvalue.put(locationhelper.SPEED, speed);		      
		long id = db.insert(locationhelper.TABLE_NAME, null, contentvalue);
		return id;
	}
class locationhelper  extends SQLiteOpenHelper
{
	public locationhelper(Context mainActivity) {
			super(mainActivity,DATABASE_NAME,null,DATABASE_VERSION);
			this.context = mainActivity;
			Message.message(mainActivity, "Constructor was called");
		
	}


	private static final String DATABASE_NAME = "locationdatabase";
	private static final String TABLE_NAME ="mylocation";
	private static final int DATABASE_VERSION = 1;
	private static final String TIME_STAMP = "Time_Stamp";
	private static final String LATTITUDE ="Lattitude";
	private static final String LONGITUDE ="Longitude";
	private static final String SPEED ="Speed";
	private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+TIME_STAMP+" VARCHAR(255) primary key ,"+ LATTITUDE + " DOUBLE, "+ LONGITUDE +" DOUBLE, "+SPEED+" DOUBLE); ";
	private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
	private Context context;

	public void onCreate(SQLiteDatabase db) {
		// Create Table
		try {
			db.execSQL(CREATE_TABLE);
			Message.message(context, "On Create called");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Message.message(context, ""+e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		try {
			Message.message(context, "On Upgrade called");
			db.execSQL(DROP_TABLE);
			onCreate(db);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Message.message(context, ""+e);
		}

	}
	
}

}
