package com.kony.psecu.preprocessor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;


public class PendingAndPostedPreProcessor extends BasePreProcessor implements DataPreProcessor {

 private static final Logger LOG = Logger
  .getLogger(PendingAndPostedPreProcessor.class.getName());
 @Override
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  // TODO Auto-generated method stub	
  super.execute(arg0, request, arg2);
  try {
   SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
   Date localDate = new Date();
   String toDate = localSimpleDateFormat1.format(localDate);

   Calendar calReturn = Calendar.getInstance();
   calReturn.add(Calendar.DATE, -30);
   String fromDate = localSimpleDateFormat1.format(calReturn.getTime());
   LOG.info("fromDate-> " + fromDate + " && toDate " + toDate);
   LOG.debug("fromDate-> " + fromDate + " && toDate " + toDate);
   System.out.println("fromDate-> " + fromDate + " && toDate " + toDate);
   if (arg0.get("transferFlag") != null && !arg0.get("transferFlag").equals("pendingAndPost")) {
    arg2.setParam(new Param("opstatus", "0", "String"));
    LOG.debug("In Pending and Posted before returning false");
    return false;
   } else {
    arg0.put("fromDate", fromDate);
    arg0.put("toDate", toDate);
   }
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  return true;
 }

}