package ut.ee.SmartPM.lib;

import android.content.Context;
import android.location.LocationManager;
import android.util.Log;
import android.widget.TextView;

public class MyClass implements LibInterface{
	private final String libName = "GPS";
	private final String libType = "String";
		
	@Override
	public String useMyLib(Context context, TextView autolabel) {
		
		String outLoc = "";
//   		Log.d("LIB", "entered lib");

   		LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
//			Log.d("LIB", "GPS on");
			outLoc = "Waiting for GPS";
			CurrentLocationListener locationListener = new CurrentLocationListener(outLoc, autolabel);
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,locationListener);    
	    }else{
//	    	Log.d("LIB", "GPS off");
	    	outLoc = "GPS is turned off";
	    	autolabel.setText(outLoc);
	    }
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
