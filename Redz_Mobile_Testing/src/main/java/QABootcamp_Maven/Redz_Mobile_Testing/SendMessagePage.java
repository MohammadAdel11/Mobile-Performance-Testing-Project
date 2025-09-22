package QABootcamp_Maven.Redz_Mobile_Testing;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SendMessagePage {
    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    // Locators (replace with actual IDs)
    private By profileButton = By.xpath("//J1.n0/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]");
//    private By messageButton = By.xpath("//android.widget.TextView[@text='Message']");
    private By messageButton = MobileBy.AndroidUIAutomator(
    	    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Message\"))");

    private By messageInput = By.xpath("//android.widget.EditText");
    private By sendButton = By.xpath("//J1.n0/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");
    private By errorMessage = By.xpath("//android.widget.TextView[@text=\" \"]");
    private By chatHistory = By.xpath("(//android.widget.TextView[@text=\"Hello\"])[1]");

    public SendMessagePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void openProfile() {
        driver.findElement(profileButton).click();
    }

    public void clickMessageButton() {
        driver.findElement(messageButton).click();
    }

    public void writeMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void sendMessage() {
        driver.findElement(sendButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isMessageInChatHistory(String message) {
        return driver.findElement(chatHistory).getText().contains(message);
    }
}
