package ut.ee.SmartPM.lib;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.location.LocationManager;
import android.widget.TextView;

public class MyClass implements LibInterface{
	private final String libName = "GPS";
	private final String libType = "String";
	private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
	List<rulesObject<Double, Double, Double, Double, String>> locList = new ArrayList<rulesObject<Double, Double, Double, Double, String>>();

		
	@Override
	public String useMyLib(Context context, TextView autolabel, String rules) {
		
	    new parseXML(locList).execute(rules);
		
		String outLoc = "";

   		LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			outLoc = "Waiting for GPS";
			CurrentLocationListener locationListener = new CurrentLocationListener(outLoc, autolabel, locList, locationManager);
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,locationListener);    
	    }else{
	    	outLoc = "GPS is turned off";
	    }
		autolabel.setText(outLoc);
		return outLoc;
	}


	@Override
	public String getName() {
		return libName;
	}

	@Override
	public String getType() {
		return libType;
	}

}
