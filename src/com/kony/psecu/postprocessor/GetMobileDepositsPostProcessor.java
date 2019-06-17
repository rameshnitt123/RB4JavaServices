package com.kony.psecu.postprocessor;


import java.util.ArrayList;



import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;




public class GetMobileDepositsPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(GetMobileDepositsPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   if (results != null) {
    ArrayList < Dataset > ds = results.getDataSets();
    Param statusCodePosted = results.findParam("statusCodePosted");
    LOG.info("DataSet Length: " + ds.size());
    if (ds.size() == 0) {
        LOG.debug("DataSet size is zero:");
        Dataset newDataSet = new Dataset();
        newDataSet.setId("Transactions");
        Record record = new Record();
        if (statusCodePosted != null && !"".equals(statusCodePosted.toString())) {
       	 record.setParam(statusCodePosted);
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
         if (statusCodePosted != null && !"".equals(statusCodePosted.toString())) {
        	 record.setParam(statusCodePosted);
     	 }
        
         LOG.info("Before setting record");
         dataset.setRecord(record);
         break;
        } else{
        	
     for (Record record: records) {
    	 ArrayList < Param > params = record.getParams();
         if (records.indexOf(record) == 0) {
       	  if (statusCodePosted != null && !"".equals(statusCodePosted.toString())) {
       		  params.add(statusCodePosted);
         	 }
       	 Param transactionType = new Param();
         transactionType.setName("transactionType");
         transactionType.setValue("mobileDeposit");
         params.add(transactionType);
         }else{;

      Param transactionType = new Param();
      transactionType.setName("transactionType");
      transactionType.setValue("mobileDeposit");
      params.add(transactionType);
     }
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