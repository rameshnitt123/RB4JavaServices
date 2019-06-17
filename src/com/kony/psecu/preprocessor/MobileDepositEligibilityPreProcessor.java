package com.kony.psecu.preprocessor;

import java.util.HashMap;


import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;




public class MobileDepositEligibilityPreProcessor extends BasePreProcessor implements DataPreProcessor {

 private static final Logger LOG = Logger
  .getLogger(MobileDepositEligibilityPreProcessor.class.getName());
 @Override
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  // TODO Auto-generated method stub	
  super.execute(arg0, request, arg2);
  try {
   if (arg0.get("userGetFlag") != null && !arg0.get("userGetFlag").equals("deposit")) {
    arg2.setParam(new Param("opstatus", "0", "String"));
    return false;
   }
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  return true;
 }

}