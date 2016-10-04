package temp;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import com.sun.jna.platform.FileUtils;


public class ReportTest 
{
	public static WebDriver wd;
	public static ExtentReports report;
    public static ExtentTest log;
    
	
@Test(priority=1)
public void googletest()
{
	wd= new FirefoxDriver();
	report = new ExtentReports("C:\\workspace\\DDDTest\\reports\\sample.html");
	log= report.startTest("GoogleTest");
	wd.get("https://www.google.co.in/");
}
@Test(priority=2)
public void yahootest()
{
	log= report.startTest("yahooTest");
	wd.get("https://in.yahoo.com/?p=us");
}
@Test(priority=3)
public void bingtest()
{
	log= report.startTest("BingTest");
wd.get("http://www.bing.com/");	
}
@AfterMethod
public void teardown(ITestResult result) throws Exception
{
	if (result.isSuccess())
			{
String path= getscreenshot(result.getName());
log.addScreenCapture(path);
log.log(LogStatus.PASS, "Test case Pass",path);
			}
	else
	{
		String path= getscreenshot(result.getName());
		log.addScreenCapture(path);
		log.log(LogStatus.FAIL, "Test case Fail",path);

	}
	report.endTest(log);
	report.flush();
}
public static String getscreenshot(String name) throws Exception
{
	File src =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\workspace\\DDDTest\\screenshot\\"+name+".jpg");
			org.apache.commons.io.FileUtils.copyFile(src, dest);
			return dest.toString();
}
}
