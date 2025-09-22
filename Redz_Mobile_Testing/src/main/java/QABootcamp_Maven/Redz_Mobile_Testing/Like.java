package QABootcamp_Maven.Redz_Mobile_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Like {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	public Like(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}


	
	public void ClickLike() throws InterruptedException {
	    Thread.sleep(1000);
	    TouchAction action = new TouchAction(driver);
	    action.tap(PointOption.point(1242, 2000)).perform();  
	}


	public int getLikeCount() {
	    By likeCountLocator = By.xpath("//android.widget.TextView[@bounds='[1170,2022][1314,2065]']");
	    WebDriverWait wait = new WebDriverWait(driver, 10);

	    MobileElement likeCountEl = (MobileElement) wait.until(
	        ExpectedConditions.visibilityOfElementLocated(likeCountLocator)
	    );

	    return Integer.parseInt(likeCountEl.getText());
	}

}
