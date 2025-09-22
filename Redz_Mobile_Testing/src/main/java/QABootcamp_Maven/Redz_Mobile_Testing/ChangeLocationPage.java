package QABootcamp_Maven.Redz_Mobile_Testing;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeLocationPage {
	private   AndroidDriver<MobileElement> driver;
     
//   private By locationIcon = By.xpath("(//android.view.View[@content-desc=\"Location icon\"])[1]"); 
    private By searchBox = By.className("android.widget.EditText");  // Example ID, update it
//    private By firstLocationResult = By.xpath("//android.widget.TextView[@text=\"New York\"]");
    
//    private By firstLocationResult=By.xpath("//android.view.View[@content-desc='FirstLocation']");
    private By firstLocationResultParis=By.xpath("//android.widget.TextView[@text=\"Paris, Arkansas\"]");
    private By errorMessageForInvalid = By.xpath("//android.widget.TextView[@text=\"No result found\"]"); 
    private By homePageLocation = By.xpath("//android.widget.TextView[@text=\"Paris, Arkansas\"]");
    private By homePageLocationNew = By.xpath("//android.widget.TextView[@text=\"New York Mills, New York\"]");
    private By loadingWheel =By.xpath("(//android.view.View[@content-desc=\"LoadingWheel\"])[1]");
   private By BackArrow=By.xpath("//android.widget.Button");
    
    // Constructor
    public ChangeLocationPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    // Actions
    public void clickLocationIcon() {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	WebElement locationIcon = wait.until(ExpectedConditions.elementToBeClickable(
    	    By.xpath("(//android.view.View[@content-desc='Location icon'])[1]")
    	));
    	locationIcon.click();
    	
//        driver.findElement(locationIcon).click();
    }

    public void searchLocation(String locationName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(locationName);
    }

    public void selectFirstResult() {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	    By.xpath("//android.widget.TextView[@text='New York']")
    	));
    	location.click();
    	
//        driver.findElement(firstLocationResult).click();
    }
    public void selectFirstResultParis() {
        driver.findElement(firstLocationResultParis).click();
    }

    public String getHomePageLocation() {
        return driver.findElement(homePageLocation).getText();
    }
    public String getHomePageLocationNEw() {
        return driver.findElement(homePageLocationNew).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessageForInvalid).getText();
    }
    
    public boolean getloadingWheel() {
        return driver.findElement(loadingWheel).isDisplayed();
    }
    public void getBackArrow() {
    	driver.findElement(BackArrow).click();
    }
    
    

}
