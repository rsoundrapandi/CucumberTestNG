package com.google.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.resources.WaitHelper;

public class Googlesearchresult {

	public WebDriver driver;
	public WaitHelper wait;

	public Googlesearchresult(WebDriver driver) {
		this.driver = driver;
		wait = new WaitHelper(this.driver);
	}

	By title = By.tagName("body");
	By left_Menu = By.xpath("//ul[@role='tablist']//li[@role='tab']");
	By search_Result = By.id("#search");
	By top_Stories = By.xpath("//a[@role='heading link']");
	By topstories_Links = By
			.xpath("//*[text()='Top stories']/../../../following-sibling::div//div[@role='listitem']//a ");
	By common_Ques = By.xpath("//h2[contains(text(),'questions')]");
	By moh_Links = By.xpath("//a[contains(@href,'moh.gov.my')]");

	public WebElement title() {
		return driver.findElement(title);
	}

	public WebElement searchResult() {
		return driver.findElement(search_Result);
	}

	public WebElement gettopStories() {
		return driver.findElement(top_Stories);
	}

	public List<WebElement> gettopStoriesLink() {
		return driver.findElements(topstories_Links);
	}

	public List<WebElement> mohLinks() {
		return driver.findElements(moh_Links);
	}

	//Get MOH link and launch in new window
	public String getMohLinks() throws InterruptedException {
		String title = "";
		try {
			String Action = Keys.chord(Keys.CONTROL, Keys.ENTER);
			mohLinks().get(0).sendKeys(Action);
			Thread.sleep(5000);
			Set<String> windowHandle = driver.getWindowHandles();
			Iterator<String> windowsCount = windowHandle.iterator();
			while (windowsCount.hasNext()) {
				driver.switchTo().window(windowsCount.next());
				wait.waitUntilClick(title(), 100);
				title = driver.getTitle();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}

	public List<WebElement> getLeftMenu() {
		return driver.findElements(left_Menu);
	}

	public WebElement questionsIsDisplayed() {
		return driver.findElement(common_Ques);

	}

	public List<WebElement> commonQuestions() {
		return driver.findElements(common_Ques);
	}

	// Navigate to menu list and find the Common Questions

	public boolean getCommonQuestions(String menuLinkName) throws InterruptedException {
		Boolean value = false;
		try {

			for (int i = 0; i < getLeftMenu().size(); i++) {
				if (getLeftMenu().get(i).getText().contains(menuLinkName)) {
					getLeftMenu().get(i).click();
					wait.waitElement(questionsIsDisplayed(), 100);
					value = questionsIsDisplayed().isDisplayed();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;
	}
}