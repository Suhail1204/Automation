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
import com.people.pages.NewTaskPage;
import com.people.selenium.api.base.SeleniumBase;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SearchTaskPage extends SeleniumBase  {
	DriverInitialize DriverInitialize= new DriverInitialize();
	Faker fake = new Faker(new Locale("EN-us"));
	protected  RemoteWebDriver currentdriver;
	protected ExtentTest test;
	String title,IntialCount,AddNewCount;
	public SearchTaskPage(RemoteWebDriver driver,ExtentTest test) {
		super(driver,test);
		this.currentdriver = driver;
		this.test =test;
	}

	//search task
	String Searchicon = "//*[@id='liSearch']/a[1]";
	String Clicksearchfield = "//input[@id='Searchname']";
	String PassvalueinField = "//input[@id='Searchname']";
	String Retrievedresult = "//*[@id='rptTask_trDataRow_0']";
	String fetchedtitle = "//*[@class='drTask editColumn']";
	
	public SearchTaskPage Searchtask() throws InterruptedException {
		try {
			Click(findelement("xpath", Searchicon));
			Thread.sleep(1000);
			
			Click(findelement("xpath", Clicksearchfield));
			Thread.sleep(1000);
			
			SendKeys(findelement("xpath", PassvalueinField), title);
			Thread.sleep(3000);
			
			String PassValue = title;
			System.out.println("the pass value is : " + PassValue);
			Click(findelement("xpath", Retrievedresult));
			
			String result = fetchedtitle;
			String searchresult = currentdriver.findElementByXPath(result).getText();
			System.out.println("the searchresult value is : " + searchresult);
			Thread.sleep(3000);
			if(PassValue.contentEquals(searchresult)) {
				System.out.println("The Retrieved value from search result is Same as the Task Title");
			}
			else {
				System.out.println("The retrieved value is not same as the Task Title");
			}
			return this;
		}
		catch(Exception e) {
			ReportLog("error", "unable to search the element" + e);
			return null;
		}
		
	}
}


	
