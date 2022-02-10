package com.people.main;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.people.pages.SauceCheckout;
import com.people.pages.SauceHome;
import com.people.pages.SauceLogin;
import com.people.pages.SauceLogout;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.LogStatus;


public class PeopleHr_Test extends DriverInitialize{
	
	DriverInitialize DriverInitialize =  new DriverInitialize();
	
	Map<String, String> EnvironmentValuesDatas = new LinkedHashMap<String, String>();
	Map<String,JSONArray> Mapvalues = new LinkedHashMap<String,JSONArray>();
	String Url,Username,Password,Description;
    String Firstname,Lastname,Postalcode;
   
    
	//tc001
	@Test(groups = { "Regression"} , dataProvider="fetchData",alwaysRun=true)
	public void Sauce_Login_Dashboard(Map<String,String> map) throws Exception {
		
		SauceLogin sl= new SauceLogin(driver,test);
		
		EnvironmentValuesDatas = DriverInitialize.ReadCurrentQueryData();
		
		DriverInitialize.setQueryName(EnvironmentValuesDatas.get("SelectQueryName_Login"));
		Mapvalues = DriverInitialize.ReadCurrentTestData();
		
		for (Entry<String, JSONArray> entry : Mapvalues.entrySet()) {
		 for(Object o:entry.getValue()) {
			Username =((JSONObject) o).get("username").toString();   
			Password =((JSONObject) o).get("password").toString(); 
			Url =((JSONObject) o).get("url").toString(); 
			}
		}
		
			try {
			sl.NavigateURL(Url)
			.enterUsername(Username)
			.enterPassword(Password)
			.clickloginbutton();
			
		}
		catch (Exception e ) {
			return;
			
		}
	}
	
	//tc002
	@Test(groups = { "Regression"} , dataProvider="fetchData",alwaysRun=true)
	public void Add_Product (Map<String,String> map) throws Exception {
		

		SauceHome sh = new SauceHome(driver,test);
		SauceCheckout sc = new SauceCheckout(driver,test);
		SauceLogout so = new SauceLogout(driver,test);
EnvironmentValuesDatas = DriverInitialize.ReadCurrentQueryData();
		
		DriverInitialize.setQueryName(EnvironmentValuesDatas.get("SelectQueryname_Checkout"));
		Mapvalues = DriverInitialize.ReadCurrentTestData();
		
		
		for (Entry<String, JSONArray> entry : Mapvalues.entrySet()) {
			 for(Object o:entry.getValue()) {
				Firstname =((JSONObject) o).get("firstname").toString();   
				Lastname =((JSONObject) o).get("lastname").toString(); 
				Postalcode =((JSONObject) o).get("postalcode").toString(); 
				}
			}
		
		sh.Selecting()
		.Adding();
		sc.enterFirstname(Firstname)
		.enterLastname(Lastname)
		.enterPostalcode(Postalcode)
		.clickContinuebutton()
		.ClickCheckout();
		so.clickFinishbutton()
		.clickHomebutton()
		.clickSidebarbutton()
		.clickLogoutbutton();
		
	}	
		
		
		
		
		
	}
	

	



	

	
	
	
	
	


