package com.kony.psecu.preprocessor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;




import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPreProcessor;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;




public class SearchPreProcessor extends BasePreProcessor implements DataPreProcessor {

 private static final Logger LOG = Logger
  .getLogger(SearchPreProcessor.class.getName());
 @Override
 public boolean execute(HashMap arg0, DataControllerRequest request, Result arg2) throws Exception {
  // TODO Auto-generated method stub	
  super.execute(arg0, request, arg2);
  try {
	  LOG.debug("Request to Search in SearchPreProcessor "+arg0);
   if (arg0.get("transferFlag") != null && !arg0.get("transferFlag").equals("search")) {
	   arg2.setParam(new Param("opstatus", "0", "String"));															
	   LOG.debug("In Search before returning false");
    return false;
   }else{
	   if(arg0.get("searchType")!= null){
			/*Getting the filter values*/
			LOG.debug("searchType ::"+arg0.get("searchType"));
			SimpleDateFormat currentYear = new SimpleDateFormat("yyyy");
			SimpleDateFormat currentMonth = new SimpleDateFormat("MM");
			SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
			//SimpleDateFormat fromDate = new SimpleDateFormat("MM/dd/yyyy");
		   Date localDate = new Date();
		   String year = currentYear.format(localDate);
		   String month = currentMonth.format(localDate); 
		   String searchEndDate = date.format(localDate);
			if(arg0.get("searchType").equals("0")){//this month
				LOG.debug("this month inputs "+year+" "+month);
				arg0.put("year", year);
				arg0.put("month", month);
			} else if(arg0.get("searchType").equals("1")){//last month
				int lastMonth = Integer.parseInt(month)-1;
				LOG.debug("last month inputs "+year+" "+lastMonth);
				arg0.put("year", year);
				arg0.put("month", String.valueOf(lastMonth));
			}else if(arg0.get("searchType").equals("2")){//last 30 days
				Calendar calReturn = Calendar.getInstance();
				calReturn.add(Calendar.DATE, -30);
				String searchStartDate = date.format(calReturn.getTime());
				LOG.debug("Last 30 days search : end date "+searchEndDate+" start date"+searchStartDate);
				arg0.put("searchEndDate", searchEndDate);
				arg0.put("searchStartDate", String.valueOf(searchStartDate));
			}else if(arg0.get("searchType").equals("3")){//last 90 days
				Calendar calReturn = Calendar.getInstance();
				calReturn.add(Calendar.DATE, -90);
				String searchStartDate = date.format(calReturn.getTime());
				LOG.debug("Last 90 days search : end date "+searchEndDate+" start date"+searchStartDate);
				arg0.put("searchEndDate", searchEndDate);
				arg0.put("searchStartDate", String.valueOf(searchStartDate));
			}
		}	
   }
  } catch (Exception e) {
   LOG.fatal(e);
   return false;
  }
  return true;
 }

}