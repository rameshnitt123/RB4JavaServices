package com.kony.psecu.preprocessor;


import java.util.HashMap;
import org.apache.log4j.Logger;
import util.PSECUUtil;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;




public class GetApplicationPropertiesPreProcessor implements DataPreProcessor {

 private static final Logger LOG = Logger
  .getLogger(GetApplicationPropertiesPreProcessor.class.getName());
 @Override
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  // TODO Auto-generated method stub	
  LOG.debug("RsaDevice---->" + arg0.get("rsaDevice"));
  LOG.debug("applicationFlag in app properties------>" + arg0.get("applicationFlag"));
  try {
   if (arg0.get("applicationFlag") != null && !arg0.get("applicationFlag").equals("app") && !arg0.get("applicationFlag").equals("application") ) {
    arg2.setParam(new Param("opstatus", "0", "String"));
    return false;
   }
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  LOG.debug("rsaDevice in Application before ----------------> " + (String) arg0.get("rsaDevice"));
  PSECUUtil utilObj = new PSECUUtil();
  String rsaDevice = (String) arg0.get("rsaDevice");
  arg0.put("rsaDevice", utilObj.modifyRSA(rsaDevice));
  LOG.debug("rsaDevice in Application after ----------------> " + (String) arg0.get("rsaDevice"));
  return true;
 }



}