package QABootcamp_Maven.Redz_Mobile_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LogOut {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	public LogOut(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	private By profile = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Profile\")");
	private By userProfileSetting = MobileBy.AccessibilityId("user_profile_settings_menu");
	private By logOut = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Log Out\")");
	private By confirmLogOut = MobileBy.AccessibilityId("profile_logout_dialog_confirm_button");
	private By loginScreen = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Log into Redz\")");

	public void logOut() {
		wait.until(ExpectedConditions.elementToBeClickable(profile)).click();

		wait.until(ExpectedConditions.elementToBeClickable(userProfileSetting)).click();

		wait.until(ExpectedConditions.elementToBeClickable(logOut)).click();

		wait.until(ExpectedConditions.elementToBeClickable(confirmLogOut)).click();
	}

	public boolean checkLogOut() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loginScreen)).isDisplayed();
	}
}
