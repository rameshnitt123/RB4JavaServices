package com.kony.psecu.postprocessor;

import org.apache.log4j.Logger;

import com.kony.psecu.javaservices.GetInternationalizationObject;
import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;

public class GetTabi18nConfigPropertiesPostProcessor implements DataPostProcessor {
 private static final Logger LOG = Logger.getLogger(GetTabi18nConfigPropertiesPostProcessor.class);
 @Override
 public Object execute(Result result, DataControllerRequest dcReq)
 throws Exception {
LOG.debug("IN tab i18n post processor");
  result = new GetInternationalizationObject().FetchTabi18nConfigPropertiesDynamically(result, dcReq);
  LOG.debug("Response from service " + result);
  return result;
 }

}