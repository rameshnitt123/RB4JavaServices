package com.kony.psecu.preprocessor;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;
import com.konylabs.middleware.session.Session;

import java.util.HashMap;

import org.apache.log4j.Logger;

import util.PSECUUtil;

public class BasePreProcessor
implements DataPreProcessor {
 private static final Logger LOG = Logger.getLogger(BasePreProcessor.class.getName());

 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  try {
   LOG.debug("*****Base preprocessor called****" + arg0.get("rsaDevice"));
   String userID = "";
   LOG.debug("In Base Preprocessor userID from identity----->" + userID);
   Session session = request.getSession();
   LOG.debug("Session ID in Pre processor----->" + session.getId());
   LOG.debug("UserID in session------>" + session.getAttribute("userID"));
   if ((session.getAttribute("userID") != null) && (!session.getAttribute("userID").equals(""))) {
    userID = (String) session.getAttribute("userID");
    LOG.debug("In Base Preprocessor userID from session----->" + userID);
    arg0.put("userID", userID);
   }
 
   LOG.debug("rsaDevice in Basepreprocessor before ----------------> " + (String) arg0.get("rsaDevice"));
   PSECUUtil utilObj = new PSECUUtil();
   String rsaDevice = (String) arg0.get("rsaDevice");
   arg0.put("rsaDevice", utilObj.modifyRSA(rsaDevice));
   LOG.debug("rsaDevice in Basepreprocessor after ----------------> " + (String) arg0.get("rsaDevice"));

  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  return true;
 }
}