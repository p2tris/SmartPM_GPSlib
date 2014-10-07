package ut.ee.SmartPM.lib;

import java.util.Iterator;
import java.util.List;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;

public class CurrentLocationListener implements LocationListener {
	

	String outLoc;
	TextView autolabel;
	List<rulesObject<Double, Double, Double, Double, String>> locList;

	public CurrentLocationListener(String outLoc, TextView autolabel, List<rulesObject<Double, Double, Double, Double, String>> locList) {
		this.outLoc = outLoc;
		this.autolabel = autolabel;
		this.locList = locList;
	}

	@Override
	public void onLocationChanged(Location location) {
	    Double lat = location.getLatitude();
	    Double lon = location.getLongitude();

	    outLoc = ("Latitude = " + lat + " Longitude = " + lon);
	    autolabel.setText(outLoc);
	    
	    for (rulesObject<Double, Double, Double, Double, String> rulesObject : locList) {
			if ((lat < rulesObject.getTopLat()) && (lat > rulesObject.getBottomLat()) && (lon > rulesObject.getTopLon()) && (lon < rulesObject.getBottomLon())) {
				autolabel.setText(rulesObject.getName());
				return;
			}
		}
	   
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