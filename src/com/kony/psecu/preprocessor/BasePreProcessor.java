package com.kony.psecu.preprocessor;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

public class BasePreProcessor
implements DataPreProcessor {
 private static final Logger LOG = Logger.getLogger(BasePreProcessor.class.getName());
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  try {
   LOG.debug("Inside Basepreprocessor");
   Iterator it = arg0.entrySet().iterator();
   while (it.hasNext()) {
       Map.Entry pair = (Map.Entry)it.next();
       LOG.debug(pair.getKey() + " = " + pair.getValue());
       String value=(String) pair.getValue();
       if(value == null) {
    	   arg0.put(pair.getKey(),"");
       }
   }

  } catch (Exception e) {
   LOG.fatal("BasepreprocessorException"+e);
   return false;
  }
  return true;
 }
}