package QABootcamp_Maven.Redz_Mobile_Testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	protected static  AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Mohammad");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		caps.setCapability("appPackage", "com.homyt.thex");
		caps.setCapability("appActivity", "com.homyt.thex.MainActivity");
		caps.setCapability("noReset", true);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	}

	@AfterTest
	public void TearDown() {
		if (driver != null)
			driver.quit();
	}

}
