package ut.ee.SmartPM.lib;

import java.util.List;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CurrentLocationListener implements LocationListener {
	

	String outLoc;
	TextView autolabel;
	List<rulesObject<Double, Double, Double, Double, String>> locList;

	public CurrentLocationListener(String outLoc, TextView autolabel, List<rulesObject<Double, Double, Double, Double, String>> locList) {
		this.outLoc = outLoc;
		this.autolabel = autolabel;
		this.locList = locList;
		Log.d("LIB currentloclist",locList.toString());
	}

	@Override
	public void onLocationChanged(Location location) {
	    double lat = location.getLatitude();
	    double lon = location.getLongitude();
	    	    
	    Boolean isListed = false;
	    for (rulesObject<Double, Double, Double, Double, String> rulesObject : locList) {
			if ((lat < rulesObject.getTopLat()) && (lat > rulesObject.getBottomLat()) && (lon > rulesObject.getTopLon()) && (lon < rulesObject.getBottomLon())) {
				autolabel.setText(rulesObject.getName());
				isListed = true;
				return;
			}
		}
	    if(!isListed){
	    	outLoc = "NotMapped position: " + ("Latitude = " + lat + " Longitude = " + lon);
	    	autolabel.setText(outLoc);
	    }
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