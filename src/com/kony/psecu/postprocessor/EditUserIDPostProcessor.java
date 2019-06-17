package com.kony.psecu.postprocessor;

import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Result;
import com.konylabs.middleware.session.Session;




public class EditUserIDPostProcessor implements DataPostProcessor {

 private static final Logger LOG = Logger
  .getLogger(EditUserIDPostProcessor.class.getName());
 @Override
 public Object execute(Result results, DataControllerRequest request) throws Exception {
  try {
   if (results != null) {
    String statusCode = results.findParam("statusCode").getValue();
    LOG.debug("statusCode----->" + statusCode);
    if (statusCode.equals("0000")) {
     Session session = request.getSession();
     LOG.debug("Value---->" + request.getParameter("newUserID"));
     session.setAttribute("userID", request.getParameter("newUserID"));

    }

   }
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  return results;
 }

}