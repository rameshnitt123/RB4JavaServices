package com.kony.psecu.postprocessor;


import java.util.ArrayList;




import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;




public class GetPendingMobileDepositPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(GetPendingMobileDepositPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   if (results != null) {
    ArrayList < Dataset > ds = results.getDataSets();
    Param errmsg = results.findParam("errmsg");
    LOG.info("DataSet Length: " + ds.size());
    if (ds.size() == 0) {
     LOG.debug("DataSet size is zero:");
     Dataset newDataSet = new Dataset();
     newDataSet.setId("Transactions");
     Record record = new Record();
     if (errmsg != null && !"".equals(errmsg.toString())) {
    	 record.setParam(errmsg);
 	 }

     newDataSet.setRecord(record);


     results.setDataSet(newDataSet);

     LOG.debug("returning records");
    } else {
     for (Dataset dataset: ds) {
      ArrayList < Record > records = dataset.getRecords();
      LOG.info("Records Length: " + records.size());
      for (Record record: records) {


       if (records.indexOf(record) == 0) {
        ArrayList < Param > params = record.getParams();
        if (errmsg != null && !"".equals(errmsg.toString())) {
       	 params.add(errmsg);
    	 }

        Param transactionType = new Param();
        transactionType.setName("transactionType");
        transactionType.setValue("pendingMobileDeposit");
        params.add(transactionType);
       }
       break;
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