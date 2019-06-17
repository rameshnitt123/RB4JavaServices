package com.kony.psecu.preprocessor;


import java.util.HashMap;





import org.apache.log4j.Logger;
import util.PSECUUtil;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;




public class GetATMsByAddressPreProcessor implements DataPreProcessor {

 private static final Logger LOG = Logger
  .getLogger(GetATMsByAddressPreProcessor.class.getName());
 @Override
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  // TODO Auto-generated method stub	
  try {
   if (arg0.get("atmFlag") != null && !arg0.get("atmFlag").equals("address")) {
    arg2.setParam(new Param("opstatus", "0", "String"));
    return false;
   }
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  LOG.debug("rsaDevice in ATM  Address before ----------------> " + (String) arg0.get("rsaDevice"));
  PSECUUtil utilObj = new PSECUUtil();
  String rsaDevice = (String) arg0.get("rsaDevice");
  arg0.put("rsaDevice", utilObj.modifyRSA(rsaDevice));
  LOG.debug("rsaDevice in ATM  Address after ----------------> " + (String) arg0.get("rsaDevice"));
  return true;
 }

}