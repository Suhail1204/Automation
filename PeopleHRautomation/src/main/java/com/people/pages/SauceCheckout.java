package com.people.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.people.selenium.api.base.SeleniumBase;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.ExtentTest;

public class SauceCheckout extends SeleniumBase {
	DriverInitialize DriverInitialize = new DriverInitialize();
	protected RemoteWebDriver currentdriver;
protected ExtentTest test;
public SauceCheckout(RemoteWebDriver driver, ExtentTest test) {
	super(driver, test);
	this.currentdriver =driver;
	this.test=test;
}

String Checkout = "//*[@id='checkout']"; //xpath
String FirstName = "//*[@id='first-name']"; //xpath
String Lastname = "//*[@id='last-name']"; //xpath
String PostalCode = "//*[@id='postal-code']"; //xpath
String Continue = "//*[@id='continue']"; //xpath

public  SauceCheckout ClickCheckout() throws InterruptedException {
	try {
		Click(findelement("xpath", Checkout));
		Thread.sleep(5000);
		
		//Navigating to Tasks tab
		boolean Verifytab = Verifyelementpresent("xpath", Checkout, 10);
		if(Verifytab) {
			
			ReportLog("pass", "Succesfully Checkout the product");
		}
		else {
			ReportLog("fail","Unable to Checkout");
		}
		return this;
	}
		catch(Exception e) {
			ReportLog("error", "Task Failed");
			return null;
		}
	}
public SauceCheckout enterFirstname(String firstname) throws InterruptedException {
	try {
	Click(findelement("xpath", FirstName));
	SendKeys(findelement("xpath", FirstName), firstname);
	ReportLog("info", "Firstname Entered In the Field");
	return this;
	}
	catch(Exception e) {
	ReportLog("error", "Unable to enter Firstname");
	return null;
	}
	}
	
	public SauceCheckout enterLastname(String lastname) throws InterruptedException {
		try {
		Click(findelement("xpath", Lastname));
		SendKeys(findelement("xpath", Lastname),lastname);
		ReportLog("info", "Lastname Entered In the Field");
		return this;
		}
		catch(Exception e) {
		ReportLog("error", "Unable to enter Lastname");
		return null;
		}
		
	}
	public SauceCheckout enterPostalcode(String postalcode) throws InterruptedException {
		try {
		Click(findelement("xpath", PostalCode));
		SendKeys(findelement("xpath", PostalCode),postalcode);
		ReportLog("info", "PostalCode Entered In the Field");
		return this;
		}
		catch(Exception e) {
		ReportLog("error", "Unable to enter PostalCode");
		return null;
		}
		
	}
	
	
	public SauceCheckout clickContinuebutton() throws InterruptedException {
		try {
		Click(findelement("xpath", Continue));
		Thread.sleep(2000);
		boolean navigate = Verifyelementpresent("xpath", Continue, 10);
		if(navigate) {
			ReportLog("pass", " Successfully Navigated to the Lastpage");
		}
		else
		{
			ReportLog("fail","Unable ot Navigate to the Lastpage");
		}
		return this;
		}
		catch(Exception e) {
		ReportLog("error", "Unable to click Continue button");
		return null;
		}
		
	}


}
