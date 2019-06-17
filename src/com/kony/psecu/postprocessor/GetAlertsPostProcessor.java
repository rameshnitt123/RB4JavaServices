package com.kony.psecu.postprocessor;


import java.util.ArrayList;


import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;




public class GetAlertsPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(GetAlertsPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   if (results != null) {
	   Param contactEmail = results.findParam("contactEmail");
	   Param mobileContactMethod = results.findParam("mobileContactMethod");
	   Param contactPhoneNumber = results.findParam("contactPhoneNumber");
	   Param statusCode = results.findParam("statusCode");
    ArrayList < Dataset > ds = results.getDataSets();
    LOG.info("DataSet Length: " + ds.size());
    if (ds.size() == 0) {
     LOG.debug("DataSet size is zero:");
     Dataset newDataSet = new Dataset();
     newDataSet.setId("UserAlerts");
     Record record = new Record();
     if (contactEmail != null && !"".equals(contactEmail.toString())) {
    	 record.setParam(contactEmail);
 	 }
     if (mobileContactMethod != null && !"".equals(mobileContactMethod.toString())) {
    	 record.setParam(mobileContactMethod);
 	 }
     if (contactPhoneNumber != null && !"".equals(contactPhoneNumber.toString())) {
    	 record.setParam(contactPhoneNumber);
 	 }
     if (statusCode != null && !"".equals(statusCode.toString())) {
    	 record.setParam(statusCode);
 	 }
    
     newDataSet.setRecord(record);
     results.setDataSet(newDataSet);

     LOG.debug("returning records");
    } else {
     for (Dataset dataset: ds) {
      ArrayList < Record > records = dataset.getRecords();
      LOG.info("Records Length: " + records.size());
      if (records.size() == 0) {
       LOG.info("Entered into records 0 loop");
       Record record = new Record();
       if (contactEmail != null && !"".equals(contactEmail.toString())) {
      	 record.setParam(contactEmail);
   	 }
       if (mobileContactMethod != null && !"".equals(mobileContactMethod.toString())) {
      	 record.setParam(mobileContactMethod);
   	 }
       if (contactPhoneNumber != null && !"".equals(contactPhoneNumber.toString())) {
      	 record.setParam(contactPhoneNumber);
   	 }
       if (statusCode != null && !"".equals(statusCode.toString())) {
      	 record.setParam(statusCode);
   	 }


       LOG.info("Before setting record");
       dataset.setRecord(record);
       break;
      } else {
       for (Record record: records) {
        if (records.indexOf(record) == 0) {
         ArrayList < Param > params = record.getParams();
         if (contactEmail != null && !"".equals(contactEmail.toString())) {
        	 params.add(contactEmail);
     	 }
         if (mobileContactMethod != null && !"".equals(mobileContactMethod.toString())) {
        	 params.add(mobileContactMethod);
     	 }
         if (contactPhoneNumber != null && !"".equals(contactPhoneNumber.toString())) {
        	 params.add(contactPhoneNumber);
     	 }
         if (statusCode != null && !"".equals(statusCode.toString())) {
        	 params.add(statusCode);
     	 }
        }
        break;
       }
      }
     }
    }
   }
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  return results;
 }

}