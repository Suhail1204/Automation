package com.people.utils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;  
import org.testng.ITestListener;  
import org.testng.ITestResult;

import com.people.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
public class TestListener implements ITestListener{
	    @Override  
	    public void onTestStart(ITestResult result) {  
	        // TODO Auto-generated method stub  
	          
	    }  
	  
	    @Override  
	    public void onTestSuccess(ITestResult result) {  
	        // TODO Auto-generated method stub  
//	        System.out.println("Success of test cases and its details are : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailure(ITestResult result) {  
//	    	DriverInitialize.Refresh();
//	    	Url = DriverInitialize.EnvValuesMap.get("Url");
//	    	TestUserIDOne = DriverInitialize.EnvValuesMap.get("TestUserIDOne");
//	    	Password = DriverInitialize.EnvValuesMap.get("Password");
//	    	LoginPage LoginPage= new LoginPage(driver,DriverInitialize.test);
//	    	try {
//	    		DriverInitialize.test.log(LogStatus.WARNING, "Previous Test Failed, So ReLogin Occured");
//				LoginPage.enterUsername(TestUserIDOne,Url).enterPassword(Password).clickLogin(TestUserIDOne);
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}

	    }  
	  
	    @Override  
	    public void onTestSkipped(ITestResult result) {  
	        // TODO Auto-generated method stub  
//	        System.out.println("Skip of test cases and its details are : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	        // TODO Auto-generated method stub  
//	        System.out.println("Failure of test cases and its details are : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onStart(ITestContext context) {  
//	    	System.out.println("Thread Executed");
//	    	try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	          
	    }  
	  
	    @Override  
	    public void onFinish(ITestContext context) {  
	        // TODO Auto-generated method stub  
	          
	    }  


}
