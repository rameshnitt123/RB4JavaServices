package com.kony.psecu.preprocessor;
import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;
import java.util.HashMap;
import org.apache.log4j.Logger;

public class LoginPreProcessor extends BasePreProcessor implements DataPreProcessor {
 private static final Logger LOG = Logger.getLogger(LoginPreProcessor.class.getName());
 @Override
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  super.execute(arg0, request, arg2);
  LOG.debug("Inside LoginPreProcessor-execute");
  try {
   
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