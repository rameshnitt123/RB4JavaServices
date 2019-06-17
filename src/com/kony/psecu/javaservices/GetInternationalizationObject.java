package com.kony.psecu.javaservices;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.io.InputStream;
import org.apache.log4j.Logger;
import com.konylabs.middleware.common.JavaService;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;

public class GetInternationalizationObject implements JavaService {
 private static final Logger LOG = Logger.getLogger(GetInternationalizationObject.class);
 @Override
 public Object invoke(String serviceId, Object[] arg1) throws Exception {
  Result result = new Result();
  try {
   HashMap < String, Object > requestObj = (HashMap < String, Object > ) arg1[1];
   if ("Fetchi18Dynamically".equals(serviceId)) {
    result.setParam(new Param("opstatus", "0", "String"));
   }else if ("Fetchi18nConfigPropertiesDynamically".equals(serviceId)){
	   LOG.debug("serviceId in Fetchi18nConfigPropertiesDynamically--------->" + serviceId );
	   result.setParam(new Param("opstatus", "0", "String"));
   }else if ("FetchTabi18nConfigPropertiesDynamically".equals(serviceId)){
	   LOG.debug("serviceId in FetchTabi18nConfigPropertiesDynamically--------->" + serviceId );
	   result.setParam(new Param("opstatus", "0", "String"));
   }
  } catch (Exception e) {
   System.out.println(" Error in the java service :::" + e.getMessage());
  }
  return result;
 }


 public Result Fetchi18Dynamically(Result result) {
  try {
   Properties properties = new Properties();
   LOG.debug("Before InputStream");
   InputStream inputStream = getClass().getResourceAsStream("i18n.properties");
   LOG.debug("After InputStream " + inputStream.read());
   properties.load(inputStream);
   LOG.debug("IN  Fetchi18Dynamically ");
   Enumeration < Object > enuKeys = properties.keys();
   while (enuKeys.hasMoreElements()) {
    String key = (String) enuKeys.nextElement();
    String value = properties.getProperty(key);
    result.setParam(new Param(key, value, "String"));
    System.out.println(key + ": " + value);
   }
   LOG.debug("Added all properties of i18 ");
  } catch (FileNotFoundException e) {
   LOG.debug("Exception FileNotFoundException");
   e.printStackTrace();
  } catch (IOException e) {
   LOG.debug("Exception IOException");
   e.printStackTrace();
  }
  return result;

 }

 public Result Fetchi18nConfigPropertiesDynamically(Result result, DataControllerRequest dcReq) {
  try {
   String currTimeStamp = "";
   if (dcReq.getParameter("currentTimeStamp") != null) {
    currTimeStamp = (String) dcReq.getParameter("currentTimeStamp");
   }


   //Timestamp currentTimeStamp = new Timestamp(1513160691395L);
   Timestamp currentTimeStamp = new Timestamp(Long.parseLong(currTimeStamp));
   LOG.debug("value passed from app currtTimeStamp: " + currentTimeStamp);
   URL url = getClass().getResource("i18nNew.properties");
   Timestamp modifiedTimeStamp = new Timestamp(url.openConnection().getLastModified());
   LOG.debug("File modifiedTimeStamp: " + modifiedTimeStamp);

   Dataset i18n = new Dataset("i18n");
   ArrayList < Record > records = new ArrayList < Record > ();

   if (modifiedTimeStamp.compareTo(currentTimeStamp) > 0) {
    LOG.debug("In Compare loop");
    Properties properties = new Properties();

    LOG.debug("Before InputStream");
    InputStream inputStream = getClass().getResourceAsStream("i18nNew.properties");
    LOG.debug("After InputStream " + inputStream.read());
    properties.load(inputStream);
    LOG.debug("IN  Fetchi18Dynamically ");

    Enumeration < Object > enuKeys = properties.keys();
    while (enuKeys.hasMoreElements()) {
     String key = (String) enuKeys.nextElement();
     String value = properties.getProperty(key);
     //result.setParam(new Param(key, value,"String"));

     Record record = new Record();

     record.setParam(new Param("i18nKey", key, "String"));
     record.setParam(new Param("i18nValue", value, "String"));
     records.add(record);

     System.out.println(key + ": " + value);
    }
    i18n.setRecords(records);
    result.setDataSet(i18n);
   } else {
    i18n.setRecords(records); //blank records
    result.setDataSet(i18n);
   }
   LOG.debug("Added all properties of i18 ");
  }

  catch (FileNotFoundException e) {
   LOG.debug("Exception FileNotFoundException");
   e.printStackTrace();
  } catch (IOException e) {
   LOG.debug("Exception IOException");
   e.printStackTrace();
  }
  return result;

 }

 public Result FetchTabi18nConfigPropertiesDynamically(Result result, DataControllerRequest dcReq) {
	  try {
	   String currentTabTimeStamp = "";
	   LOG.debug("currentTabTimeStamp--------->" + dcReq.getParameter("currentTabTimeStamp"));
	   if (dcReq.getParameter("currentTabTimeStamp") != null) {
		   currentTabTimeStamp = (String) dcReq.getParameter("currentTabTimeStamp");
		   //Timestamp currentTimeStamp = new Timestamp(1513160691395L);
		   Timestamp currentTimeStamp = new Timestamp(Long.parseLong(currentTabTimeStamp));
		   LOG.debug("value passed from app currtTimeStamp: " + currentTimeStamp);
		   URL url = getClass().getResource("i18nTablets.properties");
		   Timestamp modifiedTimeStamp = new Timestamp(url.openConnection().getLastModified());
		   LOG.debug("File modifiedTimeStamp: " + modifiedTimeStamp + "long time stamp ------>" + modifiedTimeStamp.getTime() );

		   Dataset i18n = new Dataset("i18n");
		   ArrayList < Record > records = new ArrayList < Record > ();

		   if (modifiedTimeStamp.compareTo(currentTimeStamp) > 0) {
		    LOG.debug("In Compare loop");
		    Properties properties = new Properties();

		    LOG.debug("Before InputStream");
		    InputStream inputStream = getClass().getResourceAsStream("i18nTablets.properties");
		    LOG.debug("After InputStream " + inputStream.read());
		    properties.load(inputStream);
		    LOG.debug("IN  Fetchi18Dynamically ");

		    Enumeration < Object > enuKeys = properties.keys();
		    while (enuKeys.hasMoreElements()) {
		     String key = (String) enuKeys.nextElement();
		     String value = properties.getProperty(key);

		     Record record = new Record();

		     record.setParam(new Param("i18nKey", key, "String"));
		     record.setParam(new Param("i18nValue", value, "String"));
		     records.add(record);

		     System.out.println(key + ": " + value);
		    }
		    i18n.setRecords(records);
		    result.setDataSet(i18n);
		   } else {
		    i18n.setRecords(records); //blank records
		    result.setDataSet(i18n);
		   }
		   LOG.debug("Added all properties of i18 ");
		
	   }  }
	  catch (FileNotFoundException e) {
		   LOG.debug("Exception FileNotFoundException");
		   e.printStackTrace();
		  } catch (IOException e) {
		   LOG.debug("Exception IOException");
		   e.printStackTrace();
		  }catch(Exception e){
			  LOG.debug("Exception IOException");
			   e.printStackTrace();
		  }


	  
	  return result;

	 }
 
}