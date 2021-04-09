package com.google.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.resources.WaitHelper;

public class Googlehome {
	
	WebDriver driver;
	public WaitHelper wait;
	
	public Googlehome(WebDriver driver) {
		
		this.driver=driver;
		wait=new WaitHelper(this.driver);
	}
	
	By search=By.name("q");
	By search_Button=By.name("btnK");
	By search_Listitems=By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']");
	
	
	public WebElement enterValueInSearch() {
		
		return driver.findElement(search);
	}

	
	/*
	 * public void getsearchresult() throws InterruptedException { List<WebElement>
	 * results =driver.findElements(search_Listitems); for (int i = 0;
	 * i<results.size(); i++) { String resultname = results.get(i).getText(); if
	 * (resultname.contains("covid 19 malaysia")) { results.get(i).click(); break; }
	 * } }
	 */
	
	public WebElement clickGoogleSearch() {
		
		WebElement searchBtn=driver.findElement(search_Button);
		wait.waitElement(searchBtn, 100);
		return searchBtn;
	}

	
}
