package com.br.mobinov.android;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.br.lab.property.MobileProperty;
import com.br.lab.property.MobileProperty.DevicePlatform;


public class HiAppiumTest {

	private static final String APPIUM_SERVER = "http://127.0.0.1:4723/wd/hub/";
	private static final int SIXTY_SECONDS = 60;
	private AppiumDriver appiumDriver;

	@Before
	public void setup() throws IOException{
		DesiredCapabilities capabilities = new MobileProperty(DevicePlatform.IOS).buildAndroidCapabilities();
		appiumDriver = createAppiumDriver(capabilities);
	}
	
	@After
	public void closeSession(){
	//	appiumDriver.closeApp();
	//	appiumDriver.close(); 
	//	appiumDriver.quit();
	}

	@Test
	public void test() throws MalformedURLException {
		appiumDriver.manage().timeouts().implicitlyWait(SIXTY_SECONDS, TimeUnit.SECONDS);
		WebElement okButton = getElementByName("OK");
		okButton.click();
	}

	private WebElement getElementByName(String buttonName) {
		WebElement okButton = appiumDriver.findElementByName(buttonName);
		return okButton;
	}

	private AppiumDriver createAppiumDriver(DesiredCapabilities capabilities)
			throws MalformedURLException {
		URL appiumServerURL = new URL(APPIUM_SERVER);
		AppiumDriver appiumDriver = new AppiumDriver(appiumServerURL, capabilities);
		return appiumDriver;
	}
}