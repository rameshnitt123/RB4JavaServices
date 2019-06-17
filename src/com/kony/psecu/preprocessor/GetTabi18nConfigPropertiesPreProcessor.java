package com.kony.psecu.preprocessor;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;

public class GetTabi18nConfigPropertiesPreProcessor implements DataPreProcessor {
 private static final Logger LOG = Logger.getLogger(GetTabi18nConfigPropertiesPreProcessor.class);
 @Override
 public boolean execute(HashMap input, DataControllerRequest request, Result result)
 throws Exception {
  LOG.debug("applicationFlag Geti18nConfigPropertiesPreProcessor----->" + request.getParameter("applicationFlag"));
  if (request.getParameter("currentTabTimeStamp") != null && request.getParameter("applicationFlag") != null && !(request.getParameter("applicationFlag").equals("banner"))) {
   LOG.debug("currentTimeStamp in Geti18nConfigPropertiesPreProcessor---->" + request.getParameter("currentTabTimeStamp"));
   return true;
  } else {
   result.setParam(new Param("opstatus", "0", "String"));
   LOG.debug("Entered into false loop for banner");
   return false;
  }
 }
}