package com.google.stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.google.pages.Googlehome;
import com.google.pages.Googlesearchresult;
import com.google.resources.Browsers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	WebDriver ldriver = Browsers.getDriver();
	Googlehome google = new Googlehome(ldriver);
	Googlesearchresult result = new Googlesearchresult(ldriver);
	public static Logger log = LogManager.getLogger(GoogleSearchSteps.class);
	boolean common;
	boolean top;
	String pageTitle;

	@Given("^Navigate to Google Website")
	public void navigate_to_google_website(String url) {
		ldriver.get(url);
	}

	@And("^Enter Search Keyword$")
	public void enter_search_keyword(String search) {
		google.enterValueInSearch().sendKeys(search);
	}

	@When("^Click the GoogleSearch button$")
	public void click_the_googlesearch_button() {
		google.clickGoogleSearch().click();
	}

	@Then("^Search results Should be displayed$")
	public void search_results_should_be_displayed() {
		String getresult = google.enterValueInSearch().getAttribute("value");
		log.info(getresult);
		log.info("*******Covid19 Search results are displayed ****");
	}

	@When("^Validate the Top Stories section is available$")
	public void validate_the_top_stories_section_is_available() {
		top = result.gettopStories().isDisplayed();
	}

	@Then("^Top Stories section should be available$")
	public void top_stories_section_should_be_available(String stories) {
		if (top) {
			Assert.assertEquals(result.gettopStories().getText(), stories);
			Assert.assertEquals(result.gettopStoriesLink().size(), 10);
			log.info("*****TopStories Section is displayed ******");
		} else {
			log.info("TopStories Section is not available");
		}

	}

	@When("^Validate the Common questions is available$")
	public void validate_the_common_questions_is_available(String menu) throws InterruptedException {
		common = result.getCommonQuestions(menu);
	}

	@Then("^Common questiuons section should be available$")
	public void common_questiuons_section_should_be_available() {
		Assert.assertTrue(common);
	}

	@When("^Click the link$")
	public void click_the_link() throws Throwable {
		pageTitle = result.getMohLinks();
	}

	@Then("^MOH Website should be launched$")
	public void moh_website_should_be_launched() {
		Assert.assertEquals(pageTitle, "Home | COVID-19 MALAYSIA");
		log.info("*****MOH Website is Launched******");
	}

}
