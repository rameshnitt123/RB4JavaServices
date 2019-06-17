package com.kony.psecu.postprocessor;

import org.apache.log4j.Logger;

import com.kony.psecu.javaservices.GetProps;
import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;


public class GetAppWebURLPostProcessor implements DataPostProcessor {
 private static final Logger LOG = Logger.getLogger(GetAppWebURLPostProcessor.class);
 @Override
 public Object execute(Result result, DataControllerRequest dcReq)
 throws Exception {

  result = new GetProps().getURLs(result, dcReq);
  LOG.debug("Response from service " + result);
  return result;



 }


}