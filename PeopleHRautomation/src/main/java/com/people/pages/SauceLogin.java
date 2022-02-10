package com.people.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.people.selenium.api.base.SeleniumBase;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.ExtentTest;

public class SauceLogin extends SeleniumBase {
	DriverInitialize DriverInitialize= new DriverInitialize();
	protected  RemoteWebDriver currentdriver;
	protected ExtentTest test;
	
	public SauceLogin(RemoteWebDriver driver,ExtentTest test) {
		super(driver,test);
		this.currentdriver = driver;
		this.test =test;
		}
	String Username = "user-name"; //id
	String Password = "password"; //id
	String LoginButton = "login-button"; //id

	public SauceLogin NavigateURL(String Url) {
		try {
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		currentdriver.navigate().to(Url);
	    ReportLog("info", "Sauce portal have been loaded Successfully.");
		}
		catch(Exception e) {
		ReportLog("error", "Environment is Down");
		DriverInitialize.extent.flush();
		System.exit(1);
		}
		return this;	
	}

	public SauceLogin enterUsername(String username) throws InterruptedException {
		try {
		Click(findelement("id", Username));
		SendKeys(findelement("id", Username), username);
		ReportLog("info", "Username Entered In the Username Input Field:<font color='blue'><b>"+username+"</b></font>");
		Click(findelement("id", LoginButton));
		Thread.sleep(2000);
		return this;
		}
		catch(Exception e) {
		ReportLog("error", "Unable to enter username");
		return null;
		}
		}
		
		public SauceLogin enterPassword(String password) throws InterruptedException {
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
		
		public SauceLogin clickloginbutton() throws InterruptedException {
			try {
			Click(findelement("id", "login-button"));
			Thread.sleep(2000);
			boolean navigate = Verifyelementpresent("id", LoginButton, 10);
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
