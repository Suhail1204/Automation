package com.people.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.people.selenium.api.base.SeleniumBase;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DeleteTaskPage extends SeleniumBase  {
	DriverInitialize DriverInitialize= new DriverInitialize();
	Faker fake = new Faker(new Locale("EN-us"));
	protected  RemoteWebDriver currentdriver;
	protected ExtentTest test;
	String title,IntialCount,AddNewCount;
	public DeleteTaskPage(RemoteWebDriver driver,ExtentTest test) {
		super(driver,test);
		this.currentdriver = driver;
		this.test =test;
	}
	
	String Deletetask = "//*[@id='hlnDelete']";
	String Popup = "//*[@class='blue right medium button removefilter deleteConfirm']";
	
	
	public DeleteTaskPage Deletetask() throws InterruptedException {
		try {
			boolean verifyButton = Verifyelementpresent("xpath", Deletetask, 10);
			if(verifyButton) {
				Click(findelement("xpath", Deletetask));
				ReportLog("pass", "Delete Task Action have been made");
			}
			else {
				ReportLog("fail", "Unable to Locate the Delete Button");
			}
			return this;
		}
		catch(Exception e) {
			ReportLog("error", "Unable to make delete action" + e);
			return null;
		}
		
	}

	
	public DeleteTaskPage DeletePopUp() throws InterruptedException {
		try {
			boolean Verifypopup = Verifyelementpresent("xpath", Popup, 10);
			if(Verifypopup) {
				Click(findelement("xpath", Popup));
				System.out.println("popup opened for delete action");
			}
			else {
				ReportLog("fail","Unable to perform action in Popup Window");
			}
			return this;
		}
		catch(Exception e) {
			ReportLog("error", "Unable to handle the popup Window" + e);
			return null;
		}
}
}


