package com.wirecard.NTLTaxi.initializer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverFunctions extends Initiatizer{
	public static void loadURL(){
		wd.get(envprop.getProperty("URL"));
	}
public static void selectVisibleoption(WebElement element,String option){
	Select s = new Select(element);
	s.selectByVisibleText(option);
}
}
