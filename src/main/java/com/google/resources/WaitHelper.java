package com.google.resources;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	public WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void waitElement(WebElement title,long TimeSeconds) {
		
		WebDriverWait wait=new WebDriverWait(driver,TimeSeconds);
		
		wait.until(ExpectedConditions.visibilityOf(title));
	
		
	}
	
	public void waitUntilClick(WebElement webElement,long TimeSeconds) {
		
		WebDriverWait wait=new WebDriverWait(driver,TimeSeconds);
		
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		
		
	}
	
	public void implicitWait(long Timeseconds, TimeUnit Unit) {
		
		driver.manage().timeouts().implicitlyWait(Timeseconds, Unit);
		
		
	}


}
