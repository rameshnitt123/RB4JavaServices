package com.kony.psecu.preprocessor;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;

import java.util.HashMap;

import org.apache.log4j.Logger;

import util.PSECUUtil;

public class LoginPreProcessor
implements DataPreProcessor {
 private static final Logger LOG = Logger.getLogger(LoginPreProcessor.class.getName());

 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  try {
   PSECUUtil utilObj = new PSECUUtil();
   String rsaDevice = (String) arg0.get("rsaDevice");
   arg0.put("rsaDevice", utilObj.modifyRSA(rsaDevice));
   arg2.setParam(new Param("testParam", "0", "String"));
   
   //==================IP-Address fix============================================//
   String deviceIPAddress=(String) request.getParameter("kony-identity-remote-ip");
   LOG.debug("Device IPADDRESS from Mobile-Fabric-Custom Identity is "+deviceIPAddress);
   if(deviceIPAddress !=null) {
	   arg0.put("ipAddress", deviceIPAddress);//over-ride existing input-field with ipaddress from request object 
   }
   else{
      arg0.put("ipAddress", "");
   }
   //==================IP-Address fix============================================//
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  return true;
 }
}