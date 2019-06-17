package com.kony.psecu.postprocessor;


import java.util.ArrayList;


import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;




public class AccountsCashFlowPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(AccountsCashFlowPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   LOG.info("Entered into Accounts cash flow postprocessor" + results);
   if (results != null) {
    LOG.info("Entered into Accounts cash flow postprocessor1");
   Param statusCode = results.findParam("statusCode");
   ArrayList < Dataset > ds = results.getDataSets();
    if (ds.size() == 0) {
     LOG.debug("DataSet size is zero:");
     Dataset newDataSet = new Dataset();
     newDataSet.setId("AccountCashFlow");
     Record record = new Record();
     if (statusCode != null && !"".equals(statusCode.toString())) {
    	 record.setParam(statusCode);
        }
     newDataSet.setRecord(record);
     results.setDataSet(newDataSet);
    } else {
      for (Dataset dataset: ds) {
      LOG.info("Entered into Accounts cash flow postprocessor3");
      ArrayList < Record > records = dataset.getRecords();
      if (records.size() == 0) {
       LOG.info("Entered into records 0 loop");
       Record record = new Record();
       if (statusCode != null && !"".equals(statusCode.toString())) {
    	   record.setParam(statusCode);
          }

       LOG.info("Before setting record");
       dataset.setRecord(record);
       break;
      } else {
       LOG.info("Records Length: " + records.size());
       for (Record record: records) {
        if (records.indexOf(record) == 0) {
         LOG.info("Entered into Accounts cash flow postprocessor4");
         ArrayList < Param > params = record.getParams();
         if (statusCode != null && !"".equals(statusCode.toString())) {
      	   params.add(statusCode);
            }
         break;
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