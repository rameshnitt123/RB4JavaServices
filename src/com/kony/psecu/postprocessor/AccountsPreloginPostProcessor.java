package com.kony.psecu.postprocessor;


import java.util.ArrayList;



import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;




public class AccountsPreloginPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(AccountsPreloginPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   if (results != null) {
	   Param totalLoan = results.findParam("totalLoan");
	   Param totalShare = results.findParam("totalShare");
	   Param totalCertificate = results.findParam("totalCertificate");
	   Param statusCode = results.findParam("statusCode");
	   Param lastUpdateTimeStamp = results.findParam("lastUpdateTimeStamp");
	   
	 
    ArrayList < Dataset > ds = results.getDataSets();
    LOG.info("DataSet Length: " + ds.size());
    if (ds.size() == 0) {
     LOG.debug("DataSet size is zero:");
     Dataset newDataSet = new Dataset();
     newDataSet.setId("AccountsPrelogin");
     Record record = new Record();
     if (totalLoan != null && !"".equals(totalLoan.toString())) {
    	 record.setParam(totalLoan);
 	 }
     if (totalShare != null && !"".equals(totalShare.toString())) {
    	 record.setParam(totalShare);
 	 }
     if (totalCertificate != null && !"".equals(totalCertificate.toString())) {
    	 record.setParam(totalCertificate);
 	 }
     if (statusCode != null && !"".equals(statusCode.toString())) {
    	 record.setParam(statusCode);
 	 }
     if (lastUpdateTimeStamp != null && !"".equals(lastUpdateTimeStamp.toString())) {
    	 record.setParam(lastUpdateTimeStamp);
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
       if (totalLoan != null && !"".equals(totalLoan.toString())) {
      	 record.setParam(totalLoan);
   	 }
       if (totalShare != null && !"".equals(totalShare.toString())) {
      	 record.setParam(totalShare);
   	 }
       if (totalCertificate != null && !"".equals(totalCertificate.toString())) {
      	 record.setParam(totalCertificate);
   	 }
       if (statusCode != null && !"".equals(statusCode.toString())) {
      	 record.setParam(statusCode);
   	 }
      
       if (lastUpdateTimeStamp != null && !"".equals(lastUpdateTimeStamp.toString())) {
      	 record.setParam(lastUpdateTimeStamp);
   	 }

       LOG.info("Before setting record");
       dataset.setRecord(record);
       break;
      } else {
       for (Record record: records) {
        if (records.indexOf(record) == 0) {
         ArrayList < Param > params = record.getParams();
         if (totalLoan != null && !"".equals(totalLoan.toString())) {
        	 params.add(totalLoan);
     	 }
         if (totalShare != null && !"".equals(totalShare.toString())) {
        	 params.add(totalShare);
     	 }
         if (totalCertificate != null && !"".equals(totalCertificate.toString())) {
        	 params.add(totalCertificate);
     	 }
         if (statusCode != null && !"".equals(statusCode.toString())) {
        	 params.add(statusCode);
     	 }
         if (lastUpdateTimeStamp != null && !"".equals(lastUpdateTimeStamp.toString())) {
        	 params.add(lastUpdateTimeStamp);
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