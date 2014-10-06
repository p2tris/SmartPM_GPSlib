package ut.ee.SmartPM.lib;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CurrentLocationListener implements LocationListener {
	

	String outLoc;
	TextView autolabel;

	public CurrentLocationListener(String outLoc, TextView autolabel) {
		this.outLoc = outLoc;
		this.autolabel = autolabel;
	}

	@Override
	public void onLocationChanged(Location location) {
	    location.getLatitude();
	    location.getLongitude();

	    autolabel.setText(outLoc);
	    outLoc = ("Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude());
	    autolabel.setText(outLoc);
//	    Log.d("LOC", outLoc);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
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

}