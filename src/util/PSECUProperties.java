package util;

public class PSECUProperties {

 public static String DEV_ENVIRONMENT = "dev";
 public static String DEVCORE_ENVIRONMENT = "devcore";
 public static String STAGING_ENVIRONMENT = "staging";
 public static String STAGCORE_ENVIRONMENT = "stagcore";
 public static String PROD_ENVIRONMENT = "prod";
 public static String senderID = "357683127428";
 public static String ufID = "Psecuecomm72@gmail.com";


 //Add Loan - LOSAuthentication Redirect token added to the url
 public static String LOS_AUTH_DEV = "https://apps.staging.psecu.com/VirtualCapture/Login/SSO?AuthToken=";
 public static String LOS_AUTH_STAGING = "https://apps.staging.psecu.com/VirtualCapture/Login/SSO?AuthToken=";
 public static String LOS_AUTH_PROD = "https://apps.psecu.com/VirtualCapture/Login/SSO?AuthToken=";

 //Self – Service Unlock - 
 public static String SELF_UNLOCK_DEV = "https://hbgprogdev1.v4.homebank.dev.psecu.com:1443/SelfService/Login/Login.aspx?dm=d&ss=l&hide-menus=true";
 public static String SELF_UNLOCK_DEVCORE = "https://hbgprogdev1.v4.homebank.dev.psecu.com:1443/SelfService/Login/Login.aspx?dm=d&ss=l&hide-menus=true";
 public static String SELF_UNLOCK_STAGING = "https://homebank.staging.psecu.com/SelfService/Login/Login.aspx?dm=d&ss=l&hide-menus=true";
 public static String SELF_UNLOCK_STAGCORE = "https://homebank.staging.psecu.com/SelfService/Login/Login.aspx?dm=d&ss=l&hide-menus=true";
 public static String SELF_UNLOCK_PROD = "https://homebank.psecu.com/SelfService/Login/Login.aspx?dm=d&ss=l&hide-menus=true";

 //Create UserID  -  
 public static String CREATE_USER_DEV = "https://hbgprogdev1.v4.homebank.dev.psecu.com:1443/activation/activation.aspx?hide-menus=true";
 public static String CREATE_USER_DEVCORE = "https://hbgprogdev1.v4.homebank.dev.psecu.com:1443/activation/activation.aspx?hide-menus=true";
 public static String CREATE_USER_STAGING = "https://homebank.staging.psecu.com/activation/activation.aspx?hide-menus=true";
 public static String CREATE_USER_STAGCORE = "https://homebank.staging.psecu.com/activation/activation.aspx?hide-menus=true";
 public static String CREATE_USER_PROD = "https://homebank.psecu.com/activation/activation.aspx?hide-menus=true";

 //Forgot Password  
 public static String FORGOT_PASSWORD_DEV = "https://hbgprogdev1.v4.homebank.dev.psecu.com:1443/SelfService/Login/Login.aspx?dm=d&ss=d&hide-menus=true";
 public static String FORGOT_PASSWORD_DEVCORE = "https://hbgprogdev1.v4.homebank.dev.psecu.com:1443/SelfService/Login/Login.aspx?dm=d&ss=d&hide-menus=true";
 public static String FORGOT_PASSWORD_STAGING = "https://homebank.staging.psecu.com/SelfService/Login/Login.aspx?dm=d&ss=d&hide-menus=true";
 public static String FORGOT_PASSWORD_STAGCORE = "https://homebank.staging.psecu.com/SelfService/Login/Login.aspx?dm=d&ss=d&hide-menus=true";
 public static String FORGOT_PASSWORD_PROD = "https://homebank.psecu.com/selfservice/Login/Login.aspx?dm=d&ss=d&hide-menus=true";

 //Privacy Policy 
 public static String PRIVACY_POLICY_DEV = "https://www.psecu.com/privacy-policies-disclosures/privacy-policy?hide-menus=true";
 public static String PRIVACY_POLICY_STAGING = "https://www.psecu.com/privacy-policies-disclosures/privacy-policy?hide-menus=true";
 public static String PRIVACY_POLICY_PROD = "https://www.psecu.com/privacy-policies-disclosures/privacy-policy?hide-menus=true";

 //Contact Us
 public static String CONTACT_US_DEV = "https://www.psecu.com/about-psecu/contact?hide-menus=true";
 public static String CONTACT_US_STAGING = "https://www.psecu.com/about-psecu/contact?hide-menus=true";
 public static String CONTACT_US_PROD = "https://www.psecu.com/about-psecu/contact?hide-menus=true";

 //M+Webviews - -	Needs redirect token
 public static String WEB_VIEW_DEV = "https://Mobilesvc.psecu.com/MobileWebViewsV3/Default.aspx?&hide-menus=true";
 public static String WEB_VIEW_DEVCORE = "https://Mobilesvc.psecu.com/MobileWebViewsV3/Default.aspx?&hide-menus=true";
 public static String WEB_VIEW_STAGING = "https://Mobilesvc.psecu.com/MobileWebViewsV3/Default.aspx?&hide-menus=true";
 public static String WEB_VIEW_STAGCORE = "https://Mobilesvc.psecu.com/MobileWebViewsV3/Default.aspx?&hide-menus=true";
 public static String WEB_VIEW_PROD = "https://Mobilesvc.psecu.com/MobileWebViewsV3/Default.aspx?&hide-menus=true";

 //Common Topic
 public static String COMMON_DEV = "https://www.psecu.com/kony/help.aspx?hide-menus=true&topic=";
 public static String COMMON_STAGING = "https://www.psecu.com/kony/help.aspx?hide-menus=true&topic=";
 public static String COMMON_PROD = "https://www.psecu.com/kony/help.aspx?hide-menus=true&topic=";

 //Terms and Conditions 
 public static String TERMS_DEV = "https://www.psecu.com/privacy-policies-disclosures?hide-menus=true";
 public static String TERMS_STAGING = "https://www.psecu.com/privacy-policies-disclosures?hide-menus=true";
 public static String TERMS_PROD = "https://www.psecu.com/privacy-policies-disclosures?hide-menus=true";

 //Interest Rates
 public static String INTEREST_RATES_DEV = "https://www.psecu.com/rates/?hide-menus=true";
 public static String INTEREST_RATES_STAGING = "https://www.psecu.com/rates/?hide-menus=true";
 public static String INTEREST_RATES_PROD = "https://www.psecu.com/rates/?hide-menus=true";
}