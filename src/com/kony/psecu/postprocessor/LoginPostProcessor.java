package com.kony.psecu.postprocessor;

import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPostProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Record;
import com.konylabs.middleware.dataobject.Result;
import com.konylabs.middleware.dataobject.Param;

public class LoginPostProcessor implements DataPostProcessor {
	private static final Logger LOG = Logger.getLogger(com.kony.psecu.postprocessor.LoginPostProcessor.class);

	@Override
	public Object execute(Result result, DataControllerRequest request) throws Exception {

		LOG.debug("In loginpostprocessor--START");
		
		LOG.debug("setting securityDataSet---START");
		Record securityDataSet = new com.konylabs.middleware.dataobject.Record();
		securityDataSet.setID("core_security_attributes");

		Param session_token = result.findParam("sessionID");
		if (session_token != null && !"".equals(session_token.toString())) {
			session_token.setName("session_token");
			securityDataSet.setParam(session_token);
			result.removeParam(session_token);
			LOG.debug("setting securityDataSet---END-sessionID is " + securityDataSet.getParam("session_token"));
		}

		LOG.debug("setting core_attributes---START");
		Record userDataSet = new com.konylabs.middleware.dataobject.Record();
		userDataSet.setID("core_attributes");

		Param user_id = result.findParam("userID");
		Param userName = user_id;
		if (user_id != null && !"".equals(user_id.toString())) {
			user_id.setName("user_id");
			userName.setName("userName");
			userDataSet.setParam(user_id);
			userDataSet.setParam(userName);
			result.removeParam(user_id);
			result.removeParam(userName);
		}
		Param customer_id = result.findParam("uniqueID");
		if (customer_id != null && !"".equals(customer_id.toString())) {
			customer_id.setName("customer_id");
			userDataSet.setParam(customer_id);
			result.removeParam(customer_id);
		}
		Param firstName = result.findParam("firstName");
		if (firstName != null && !"".equals(firstName.toString())) {
			userDataSet.setParam(firstName);
			result.removeParam(firstName);
		}
		Param lastName = result.findParam("lastName");
		if (lastName != null && !"".equals(lastName.toString())) {
			userDataSet.setParam(lastName);
			result.removeParam(lastName);
		}
		Param dateOfBirth = result.findParam("dateOfBirth");
		if (dateOfBirth != null && !"".equals(dateOfBirth.toString())) {
			userDataSet.setParam(dateOfBirth);
			result.removeParam(dateOfBirth);
		}

		Param email = result.findParam("email");
		if (email != null && !"".equals(email.toString())) {
			userDataSet.setParam(email);
			result.removeParam(email);
		}
		Param phone = result.findParam("phone");
		if (email != null && !"".equals(phone.toString())) {
			userDataSet.setParam(phone);
			result.removeParam(phone);
		}
		Param isEnrolled = result.findParam("isEnrolled");
		if (isEnrolled != null && !"".equals(isEnrolled.toString())) {
			userDataSet.setParam(isEnrolled);
			result.removeParam(isEnrolled);
		}
		Param lastlogintime = result.findParam("lastLoginDateTime");
		if (lastlogintime != null && !"".equals(lastlogintime.toString())) {
			lastlogintime.setName("lastlogintime");
			userDataSet.setParam(lastlogintime);
			result.removeParam(lastlogintime);
		}
		Param isPinSet = result.findParam("isPinSet");
		if (isPinSet != null && !"".equals(isPinSet.toString())) {
			userDataSet.setParam(isPinSet);
			result.removeParam(isPinSet);
		}
		Param isBillPayActivated = result.findParam("isBillPayActivated");
		if (isBillPayActivated != null && !"".equals(isBillPayActivated.toString())) {
			userDataSet.setParam(isBillPayActivated);
			result.removeParam(isBillPayActivated);
		}
		Param isBillPaySupported = result.findParam("isBillPaySupported");
		if (isBillPaySupported != null && !"".equals(isBillPaySupported.toString())) {
			userDataSet.setParam(isBillPaySupported);
			result.removeParam(isBillPaySupported);
		}
		Param isP2PSupported = result.findParam("isP2PSupported");
		if (isP2PSupported != null && !"".equals(isP2PSupported.toString())) {
			userDataSet.setParam(isP2PSupported);
			result.removeParam(isP2PSupported);
		}
		Param isP2PActivated = result.findParam("isP2PActivated");
		if (isP2PActivated != null && !"".equals(isP2PActivated.toString())) {
			userDataSet.setParam(isP2PActivated);
			result.removeParam(isP2PActivated);
		}
		LOG.debug("securityDataSet is " + securityDataSet);
		LOG.debug("userDataSet is " + userDataSet);
		LOG.debug("In loginpostprocessor--END");
		result.setRecord(securityDataSet);
		result.setRecord(userDataSet);
		return result;
	}
}