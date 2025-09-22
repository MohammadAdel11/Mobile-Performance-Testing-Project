package QABootcamp_Maven.Redz_Mobile_Testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Comment {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	public Comment(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	// write comments

	private By tField_Comment = By.className("android.widget.EditText");

	private By add_Comment_Icon = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");

	// like comment
	private By like_Comment_Icon = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)");

	private By check_Like = MobileBy.AndroidUIAutomator("new UiSelector().text(\"1\")");

	// close comment page
	private By close_Comment_Page = By.className("android.widget.Button");
	// long click comment
	private By locgClickComment = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(7)");

	// delete comment
	private By deleteComment = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(2)");
	private By checkdeleteComment = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Deleted\")");
	//Edit
	private By update = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Update\")");
	private By editCommentIcon = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");
	
	//Replay
	private By replay = MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Reply\").instance(0)");
	private By nestidReplay = MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Reply\").instance(0)");
	


	public void typeComment(String comment) throws InterruptedException {

		openComentPage();

		MobileElement el = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(tField_Comment));

		el.sendKeys(comment);

		driver.findElement(add_Comment_Icon).click();
	}

	public void like_Comment() {
		driver.findElement(like_Comment_Icon).click();
	}

	public void closeCommentPage() {
		driver.findElement(close_Comment_Page).click();
	}
	

	public void openComentPage() throws InterruptedException {
		Thread.sleep(3000);
	    TouchAction action = new TouchAction(driver);
	    action.tap(PointOption.point(1242, 2199)).perform();
	}
	
	public void ClickSave() throws InterruptedException {
		Thread.sleep(3000);
	    TouchAction action = new TouchAction(driver);
	    action.tap(PointOption.point(1242, 2374)).perform();
	}
	public int getSaveCount() {
	    By saveCountLocator = By.xpath("//android.widget.TextView[@bounds='[1170,2372][1314,2415]']");
	    WebDriverWait wait = new WebDriverWait(driver, 10);

	    MobileElement saveCountEl = (MobileElement) wait.until(
	        ExpectedConditions.visibilityOfElementLocated(saveCountLocator)
	    );

	    return Integer.parseInt(saveCountEl.getText());
	}

	



	public boolean checkLike(String num) {
		MobileElement el = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(check_Like));
		String count = el.getText();
		return count.equals(num);
	}
	
	public boolean hasLikes() {
	    List<MobileElement> likes = driver.findElements(By.className("android.widget.TextView"));
	    for (MobileElement el : likes) {
	        String txt = el.getText();
	        if (txt.matches("\\d+")) {   
	            int count = Integer.parseInt(txt);
	            if (count > 0) return true;
	        }
	    }
	    return false;
	}


	private void longPressComment() {
		MobileElement element = driver.findElement(locgClickComment);

		new TouchAction<>(driver).longPress(PointOption.point(element.getCenter()))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();
	}

	public void deleteComment() {
		longPressComment();
		driver.findElement(deleteComment).click();

	}

	public boolean checkDeleted() {
		closeCommentPage();
		MobileElement el = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(checkdeleteComment));
		
		return el.isDisplayed();
	}
	
	public boolean checkAddComent(String comment) {
		MobileElement el = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().text(\""+comment+"\")")));
		return el.isDisplayed();
	}
	
	public void editComment(String newComment) {
		longPressComment();
		driver.findElement(editCommentIcon).click();
		MobileElement el = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(tField_Comment));
		el.clear();
		el.sendKeys(newComment);
		driver.findElement(update).click();

	}
	
	public boolean checkUpdated() {
		MobileElement el = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Great\")")));
		return el.isDisplayed();
	}
	
	public void replayComment() {
		driver.findElement(replay).click();
		MobileElement el = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(tField_Comment));
		el.sendKeys(" This is a replay massage");
		driver.findElement(add_Comment_Icon).click();

	}
	
	public void nestidReplayComment() {
		driver.findElement(nestidReplay).click();
		MobileElement el = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(tField_Comment));
		el.sendKeys(" This is a nestid replay massage");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(2)")).click();

	}
	
	public boolean checkReplay() {
	    MobileElement el = (MobileElement) wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            MobileBy.AndroidUIAutomator(
	                "new UiSelector().className(\"android.widget.TextView\").textContains(\"This is a replay massage\")"
	            )
	        )
	    );
	    return el.isDisplayed();
	}
	
	public boolean checkNestidReplay() {
	    MobileElement el = (MobileElement) wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            MobileBy.AndroidUIAutomator(
	                "new UiSelector().className(\"android.widget.TextView\").textContains(\"This is a nestid replay massage\")"
	            )
	        )
	    );
	    return el.isDisplayed();
	}
	
	public void ShareVideo() {
	    new TouchAction<>(driver)
	        .tap(PointOption.point(1242, 2549))
	        .perform();
	    
	    selectFriendToShareVideo();
	}
	
	private void selectFriendToShareVideo() {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")).sendKeys("See This..");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Send\")")).click();

		;
		
	}
	
	public boolean checkVideoSent() {
	    MobileElement el = (MobileElement) wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            MobileBy.AndroidUIAutomator(
	                "new UiSelector().className(\"android.widget.TextView\").textContains(\"Message sent to\")"
	            )
	        )
	    );
	    return el.isDisplayed();
	}





}
