package QABootcamp_Maven.Redz_Mobile_Testing;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ChangeLocationTest extends TestBase{
	ChangeLocationPage locationPage ;
	
	@BeforeClass
	public void setUpPage() {
         locationPage = new ChangeLocationPage(driver);
	}
	
	
	@Test(priority = 1)
    public void testChangeLocationValid() throws InterruptedException {
        locationPage.clickLocationIcon();
        locationPage.searchLocation("New York");
        Thread.sleep(3000);
        locationPage.selectFirstResult();
        Thread.sleep(3000);
        Assert.assertEquals(locationPage.getHomePageLocationNEw(), "New York Mills, New York",
                "Location should be updated to New York");
    }

    @Test(priority = 2)
    public void testChangeLocationInvalidChars() throws InterruptedException {
        locationPage.clickLocationIcon();
        locationPage.searchLocation("xvfd");
        Thread.sleep(3000);
        Assert.assertEquals(locationPage.getErrorMessage(), "No result found",
                "Error message should be displayed for invalid location");
        locationPage.getBackArrow();
    }

    @Test(priority = 3)
    public void testChangeLocationBlankField() throws InterruptedException {
        locationPage.clickLocationIcon();
        locationPage.searchLocation(" ");
        Thread.sleep(3000);
        Assert.assertTrue(locationPage.getloadingWheel(),"Loading wheel should be visible");
        locationPage.getBackArrow();
    }


    @Test(priority = 4)
    public void testChangeLocationUIUpdate() throws InterruptedException {
        locationPage.clickLocationIcon();
        locationPage.searchLocation("Paris, Arkansas");
        Thread.sleep(3000);
        locationPage.selectFirstResultParis();
        Thread.sleep(3000);
        Assert.assertTrue(locationPage.getHomePageLocation().contains("Paris, Arkansas"),
                "UI should update based on location selection");
    }
	
	


}
