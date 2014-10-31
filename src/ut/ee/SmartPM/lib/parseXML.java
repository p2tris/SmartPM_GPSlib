package ut.ee.SmartPM.lib;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.os.AsyncTask;
import android.util.Log;

public class parseXML extends AsyncTask<String, Void, Void>{
	
	List<rulesObject<Double, Double, Double, Double, String>> locList = new ArrayList<rulesObject<Double, Double, Double, Double, String>>();

	
	public parseXML(List<rulesObject<Double, Double, Double, Double, String>> locList) {
		this.locList = locList;
	}
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
	protected void onPostExecute(Void result) {
    }

	@Override
	protected Void doInBackground(String... params) {
		// TODO Auto-generated method stub
		 try {
            URL url = new URL(params[0]);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("loc");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);
                NamedNodeMap attr = node.getAttributes();
                Double topLat = Double.parseDouble(attr.getNamedItem("topLat").getNodeValue());
                Double topLon = Double.parseDouble(attr.getNamedItem("topLon").getNodeValue());
                Double botLat = Double.parseDouble(attr.getNamedItem("botLat").getNodeValue());
                Double botLon = Double.parseDouble(attr.getNamedItem("botLon").getNodeValue());
                String name = attr.getNamedItem("value").getNodeValue();
    	    	locList.add(new rulesObject<Double, Double, Double, Double, String>(topLat, topLon, botLat, botLon, name));


	            }
	        } catch (Exception e) {
	            Log.e("GPS parseXML", "XML Pasing Excpetion = " + e);
	        }
		return null;		
		
	}

}
