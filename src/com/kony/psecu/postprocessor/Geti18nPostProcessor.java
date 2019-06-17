package com.kony.psecu.postprocessor;

import org.apache.log4j.Logger;

import com.kony.psecu.javaservices.GetInternationalizationObject;
import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;

public class Geti18nPostProcessor implements DataPostProcessor {
 private static final Logger LOG = Logger.getLogger(Geti18nPostProcessor.class);
 @Override
 public Object execute(Result result, DataControllerRequest dcReq)
 throws Exception {

  result = new GetInternationalizationObject().Fetchi18Dynamically(result);
  LOG.debug("Response from service " + result);
  return result;
 }


}