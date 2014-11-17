import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.br.lab.property.MobileProperty;


public class HiAppiumTest {

	private AppiumDriver appiumDriver;

	@Before
	public void setup() throws IOException{
		DesiredCapabilities capabilities = new MobileProperty().buildCapabilities();
		appiumDriver = createAppiumDriver(capabilities);
	}
	
	@After
	public void closeSession(){
//		appiumDriver.closeApp();
//		appiumDriver.close(); 
		appiumDriver.quit();
	}

	@Test
	public void test() throws MalformedURLException {
		appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebElement findElement = appiumDriver.findElement(By.name("new"));
		
		findElement.click();
	}

	private AppiumDriver createAppiumDriver(DesiredCapabilities capabilities)
			throws MalformedURLException {
		AppiumDriver appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
		return appiumDriver;
	}

//	private DesiredCapabilities configureCapabilities() {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//
//		capabilities.setCapability("device", "android");
//		capabilities.setCapability("version", "4.x");
//		capabilities.setCapability("deviceType", "phone");
//		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("deviceName", "motorola-xt1033-T099707VK7");
//		return capabilities;
//	}

}
