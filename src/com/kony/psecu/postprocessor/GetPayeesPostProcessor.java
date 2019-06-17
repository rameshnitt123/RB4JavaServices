package com.kony.psecu.postprocessor;


import java.util.ArrayList;



import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;




public class GetPayeesPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(GetPayeesPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   if (results != null) {
    ArrayList < Dataset > ds = results.getDataSets();
  
    Param nextAvailablePaymentDate = results.findParam("nextAvailablePaymentDate");
	   Param statusCode = results.findParam("statusCode");
	   
    LOG.debug("DataSet Length in getPayees post processor" + ds.size());
    if (ds.size() == 0) {
     LOG.debug("DataSet size is zero:");
     Dataset newDataSet = new Dataset();
     newDataSet.setId("Payee");
     Record record = new Record();
     if (statusCode != null && !"".equals(statusCode.toString())) {
    	 record.setParam(statusCode);
 	 }
     if (nextAvailablePaymentDate != null && !"".equals(nextAvailablePaymentDate.toString())) {
    	 record.setParam(nextAvailablePaymentDate);
 	 }

     newDataSet.setRecord(record);


     results.setDataSet(newDataSet);

     LOG.debug("returning records");
    } else {
     for (Dataset dataset: ds) {

      ArrayList < Record > records = dataset.getRecords();
      LOG.info("Records Length in getPayees post processor--------------> " + records.size());
      if (records.size() == 0) {
       LOG.info("Entered into records 0 loop");
       Record record = new Record();
       if (statusCode != null && !"".equals(statusCode.toString())) {
      	 record.setParam(statusCode);
   	 }
       if (nextAvailablePaymentDate != null && !"".equals(nextAvailablePaymentDate.toString())) {
      	 record.setParam(nextAvailablePaymentDate);
   	 }
       LOG.info("Before setting record");
       dataset.setRecord(record);
       break;
      } else {


       for (Record record: records) {
        LOG.info("Before");

        LOG.info("After");
        if (records.indexOf(record) == 0) {
         ArrayList < Param > params = record.getParams();
         LOG.info("In records 0");
         if (statusCode != null && !"".equals(statusCode.toString())) {
        	 params.add(statusCode);
     	 }
         if (nextAvailablePaymentDate != null && !"".equals(nextAvailablePaymentDate.toString())) {
        	 params.add(nextAvailablePaymentDate);
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