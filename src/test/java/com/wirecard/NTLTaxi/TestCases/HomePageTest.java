package com.wirecard.NTLTaxi.TestCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wirecard.NTLTaxi.PageObjects.HomePage;
import com.wirecard.NTLTaxi.initializer.DriverFunctions;
import com.wirecard.NTLTaxi.initializer.Initiatizer;
import com.wirecard.NTLTaxi.inputreader.inputReader;
import com.wirecard.NTLTaxi.reportsgeneration.Screenshotgenerator;

public class HomePageTest extends Initiatizer {
@BeforeTest
public void setup() throws Throwable
{
	initialize();
}
	@Test (dataProvider="HomePageTest")
	public void validateHomePage(String Testdata ,String username, String Mobileno, String Pickup,String Drop,String Basic) throws IOException {
		
		DriverFunctions.loadURL();
		log = report.startTest(Testdata);
		HomePage.enterUserName(username);

		HomePage.enterMobileNumber(Mobileno);
		HomePage.enterPickUp(Pickup);
		HomePage.enterDrop(Drop);
		HomePage.selectBasic(Basic);
		HomePage.enterClick();

	}

	@DataProvider(name="HomePageTest")
	public static Object[][] gethomepagedata() throws Exception
	{
		if(inputReader.RunModeVerification("HomePageTest"))
		{
			Object [] [] data = inputReader.selectSingleDataOrMulitiData("HomePageTest");
//		
//		Object [] [] data = new Object [3] [6];
//		
//		data [0][0] = "HomePageTest_dataset1";
//		data [0][1] = "TEST A";
//		data [0][2]= "111111111";
//		data [0][3]="ADYAR";
//		data [0][4]="ADYAR";
//		data [0][5]="Sedan";
//		
//		data [1][0] = "HomePageTest_dataset2";
//		data [1][1] = "TEST B";
//		data [1][2]= "222222222";
//		data [1][3]="ADYAR";
//		data [1][4]="ADYAR";
//		data [1][5]="Sedan";
//		
//		data [2][0] = "HomePageTest_dataset3";
//		data [2][1] = "TEST C";
//		data [2][2]= "333333333";
//		data [2][3]="ADYAR";
//		data [2][4]="ADYAR";
//		data [2][5]="Sedan";
	return data;
	}
		return null;
	}
	@AfterMethod
	public void teardown(ITestResult result) throws Exception
	{
	Screenshotgenerator.takescreenshot(result);
	}
}
