package com.people.pages;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.people.selenium.api.base.SeleniumBase;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class LoginPage extends SeleniumBase  {
	DriverInitialize DriverInitialize= new DriverInitialize();
	protected  RemoteWebDriver currentdriver;
	protected ExtentTest test;
	//constructor 
	public LoginPage(RemoteWebDriver driver,ExtentTest test) {
	super(driver,test);
	this.currentdriver = driver;
	this.test =test;
	}
	
	String Username = "txtEmailId"; //id
	String NextButton = "btnNext"; //id
	String Password = "Password"; //id
	String LoginButton = "btnNextLogin"; //id
	String CheckTaskicon = "//a[@id='ucLeftSegment_aTask']";
			
	// Browser url navigation
	public LoginPage NavigateURL(String Url) {
		try {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		currentdriver.navigate().to(Url);
	    ReportLog("info", "People HR portal have been loaded Successfully.");
		}
		catch(Exception e) {
		ReportLog("error", "Environment is Down");
		DriverInitialize.extent.flush();
		System.exit(1);
		}
		return this;	
	}

	// Enter user name in username field
	public LoginPage enterUsername(String username) throws InterruptedException {
		try {
		Click(findelement("id", Username));
		SendKeys(findelement("id", Username), username);
		ReportLog("info", "Username Entered In the Username Input Field:<font color='blue'><b>"+username+"</b></font>");
		Click(findelement("id", NextButton));
		Thread.sleep(2000);
		return this;
		}
		catch(Exception e) {
		ReportLog("error", "Unable to enter username");
		return null;
		}
		
	}
	public LoginPage enterPassword(String password) throws InterruptedException {
		try {
		Click(findelement("id", Password));
		SendKeys(findelement("id", Password),password);
		ReportLog("info", "Password Entered In the Password  Field");
		return this;
		}
		catch(Exception e) {
		ReportLog("error", "Unable to enter password");
		return null;
		}
		
	}
	public LoginPage clickloginbutton() throws InterruptedException {
		try {
		Click(findelement("xpath", "//*[text()='Sign in']"));
		Thread.sleep(2000);
		boolean navigate = Verifyelementpresent("xpath", CheckTaskicon, 10);
		if(navigate) {
			ReportLog("pass", " Successfully Navigated to the Home page");
		}
		else
		{
			ReportLog("fail","Unable ot Navigate to the Home page");
		}
		return this;
		}
		catch(Exception e) {
		ReportLog("error", "Unable to click login button");
		return null;
		}
		
	}

	}



