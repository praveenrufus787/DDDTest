package com.wirecard.NTLTaxi.reportsgeneration;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.wirecard.NTLTaxi.initializer.Initiatizer;

public class Screenshotgenerator extends Initiatizer {

	public static void takescreenshot(ITestResult result) throws Exception {
		Object[] data = result.getParameters();
		if (result.isSuccess()) {
			String path = getscreenshot(data[0].toString());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "Test case Pass", path);
		} else {
			String path = getscreenshot(data[0].toString());
			log.addScreenCapture(path);
			log.log(LogStatus.FAIL, "Test case Fail", path);

		}
		report.endTest(log);
		report.flush();
	}

	public static String getscreenshot(String name) throws Exception {
		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\workspace\\DDDTest\\screenshot\\" + name
				+ ".jpg");
		org.apache.commons.io.FileUtils.copyFile(src, dest);
		return dest.toString();
	}

}
