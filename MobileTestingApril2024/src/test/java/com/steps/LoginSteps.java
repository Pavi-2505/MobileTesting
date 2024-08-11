package com.steps;

import java.net.MalformedURLException;

import org.libglobal.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass {

	@Given("User is on Wizz Air Login Screen")
	public void user_is_on_wizz_air_login_screen() throws MalformedURLException {

	}

	@When("User enters username {string} and password {string} and click on singin Button")
	public void user_enters_username_and_password_and_click_on_singin_button(String userName, String password) {
		WebElement optAllowAll = driver.findElement(By.id("privacy_policy_allow"));
		elementClick(optAllowAll);

		WebElement optSingIn = driver.findElement(By.xpath("//*[@text='SIGN IN']"));
		elementClick(optSingIn);

		WebElement txtUserName = driver.findElement(By.id("sign_in_email"));
		elementSendKeys(txtUserName, userName);

		WebElement txtPassword = driver.findElement(By.id("sign_in_password"));
		elementSendKeys(txtPassword, password);

		WebElement btnLogin = driver.findElement(By.id("sign_in_btn"));
		elementClick(btnLogin);

	}

	@Then("User Verify Home Page is Displayed")
	public void user_verify_home_page_is_displayed() {
		System.out.println("home page is dispalyed");
	}

}
