package com.GLocation.android;

import android.content.Context;
import android.widget.Toast;

public class Message {

	
	public static void message(Context context, String message) {
		// TODO Auto-generated method stub
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();		
	}
}
