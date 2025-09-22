package QABootcamp_Maven.Redz_Mobile_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LogIn {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    public LogIn(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    // locators
    private By userName = MobileBy.AndroidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").instance(0)");
    private By pass = MobileBy.AndroidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").instance(1)");
    private By log = MobileBy.xpath("//android.widget.ScrollView/android.view.View/android.widget.Button");

    private By errorMessage = MobileBy.AndroidUIAutomator(
            "new UiSelector().textContains(\"Incorrect email, username, or password\")");
    private By nextBtn = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Next\")");

    // 🟢 تفريغ الحقول
    public void clearFields() {
        try {
            driver.findElement(userName).clear();
        } catch (Exception e) {}
        try {
            driver.findElement(pass).clear();
        } catch (Exception e) {}
    }

    public void Login(String userName, String pass) {
        clearFields();  

        if (!userName.isEmpty()) {
            driver.findElement(this.userName).sendKeys(userName);
        }
        if (!pass.isEmpty()) {
            driver.findElement(this.pass).sendKeys(pass);
        }
        driver.hideKeyboard();
    }

    public void clickLogIn() {
        MobileElement loginBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(log));
        loginBtn.click();
    }

    public boolean isErrorVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getMessage() {
        try {
            MobileElement error = driver.findElement(errorMessage);
            return error.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isNextVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(nextBtn));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickNext() {
        MobileElement next = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        next.click();
    }

    public boolean isStillOnLoginPage() {
        try {
            return driver.findElement(userName).isDisplayed() && driver.findElement(pass).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
