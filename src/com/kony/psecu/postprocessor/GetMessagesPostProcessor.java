package com.kony.psecu.postprocessor;


import java.util.ArrayList;



import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Dataset;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;




public class GetMessagesPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(GetMessagesPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   if (results != null) {
    ArrayList < Dataset > ds = results.getDataSets();
    Param inboxMessageCount = results.findParam("inboxMessageCount");
	   Param unreadMessageCount = results.findParam("unreadMessageCount");
	   Param sentMessageCount = results.findParam("sentMessageCount");
	   Param statusCode = results.findParam("statusCode");
    LOG.info("DataSet Length: " + ds.size());
    if (ds.size() == 0) {
     LOG.debug("DataSet size is zero:");
     Dataset newDataSet = new Dataset();
     newDataSet.setId("Messages");
     Record record = new Record();
     if (inboxMessageCount != null && !"".equals(inboxMessageCount.toString())) {
    	 record.setParam(inboxMessageCount);
 	 }
     if (unreadMessageCount != null && !"".equals(unreadMessageCount.toString())) {
    	 record.setParam(unreadMessageCount);
 	 }
     if (sentMessageCount != null && !"".equals(sentMessageCount.toString())) {
    	 record.setParam(sentMessageCount);
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
    	   Record record = new Record();
    	   if (inboxMessageCount != null && !"".equals(inboxMessageCount.toString())) {
    		   record.setParam(inboxMessageCount);
    	 	 }
    	     if (unreadMessageCount != null && !"".equals(unreadMessageCount.toString())) {
    	    	 record.setParam(unreadMessageCount);
    	 	 }
    	     if (sentMessageCount != null && !"".equals(sentMessageCount.toString())) {
    	    	 record.setParam(sentMessageCount);
    	 	 }
    	     if (statusCode != null && !"".equals(statusCode.toString())) {
    	    	 record.setParam(statusCode);
    	 	 }
    	     break;
       }
       else {
    	   for (Record record: records) {
    	        if (records.indexOf(record) == 0) {
    	        	 ArrayList < Param > params = record.getParams();
    	        	 if (inboxMessageCount != null && !"".equals(inboxMessageCount.toString())) {
    	               	 params.add(inboxMessageCount);
    	            	 }
    	                if (unreadMessageCount != null && !"".equals(unreadMessageCount.toString())) {
    	                	params.add(unreadMessageCount);
    	            	 }
    	                if (sentMessageCount != null && !"".equals(sentMessageCount.toString())) {
    	                	params.add(sentMessageCount);
    	            	 }
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