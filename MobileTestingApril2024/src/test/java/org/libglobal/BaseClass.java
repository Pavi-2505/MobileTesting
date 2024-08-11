package org.libglobal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {

	public static AppiumDriver<WebElement> driver;

	public void launchApp(String deviceName, String platformName, String platformVersion, String appPackage,
			String appActivity, boolean autoGrantPermissions) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("autoGrantPermissions", autoGrantPermissions);

		URL url = new URL("http://localhost:4723/wd/hub");

		driver = new AppiumDriver<WebElement>(url, capabilities);

	}

	public void implicitWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void elementSendKeys(WebElement e, String data) {
		if (enabled(e) && displayed(e) && data != null) {
			e.sendKeys(data);
		}
	}

	public void elementClick(WebElement e) {
		if (enabled(e) && displayed(e)) {
			e.click();
		}

	}

	public void dragAndDrop(WebElement source, WebElement target) {
		TouchAction action = new TouchAction(driver);
		action.press(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
	}

	public void scrollDown() {
		Dimension size = driver.manage().window().getSize();
		Double start = size.getHeight() * 0.5;
		int startHeight = start.intValue();
		Double end = size.getHeight() * 0.2;
		int endHeight = end.intValue();
		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(100, startHeight)).moveTo(PointOption.point(100, endHeight)).release()
				.perform();
	}

	public void scrollDownTillLocatorFound(List<WebElement> list) {

		while (list.size() == 0) {
			scrollDown();
		}
		if (list.size() != 0) {
			list.get(0).click();
		}

	}

	public void tapOnElement(int x, int y) {

		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(x, y)).perform();

	}

	public void closeApp() {
		driver.quit();
	}

	public boolean displayed(WebElement e) {
		return e.isDisplayed();
	}

	public boolean enabled(WebElement e) {
		return e.isEnabled();
	}

	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
		return bs;
	}

}
