package com.people.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.people.selenium.api.base.SeleniumBase;
import com.people.utils.DriverInitialize;
import com.relevantcodes.extentreports.ExtentTest;

public class SauceHome extends SeleniumBase {
		DriverInitialize DriverInitialize = new DriverInitialize();
			protected RemoteWebDriver currentdriver;
		protected ExtentTest test;
		public SauceHome(RemoteWebDriver driver, ExtentTest test) {
			super(driver, test);
			this.currentdriver =driver;
			this.test=test;
		}
		
		String Cart = "//*[@class='shopping_cart_link']"; //xpath
		String Add_to_cart = "//*[@id='add-to-cart-sauce-labs-backpack']"; //xpath
		
		public  SauceHome Selecting() throws InterruptedException {
			try {
				Click(findelement("xpath", Add_to_cart));
				Thread.sleep(5000);
				
				//Navigating to Tasks tab
				boolean Verifytab = Verifyelementpresent("xpath", Add_to_cart, 10);
				if(Verifytab) {
					
					ReportLog("pass", "Succesfully selected the product");
				}
				else {
					ReportLog("fail","Unable to Select");
				}
				return this;
			}
				catch(Exception e) {
					ReportLog("error", "Task Failed");
					return null;
				}
			}

		
		public  SauceHome Adding() throws InterruptedException {
			try {
				Click(findelement("xpath", Cart));
				Thread.sleep(5000);
				//Adding product action
				boolean Verifytask = Verifyelementpresent("xpath", Cart, 10);
				if(Verifytask) {
					
					ReportLog("pass", "Product add to the cart");
				}
				else {
					ReportLog("fail", "Product didn't add to the cart");
				}
				
				return this;
			}
				catch(Exception e) {
					ReportLog("error", "Unable to add the product :"+ e);
				}
				return null;
		}
			
	}
