package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com.steps", dryRun = false, plugin = { "pretty",
		"junit:target\\wizzair.xml", "html:target\\result.html", "json:target\\output.json" })
public class TestRunner {

	@AfterClass
	public static void afterClass() {

		Reporting.generateJVMReport(System.getProperty("user.dir") + "\\target\\output.json");

	}

}
