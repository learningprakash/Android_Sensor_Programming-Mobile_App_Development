package com.GLocation.android;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


public class MainActivity extends ActionBar {

    TextView Textlat;
    TextView Textlong;
    TextView Textspeed;
    TextView Textdate;
    TextView Texttime;
    final Calendar c = Calendar.getInstance();
	locationdbadapter lh ;  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lh = new locationdbadapter(this);
           
        Textlat = (TextView)findViewById(R.id.textlat);
        Textlong = (TextView)findViewById(R.id.textlong);
        Textspeed = (TextView)findViewById(R.id.textspeed);
        Texttime = (TextView)findViewById(R.id.texttime);
        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener ll = new myLocationListener();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, ll);

     /*/ should run in every 10 sec wen location updates					
        String ts = Textlat.getText().toString();
        double la = Double.valueOf(Textlat.getText().toString()).doubleValue();
        double lo = Double.valueOf(Textlong.getText().toString()).doubleValue();
        double spd = Double.valueOf(Textspeed.getText().toString()).doubleValue();;
*/
        long id = lh.insertdata("ts",22,132,4);
        if (id<0)
        {
        	Message.message(this, "unable to save");
        }
        else
        {
        	Message.message(this, "data saved successfully");
        }
        
	}
    
    public void setcurrentdatetimeonview()
    {
    	int month, day, year, hours, min, sec, millisec;
    	year = c.get(Calendar.YEAR);
    	month = c.get(Calendar.MONTH);
    	day = c.get(Calendar.DAY_OF_MONTH);
    	hours = c.get(Calendar.HOUR_OF_DAY);
    	min = c.get(Calendar.MINUTE);
    	sec = c.get(Calendar.SECOND);
    	millisec = c.get(Calendar.MILLISECOND);
    	
    	Texttime.setText(""+(month+1)+"-"+day+"-"+year+":"+hours+":"+min+":"+sec+":"+millisec+"");
    	
    }
        class myLocationListener extends Service implements LocationListener
        
        {

			@Override
			public void onLocationChanged(Location location) {
				
				if(location != null)
				{
				
					double tlat =  location.getLatitude();
					double tlong =  location.getLongitude();
					double tspeed = location.getSpeed();
				//	long ttime = System.currentTimeMillis();
					Textspeed.setText(Double.toString(tspeed));
					Textlat.setText(Double.toString(tlat));
					Textlong.setText(Double.toString(tlong));
									
					setcurrentdatetimeonview();


				//	Texttime.setText(Long.toString(ttime));
					
				}
				else 
					Textlat.setText("You never get location");
				
			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public IBinder onBind(Intent intent) {
				// TODO Auto-generated method stub
				return null;
			}
        	
        }
        


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void addOnMenuVisibilityListener(OnMenuVisibilityListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void addTab(Tab arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void addTab(Tab arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void addTab(Tab arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void addTab(Tab arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View getCustomView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDisplayOptions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Deprecated
	public int getNavigationItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Deprecated
	public int getNavigationMode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Deprecated
	public int getSelectedNavigationIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Deprecated
	public Tab getSelectedTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharSequence getSubtitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public Tab getTabAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public int getTabCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isShowing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Deprecated
	public Tab newTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public void removeAllTabs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOnMenuVisibilityListener(OnMenuVisibilityListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void removeTab(Tab arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void removeTabAt(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void selectTab(Tab arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBackgroundDrawable(Drawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomView(View arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomView(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomView(View arg0, LayoutParams arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayHomeAsUpEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayOptions(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayOptions(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayShowCustomEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayShowHomeEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayShowTitleEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayUseLogoEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIcon(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIcon(Drawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void setListNavigationCallbacks(SpinnerAdapter arg0,
			OnNavigationListener arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogo(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogo(Drawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void setNavigationMode(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void setSelectedNavigationItem(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSubtitle(CharSequence arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSubtitle(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTitle(CharSequence arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTitle(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	} 
}
