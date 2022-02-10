package com.people.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.github.javafaker.Faker;
import com.people.selenium.api.base.SeleniumBase;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends SeleniumBase {
	DriverInitialize DriverInitialize = new DriverInitialize();
		protected RemoteWebDriver currentdriver;
	protected ExtentTest test;
	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		super(driver, test);
		this.currentdriver =driver;
		this.test=test;
	}
	
	String Tasktab = "ucLeftSegment_aTask"; //id

	
	public  HomePage NavigateTaskTab() throws InterruptedException {
	try {
		
		//Navigating to Tasks tab
		boolean Verifytab = Verifyelementpresent("id", Tasktab, 10);
		if(Verifytab) {
			Click(findelement("id", Tasktab));
			Thread.sleep(5000);
			ReportLog("pass", "Navigated to the AddNew Task Tab");
		}
		else {
			ReportLog("fail","Unable to Navigate");
		}
		return this;
	}
		catch(Exception e) {
			ReportLog("error", "unable to navigate To the Tasks tab page");
			return null;
		}
	}
		
	

}