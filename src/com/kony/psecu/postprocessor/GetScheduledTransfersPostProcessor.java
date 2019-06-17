package com.kony.psecu.postprocessor;


import java.util.ArrayList;



import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;




public class GetScheduledTransfersPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(GetScheduledTransfersPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   if (results != null) {
    ArrayList < Dataset > ds = results.getDataSets();
    Param statusCode = results.findParam("statusCode");
    LOG.info("DataSet Length: " + ds.size());
    if (ds.size() == 0) {
     LOG.debug("DataSet size is zero:");
     Dataset newDataSet = new Dataset();
     newDataSet.setId("Transactions");
     Record record = new Record();
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
          if (statusCode != null && !"".equals(statusCode.toString())) {
         	 record.setParam(statusCode);
      	 }
         
          LOG.info("Before setting record");
          dataset.setRecord(record);
          break;
         } else{
      for (Record record: records) {
       ArrayList < Param > params = record.getParams();
       if (records.indexOf(record) == 0) {

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