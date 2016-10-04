package com.wirecard.NTLTaxi.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.wirecard.NTLTaxi.reportsgeneration.ReportOptimizer;

public class Initiatizer {

	// Initializing Env Property file
	public static boolean isarchive =true;
	public static FileInputStream envfis;
	public static Properties envprop;
	// Initializing locator property
	public static FileInputStream locfis;
	public static Properties locprop;

	// Initializing the web driver

	public static WebDriver wd=null;
	public static ExtentReports report;
    public static ExtentTest log;
    

	public static void initialize() throws Throwable {

		report = new ExtentReports("C:\\workspace\\DDDTest\\reports\\sample.html");
        ReportOptimizer.archiveFiles();
		envfis = new FileInputStream(new File("C:\\workspace\\DDDTest\\src\\test\\resources\\com\\wirecard\\NTLTaxi\\config\\env.properties"));
		envprop = new Properties();
		envprop.load(envfis);

		locfis = new FileInputStream(new File("C:\\workspace\\DDDTest\\src\\test\\resources\\com\\wirecard\\NTLTaxi\\config\\locator.properties"));
		locprop = new Properties();
		locprop.load(locfis);
		
		if(wd==null){
		if (envprop.get("BROWSER").equals("FIREFOX")) {
			wd = new FirefoxDriver();
		} else if (envprop.getProperty("BROWSER").equals("CHROME")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\sudhakar\\workspace\\WebDriverTest\\chromedriver.exe");
//		
//			 wd = new ChromeDriver();
		}
		}
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	public static WebElement getElementByXpath(String Xpath){
		return wd.findElement(By.xpath(locprop.getProperty(Xpath)));
		
	}

}
