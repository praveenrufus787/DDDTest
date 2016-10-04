package com.wirecard.NTLTaxi.PageObjects;

import org.openqa.selenium.WebElement;

import com.wirecard.NTLTaxi.initializer.DriverFunctions;
import com.wirecard.NTLTaxi.initializer.Initiatizer;

public class HomePage extends Initiatizer {
	public static void enterUserName(String UserName) {
		getElementByXpath("HOMEPAGE_TYPE_USERNAME_XPATH").sendKeys(UserName);
	}

	public static void enterMobileNumber(String Mobile) {
		getElementByXpath("HOMEPAGE_TYPE_MOBILE_XPATH").sendKeys(Mobile);
	}

	public static void enterPickUp(String Pickup) {
		getElementByXpath("HOMEPAGE_TYPE_PICKUP_XPATH").sendKeys(Pickup);
	}

	public static void enterDrop(String Drop) {
		getElementByXpath("HOMEPAGE_TYPE_DROP_XPATH").sendKeys(Drop);
	}
	public static void enterClick(){
		getElementByXpath("HOMEPAGE_TYPE_LATER_XPATH").click();
	}
	public static void selectBasic(String option){
		WebElement element = getElementByXpath("HOMEPAGE_TYPE_BASIC_XPATH");
		DriverFunctions.selectVisibleoption(element, option);
	}
}
