package ut.ee.SmartPM.lib;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.location.LocationManager;
import android.widget.TextView;

public class MyClass implements LibInterface{
	private final String libName = "GPS";
	private final String libType = "String";
	private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 3; // in Meters
	List<rulesObject<Double, Double, Double, Double, String>> locList = new ArrayList<rulesObject<Double, Double, Double, Double, String>>();

		
	@Override
	public String useMyLib(Context context, TextView autolabel, String rules) {
		
		// Splits the string and makes it to object that we can work with 
	    for(String loc : rules.split("&")){
	    	String[] elem = loc.split("|");
	    	locList.add(new rulesObject<Double, Double, Double, Double, String>(Double.parseDouble(elem[0]), Double.parseDouble(elem[1]), Double.parseDouble(elem[2]), Double.parseDouble(elem[3]), elem[4]));
	    }
		
		String outLoc = "";

   		LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			outLoc = "Waiting for GPS";
			CurrentLocationListener locationListener = new CurrentLocationListener(outLoc, autolabel, locList);
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
