package com.people.pages;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.people.selenium.api.base.SeleniumBase;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.ExtentTest;

public class SauceLogout extends SeleniumBase {
	DriverInitialize DriverInitialize = new DriverInitialize();
	protected RemoteWebDriver currentdriver;
protected ExtentTest test;
public SauceLogout(RemoteWebDriver driver, ExtentTest test) {
	super(driver, test);
	this.currentdriver =driver;
	this.test=test;
}

String Finish = "//*[@id='finish']";
String BackToHome = "//*[@id='back-to-products']";
String Sidebar = "//*[@id='react-burger-menu-btn']";
String Logout = "//*[@id='logout_sidebar_link']";


public SauceLogout clickFinishbutton() throws InterruptedException {
	try {
	Click(findelement("xpath", Finish));
	Thread.sleep(2000);
	boolean navigate = Verifyelementpresent("xpath", Finish, 10);
	if(navigate) {
		ReportLog("pass", " Product Successfully Ordered");
	}
	else
	{
		ReportLog("fail","Unable to Place the Order");
	}
	return this;
	}
	catch(Exception e) {
	ReportLog("error", "Unable to click Finish button");
	return null;
	}
}
public SauceLogout clickHomebutton() throws InterruptedException {
	try {
	Click(findelement("xpath", BackToHome));
	Thread.sleep(2000);
	boolean navigate = Verifyelementpresent("xpath", BackToHome, 10);
	if(navigate) {
		ReportLog("pass", " Successfully Navigated back to home");
	}
	else
	{
		ReportLog("fail","Unable to Navigate to home");
	}
	return this;
	}
	catch(Exception e) {
	ReportLog("error", "Unable to click BackToHome button");
	return null;
	}
}
public SauceLogout clickSidebarbutton() throws InterruptedException {
	try {
	Click(findelement("xpath", Sidebar));
	Thread.sleep(2000);
	boolean navigate = Verifyelementpresent("xpath", Sidebar, 10);
	if(navigate) {
		ReportLog("pass", " The Sidebar is opened");
	}
	else
	{
		ReportLog("fail","Unable to open the sidebar");
	}
	return this;
	}
	catch(Exception e) {
	ReportLog("error", "Unable to click Sidebar button");
	return null;
	}
}
public SauceLogout clickLogoutbutton() throws InterruptedException {
	try {
	Click(findelement("xpath", Logout));
	Thread.sleep(2000);
	boolean navigate = Verifyelementpresent("xpath", Logout, 10);
	if(navigate) {
		ReportLog("pass", " Successfully Logout");
	}
	else
	{
		ReportLog("fail","Unable to Logout");
	}
	return this;
	}
	catch(Exception e) {
	ReportLog("error", "Unable to click Logout button");
	return null;
	}
}
}