package com.kony.psecu.preprocessor;


import java.util.HashMap;


import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;




public class EditDisclosurePreProcessor extends BasePreProcessor implements DataPreProcessor {

 private static final Logger LOG = Logger
  .getLogger(EditDisclosurePreProcessor.class.getName());
 @Override
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  super.execute(arg0, request, arg2);
  // TODO Auto-generated method stub	
  try {
   if (arg0.get("updateFlag") != null && !arg0.get("updateFlag").equals("disclosure")) {
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