package com.kony.psecu.preprocessor;


import java.util.HashMap;


import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;

import util.PSECUUtil;




public class EditProfilePreProcessor extends BasePreProcessor implements DataPreProcessor {

 private static final Logger LOG = Logger
  .getLogger(EditProfilePreProcessor.class.getName());
 @Override
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  // TODO Auto-generated method stub
  super.execute(arg0, request, arg2);
  try {
   if (arg0.get("createFlag") != null && !arg0.get("createFlag").equals("profile")) {
    arg2.setParam(new Param("opstatus", "0", "String"));
    return false;
   }
   LOG.debug("phoneNumberCollection in EditProfilePreProcessor before ----------------> " + (String) arg0.get("phoneNumberCollection"));
   if(arg0.get("phoneNumberCollection") != null && arg0.get("phoneNumberCollection") != "") {
	   PSECUUtil utilObj = new PSECUUtil();
	   String phoneNumberCollection = (String) arg0.get("phoneNumberCollection");
	   arg0.put("phoneNumberCollection", utilObj.phoneCollectionToJson(phoneNumberCollection));
	   LOG.debug("phoneNumberCollection in EditProfilePreProcessor after ----------------> " + (String) arg0.get("phoneNumberCollection"));
   }
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  return true;
 }

}