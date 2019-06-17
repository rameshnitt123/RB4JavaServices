package util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PSECUUtil {

 public String modifyRSA(String rsaDevice) {

  //rsaDevice = "{ \"CellTowerId\": \"21869488\", \"DeviceSystemVersion\": \"18\", \"SDK_VERSION\": \"3.7.0\", \"DeviceName\": \"Vertical Apps (GT-I930\", \"WiFiMacAddress\": \"10:A5:D0:19:B4:BD\", \"RSA_ApplicationKey\": \"2B4420ACB83E196D3D298DAC2A8A0C1C\", \"Emulator\": 0, \"MNC\": \"49\", \"LocationAreaCode\": \"5302\", \"OS_ID\": \"2d69d4fa4325925c\", \"MultitaskingSupported\": true, \"Languages\": \"en\", \"DeviceModel\": \"GT-I9300\", \"GeoLocationInfo\": [ { \"Status\": \"0\", \"Latitude\": \"17.4481848\", \"Longitude\": \"78.371138\", \"Timestamp\": \"1493988779660\", \"HorizontalAccuracy\": \"32\" } ], \"DeviceSystemName\": \"Android\", \"Compromised\": 0, \"ScreenSize\": \"720x1280\", \"WiFiNetworksData\": { \"SSID\": \"Kony_Device\", \"Channel\": \"null\", \"SignalStrength\": \"-57\", \"BBSID\": \"2c:e6:cc:5d:ed:e9\" }, \"MCC\": \"404\", \"TIMESTAMP\": \"2017-05-05T12:54:35Z\", \"HardwareID\": \"358422051142275\" }";
  //System.out.println("rsaDevice---->" + rsaDevice);
  JSONObject jsonObj = null;
  try {
   jsonObj = new JSONObject(rsaDevice);
   if (jsonObj.has("DeviceName")) {
    String DeviceName = jsonObj.getString("DeviceName");
    if (DeviceName != null) {
     jsonObj.put("DeviceName", DeviceName.replaceAll("[^A-Za-z0-9 ]", ""));
    }
   }
   if (jsonObj.has("WiFiNetworksData")) {
    JSONObject WiFiNetworksData = jsonObj.getJSONObject("WiFiNetworksData");
    if (WiFiNetworksData != null) {
     if (WiFiNetworksData.has("SSID")) {
      String SSID = WiFiNetworksData.getString("SSID");
      if (SSID != null) {
       WiFiNetworksData.put("SSID", SSID.replaceAll("[^A-Za-z0-9 ]", ""));
      }
     }
     if (WiFiNetworksData.has("BBSID")) {
      String BBSID = WiFiNetworksData.getString("BBSID");
      if (BBSID != null) {
       WiFiNetworksData.put("BBSID", BBSID.replaceAll("[^A-Za-z0-9 ]", ""));
      }
     }
     if (WiFiNetworksData.has("StationName")) {
      String StationName = WiFiNetworksData.getString("StationName");
      if (StationName != null) {
       WiFiNetworksData.put("StationName", StationName.replaceAll("[^A-Za-z0-9 ]", ""));
      }
     }
     jsonObj.put("WiFiNetworksData", WiFiNetworksData);

    }

   }
  } catch (JSONException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  System.out.println("jsonObj--->" + jsonObj.toString());
  return jsonObj.toString();
 }

 public String phoneCollectionToJson(String inputPhoneNUmberCollection) {
	 JSONArray phoneNumberCollection = null;
	 try {
		 System.out.println("PhoneNumber Collection from request is--->" + inputPhoneNUmberCollection); 
		 phoneNumberCollection = new JSONArray(inputPhoneNUmberCollection);
		 
	 }
	 catch(JSONException e) {
		 e.printStackTrace(); 
	 }
     
	 System.out.println("PhoneNumber Collection jsonObj--->" + phoneNumberCollection.toString());
	 return phoneNumberCollection.toString();
  }
}