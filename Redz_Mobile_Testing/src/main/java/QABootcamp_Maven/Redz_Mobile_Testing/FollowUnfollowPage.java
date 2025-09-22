package QABootcamp_Maven.Redz_Mobile_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FollowUnfollowPage {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	// Locators
	private By exploreButton = By.xpath("//android.view.View[@content-desc=\"explore_tab_bar\"]");
	private By searchInput = By.xpath("//android.view.View[@content-desc=\"Search icon\"]");
	private By searchInput2 = By.xpath("//android.widget.EditText");
	private By firstUserResult = By.xpath(
			"//J1.n0/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]");
	private By followingButton = By.xpath("(//android.widget.TextView[@text=\"Following\"])[2]");
	private By followButton = By.xpath("//android.widget.TextView[@text=\"Follow\"]");
	private By confirmUnfollowButton = By.xpath(
			"//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button");
	private By noResultsError = By.xpath("//android.widget.TextView[@text=\"No results found\"]");
	private By backArrow = By.xpath("//J1.n0/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
	private By BackArrowExplore = By.xpath("//android.widget.Button[@bounds='[15,199][159,343]']");

	public FollowUnfollowPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}

	public void openExplore() {
		wait.until(ExpectedConditions.elementToBeClickable(exploreButton));
		driver.findElement(exploreButton).click();
	}

	public void openSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(searchInput));
		driver.findElement(searchInput).click();
	}

	public void searchUser1(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput2));
		driver.findElement(searchInput2).clear();
		driver.findElement(searchInput2).click();
		driver.findElement(searchInput2).sendKeys(username);
	}

	public void clickFirstUser() {

		wait.until(ExpectedConditions.elementToBeClickable(firstUserResult));
		driver.findElement(firstUserResult).click();
	}

	public void clickFollowButton() {
		wait.until(ExpectedConditions.elementToBeClickable(followButton));
		driver.findElement(followButton).click();
	}

	public String getFollowingButtonText() {
		return driver.findElement(followingButton).getText();
	}

	public String getFollowButtonText() {
		return driver.findElement(followButton).getText();
	}

	public void clickUnfollowButton() {
		wait.until(ExpectedConditions.elementToBeClickable(followingButton));
		driver.findElement(followingButton).click();
	}

	public void cofirmUnfollowButton() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmUnfollowButton));
		driver.findElement(confirmUnfollowButton).click();
	}

	public String getNoResultsError() {
		return driver.findElement(noResultsError).getText();
	}
	public void clickBackArrow() {
		driver.findElement(backArrow).click();
	}
	public void clickBackArrowExplore() {
		driver.findElement(BackArrowExplore).click();
	}

}
