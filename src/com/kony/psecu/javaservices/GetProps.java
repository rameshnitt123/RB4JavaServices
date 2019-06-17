package com.kony.psecu.javaservices;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.io.InputStream;
import org.apache.log4j.Logger;
import util.PSECUProperties;
import com.konylabs.middleware.common.JavaService;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;

public class GetProps implements JavaService {
 private static final Logger LOG = Logger.getLogger(GetProps.class);
 @Override
 public Object invoke(String serviceId, Object[] arg1) throws Exception {
  Result result = new Result();
  try {
   HashMap < String, Object > requestObj = (HashMap < String, Object > ) arg1[1];
   if ("getApppUrls".equals(serviceId)) {
    //				result = new getURLs().checkForAppUpdate(result, dcReq);
    result.setParam(new Param("opstatus", "0", "String"));
   }

  } catch (Exception e) {
   System.out.println(" Error in the java service :::" + e.getMessage());
  }
  return result;
 }


 /*public Result Fetchi18Dynamically(Result result){
 	try {
 /*		LOG.debug("IN  Fetchi18Dynamically "+result);
 		LOG.debug("getProtectionDomain---------->" + getClass().getProtectionDomain());
 	LOG.debug("getCodeSource----->" + getClass().getProtectionDomain().getCodeSource());
 	LOG.debug("getLocation----->" + getClass().getProtectionDomain().getCodeSource().getLocation());
 		URL root = getClass().getProtectionDomain().getCodeSource().getLocation();
 		URL propertiesFile = new URL(root, "/i18n.properties"); 
 		
 		
 		
 	//File file = new File("i18n.properties");
 	//	FileInputStream fileInput = new FileInputStream(file);
 	//	InputStream�Fileinput�= getClass().getResourceAsStream("util/i18n.properties"); 
 		Properties properties = new Properties();
 		LOG.debug("Before InputStream");
 		InputStream inputStream = getClass().getResourceAsStream("i18n.properties");
 		LOG.debug("After InputStream " + inputStream.read());
 		properties.load(inputStream);
 	//	fileInput.close();
 		 
 	/*	Properties properties = new Properties();
 		properties.load(propertiesFile.openStream()); 
 		
 		LOG.debug("IN  Fetchi18Dynamically ");
 		Enumeration<Object> enuKeys = properties.keys();
 		while (enuKeys.hasMoreElements()) {
 			String key = (String) enuKeys.nextElement();
 			String value = properties.getProperty(key);
 			result.setParam(new Param(key, value,"String"));
 			System.out.println(key + ": " + value);
 		}
 		LOG.debug("Added all properties of i18 ");
 	} catch (FileNotFoundException e) {
 		LOG.debug("Exception FileNotFoundException");
 		e.printStackTrace();
 	} catch (IOException e) {
 		LOG.debug("Exception IOException");
 		e.printStackTrace();
 	}
 	return result;
 	
 }*/
 public Result getURLs(Result result, DataControllerRequest dcrq) throws Exception {
  String environment = "staging";
  if (dcrq.getParameter("environment") != null) {
   environment = (String) dcrq.getParameter("environment");
  }
  LOG.debug("value passed to getURLs " + environment);
  result.setParam(new Param("senderID", PSECUProperties.senderID, "String"));
  result.setParam(new Param("ufID", PSECUProperties.ufID, "String"));
  LOG.debug("Sender ID and UF Id" + PSECUProperties.senderID + " " + PSECUProperties.ufID);
  if (environment.equals(PSECUProperties.DEV_ENVIRONMENT)) {
   result.setParam(new Param("LOSAuthURL", PSECUProperties.LOS_AUTH_DEV, "String"));
   result.setParam(new Param("selfUnlockURL", PSECUProperties.SELF_UNLOCK_DEV, "String"));
   result.setParam(new Param("createUserURL", PSECUProperties.CREATE_USER_DEV, "String"));
   result.setParam(new Param("forgotPasswordURL", PSECUProperties.FORGOT_PASSWORD_DEV, "String"));
   result.setParam(new Param("privacyPolicyURL", PSECUProperties.PRIVACY_POLICY_DEV, "String"));
   result.setParam(new Param("contactUsURL", PSECUProperties.CONTACT_US_DEV, "String"));
   result.setParam(new Param("webViewURL", PSECUProperties.WEB_VIEW_DEV, "String"));
   result.setParam(new Param("commonTopicURL", PSECUProperties.COMMON_DEV, "String"));
   result.setParam(new Param("termsAndConditionsURL", PSECUProperties.TERMS_DEV, "String"));
   result.setParam(new Param("interestRatesURL", PSECUProperties.INTEREST_RATES_DEV, "String"));
  } else if (environment.equals(PSECUProperties.DEVCORE_ENVIRONMENT)) {
   result.setParam(new Param("LOSAuthURL", PSECUProperties.LOS_AUTH_DEV, "String"));
   result.setParam(new Param("selfUnlockURL", PSECUProperties.SELF_UNLOCK_DEVCORE, "String"));
   result.setParam(new Param("createUserURL", PSECUProperties.CREATE_USER_DEVCORE, "String"));
   result.setParam(new Param("forgotPasswordURL", PSECUProperties.FORGOT_PASSWORD_DEVCORE, "String"));
   result.setParam(new Param("privacyPolicyURL", PSECUProperties.PRIVACY_POLICY_DEV, "String"));
   result.setParam(new Param("contactUsURL", PSECUProperties.CONTACT_US_DEV, "String"));
   result.setParam(new Param("webViewURL", PSECUProperties.WEB_VIEW_DEVCORE, "String"));
   result.setParam(new Param("commonTopicURL", PSECUProperties.COMMON_DEV, "String"));
   result.setParam(new Param("termsAndConditionsURL", PSECUProperties.TERMS_DEV, "String"));
   result.setParam(new Param("interestRatesURL", PSECUProperties.INTEREST_RATES_DEV, "String"));
  } else if (environment.equals(PSECUProperties.STAGING_ENVIRONMENT)) {
   result.setParam(new Param("LOSAuthURL", PSECUProperties.LOS_AUTH_STAGING, "String"));
   result.setParam(new Param("selfUnlockURL", PSECUProperties.SELF_UNLOCK_STAGING, "String"));
   result.setParam(new Param("createUserURL", PSECUProperties.CREATE_USER_STAGING, "String"));
   result.setParam(new Param("forgotPasswordURL", PSECUProperties.FORGOT_PASSWORD_STAGING, "String"));
   result.setParam(new Param("privacyPolicyURL", PSECUProperties.PRIVACY_POLICY_STAGING, "String"));
   result.setParam(new Param("contactUsURL", PSECUProperties.CONTACT_US_STAGING, "String"));
   result.setParam(new Param("webViewURL", PSECUProperties.WEB_VIEW_STAGING, "String"));
   result.setParam(new Param("commonTopicURL", PSECUProperties.COMMON_STAGING, "String"));
   result.setParam(new Param("termsAndConditionsURL", PSECUProperties.TERMS_STAGING, "String"));
   result.setParam(new Param("interestRatesURL", PSECUProperties.INTEREST_RATES_STAGING, "String"));
  } else if (environment.equals(PSECUProperties.STAGCORE_ENVIRONMENT)) {
   result.setParam(new Param("LOSAuthURL", PSECUProperties.LOS_AUTH_STAGING, "String"));
   result.setParam(new Param("selfUnlockURL", PSECUProperties.SELF_UNLOCK_STAGCORE, "String"));
   result.setParam(new Param("createUserURL", PSECUProperties.CREATE_USER_STAGCORE, "String"));
   result.setParam(new Param("forgotPasswordURL", PSECUProperties.FORGOT_PASSWORD_STAGCORE, "String"));
   result.setParam(new Param("privacyPolicyURL", PSECUProperties.PRIVACY_POLICY_STAGING, "String"));
   result.setParam(new Param("contactUsURL", PSECUProperties.CONTACT_US_STAGING, "String"));
   result.setParam(new Param("webViewURL", PSECUProperties.WEB_VIEW_STAGCORE, "String"));
   result.setParam(new Param("commonTopicURL", PSECUProperties.COMMON_STAGING, "String"));
   result.setParam(new Param("termsAndConditionsURL", PSECUProperties.TERMS_STAGING, "String"));
   result.setParam(new Param("interestRatesURL", PSECUProperties.INTEREST_RATES_STAGING, "String"));
  } else if (environment.equals(PSECUProperties.PROD_ENVIRONMENT)) {
   result.setParam(new Param("LOSAuthURL", PSECUProperties.LOS_AUTH_PROD, "String"));
   result.setParam(new Param("selfUnlockURL", PSECUProperties.SELF_UNLOCK_PROD, "String"));
   result.setParam(new Param("createUserURL", PSECUProperties.CREATE_USER_PROD, "String"));
   result.setParam(new Param("forgotPasswordURL", PSECUProperties.FORGOT_PASSWORD_PROD, "String"));
   result.setParam(new Param("privacyPolicyURL", PSECUProperties.PRIVACY_POLICY_PROD, "String"));
   result.setParam(new Param("contactUsURL", PSECUProperties.CONTACT_US_PROD, "String"));
   result.setParam(new Param("webViewURL", PSECUProperties.WEB_VIEW_PROD, "String"));
   result.setParam(new Param("commonTopicURL", PSECUProperties.COMMON_PROD, "String"));
   result.setParam(new Param("termsAndConditionsURL", PSECUProperties.TERMS_PROD, "String"));
   result.setParam(new Param("interestRatesURL", PSECUProperties.INTEREST_RATES_PROD, "String"));
  }
  return result;
 }

 public static void main(String args[]) throws IOException {

  System.out.println("Before InputStream");
  GetProps a = new GetProps();
  InputStream inputStream = a.getClass().getResourceAsStream("i18n.properties");
  System.out.println("After InputStream" + inputStream.read());
  Properties properties = new Properties();
  properties.load(inputStream);
  Enumeration < Object > enuKeys = properties.keys();
  while (enuKeys.hasMoreElements()) {
   String key = (String) enuKeys.nextElement();
   String value = properties.getProperty(key);
   //		result.setParam(new Param(key, value,"String"));
   System.out.println(key + ": " + value);
  }
 }
}