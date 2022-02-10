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

public class NewTaskPage extends SeleniumBase  {
	DriverInitialize DriverInitialize= new DriverInitialize();
	Faker fake = new Faker(new Locale("EN-us"));
	protected  RemoteWebDriver currentdriver;
	protected ExtentTest test;
	String title,IntialCount,AddNewCount;
	public NewTaskPage(RemoteWebDriver driver,ExtentTest test) {
		super(driver,test);
		this.currentdriver = driver;
		this.test =test;
	}
	
	//New task 
	String AddNewTask = "//*[@class='addNewTask']";
	String TaskTitle = "//*[@id='pTaskTitle']";
	String TodayDate = "txtDate"; //id
	//Description
	String Desc = "//*[@id='pDesc']";
	//saving task
	String Savetask = "hlinkSave"; //id
	String DueCount = "//*[@class='taskDueToday']//span";
	//search task
	String Searchicon = "//*[@id='liSearch']/a[1]";
	String Clicksearchfield = "//input[@id='Searchname']";
	String PassvalueinField = "//input[@id='Searchname']";
	String Retrievedresult = "//*[@id='rptTask_trDataRow_0']";
	String Deletetask = "//*[@id='hlnDelete']";
	String Popup = "//*[@class='blue right medium button removefilter deleteConfirm']";
	
			

	
	public NewTaskPage GeneraterandomData() throws InterruptedException {
		try {
			title = fake.name().title();
			return this;
		}
		catch(Exception e) {
			ReportLog("error", "random data generation failed, Script error is:"+e.getLocalizedMessage());
			return null;
		}
		} 

	public NewTaskPage AddTask() throws InterruptedException {
		try {
		//Adding task action
		boolean Verifytask = Verifyelementpresent("xpath", AddNewTask, 10);
		if(Verifytask) {
			Click(findelement("xpath", AddNewTask));
			ReportLog("pass", "Navigated to the New task Form");
		}
		else {
			ReportLog("fail", "Unable to Navigate to The AddNew task Form");
		}
		
		//Adding Task Title
		
		Click(findelement("xpath", TaskTitle));
		SendKeys(findelement("xpath", TaskTitle), title);
		
		//Adding date 
		boolean Verifydate = Verifyelementpresent("id",TodayDate, 10);
		if(Verifydate) {
		Date d= new Date();
		String todaydate = new SimpleDateFormat("dd/MM/yyyy").format(d);
		SendKeys(findelement("id", TodayDate), todaydate);
		System.out.println("Date Functionality is Working");
		}
		else {
			ReportLog("fail", "Unable to enter the Date");
		}
		return this;
	}
		catch(Exception e) {
			ReportLog("error", "Unable to add the Date :"+ e);
		}
		return null;
	}
		
		
		// Adding Description 
	public NewTaskPage AddDesc(String Description ) throws InterruptedException {
		try {
			Click(findelement("xpath", Desc));
			SendKeys(findelement("xpath", Desc), Description); 
			return this;
			}
		catch(Exception e) {
			ReportLog("error", "Unable to add the Description" + e);
	}
		return null;
	}
		
	
	public NewTaskPage SaveTask() throws InterruptedException {
		try {
		//Saving the Task
		boolean Verifysavetask = Verifyelementpresent("id", Savetask, 10);
		if(Verifysavetask) {
			IntialCount = currentdriver.findElementByXPath(DueCount).getText();
			System.out.println("the initial count is : " + IntialCount);
			Click(findelement("id", Savetask));
			ReportLog("pass", "The Task have been saved : " + title);
			Thread.sleep(3000);
			AddNewCount = currentdriver.findElementByXPath(DueCount).getText();
			System.out.println("the add new count is : " + AddNewCount);
			if(IntialCount!= (AddNewCount)) {
				System.out.println("The task count is getting Increased and NewTask have been Added ");
				ReportLog("pass","The task count is getting Increased and NewTask have been Added ");
			}
			else {
				System.out.println("the task is not getting increased");
				ReportLog("fail", "Unable to Save the Task");
			}
			
		}
		else {
			ReportLog("fail", "Unable to Save the Task");
		}
		
		return this;
		}
		catch(Exception e) {
			ReportLog("error","unable to perform action");
		}
		return null;
	}


public NewTaskPage SearchTask() throws InterruptedException {
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
		
		String result = "//*[@class='drTask editColumn']";
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

	public NewTaskPage DeleteTask() throws InterruptedException {
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

	
	public NewTaskPage DeletePopUp() throws InterruptedException {
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


	
	
	