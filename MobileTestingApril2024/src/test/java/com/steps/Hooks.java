package com.steps;

import java.net.MalformedURLException;

import org.libglobal.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void beforeScenario() throws MalformedURLException {
		System.out.println("before..");
		launchApp("Galaxy A22", "Android", "12", "com.wizzair.WizzAirApp", "com.wizzair.app.MainActivityV2", true);
		implicitWait(30);
	}

	@After
	public void afterScenario(Scenario s) {

		if (s.isFailed()) {
			s.attach(screenshot(), "image/png", "failed");
		} else {
			s.attach(screenshot(), "image/png", "passed");
		}

		System.out.println("after..");
		closeApp();
	}

}
