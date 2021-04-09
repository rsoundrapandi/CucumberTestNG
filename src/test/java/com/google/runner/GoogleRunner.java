package com.google.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/com/google/feature/GoogleSearch.feature" }, 
				glue = {"com/google/stepdefinition" },
				monochrome=true,
//				tags="@Smoke",
				plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
				)
public class GoogleRunner extends AbstractTestNGCucumberTests {

}






