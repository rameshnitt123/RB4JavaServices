package com.kony.psecu.preprocessor;


import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kony.psecu.postprocessor.GetAppWebURLPostProcessor;
import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;

import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;

public class GetAppWebURLPreProcessor implements DataPreProcessor {
 private static final Logger LOG = Logger.getLogger(GetAppWebURLPostProcessor.class);
 @Override
 public boolean execute(HashMap input, DataControllerRequest request, Result result)
 throws Exception {
  LOG.debug("applicationFlag in app web----->" + request.getParameter("applicationFlag"));
  LOG.debug("currentTimeStamp in app web----->" + request.getParameter("currentTimeStamp"));
  LOG.debug("currentTimeTabStamp in app web----->" + request.getParameter("currentTabTimeStamp"));
  if (request.getParameter("currentTimeStamp") != null ) {
   LOG.debug("ENtered into applicationFlag loop");
   result.setParam(new Param("opstatus", "0", "String"));
   return false;
  }else if (request.getParameter("currentTabTimeStamp") != null){
	  LOG.debug("ENtered into currentTabTimeStamp loop");
	   result.setParam(new Param("opstatus", "0", "String"));
	   return false;
  }else {
   LOG.debug("ENtered into else looop");
   String environment = "";
   if (input.get("environment") != null) {
    environment = input.get("environment").toString();
    request.setAttribute("environment", environment);
    LOG.debug("Request from UI " + environment);
   }
  }
  result.setParam(new Param("opstatus", "0", "String"));
  return true;
 }
}