package com.tangent.libraries;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class BaseTest
{

	public WebDriver driver;
	@BeforeClass
	public void openApp()
	{
		//Open the browser
		//Enter the URLt
		//Give timeouts
		
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://localhost/login.do");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@AfterClass
	public void closeApp()
	{
		//close the driver(or)browser
		driver.close();
	}
	@AfterMethod
	public void postCondition(ITestResult res)
	{
		//check if the test case is pass/fail
		//if fail take a screenshot
		if(res.getStatus()==ITestResult.FAILURE)
		{
		 TakesScreenshot t1=(TakesScreenshot)driver;
		 File scrFile= t1.getScreenshotAs(OutputType.FILE);
		 File destFile=new File("./screenshots/"+res.getName()+".png");
		 
		 try
		 {
			 FileUtils.copyFile(scrFile, destFile);
		 }
		 
		catch(IOException e)
		 {
			
		 }
		
	    }
	}
	
	public static void verifyPageByTitle(WebDriver driver,String expTitle,String substring)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(substring));
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		
	}

				
}
	
	

