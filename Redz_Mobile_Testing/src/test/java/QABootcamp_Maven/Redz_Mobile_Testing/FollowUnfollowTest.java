package QABootcamp_Maven.Redz_Mobile_Testing;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class FollowUnfollowTest extends TestBase {
	FollowUnfollowPage page;
	@BeforeClass
	public void setUpPage() {
		 page = new FollowUnfollowPage(driver);
	}
	

	@Test(priority = 1)
	public void testFollowValidUser() throws InterruptedException {
		page.openExplore();
		page.openSearch();
		page.searchUser1("linashaqoura");
		Thread.sleep(5000);
		page.clickFirstUser();
		page.clickFollowButton();
		Thread.sleep(2000);
		Assert.assertEquals(page.getFollowingButtonText(), "Following", "User should be followed successfully");
		page.clickBackArrow();
		page.clickBackArrowExplore();
	}

	@Test(priority = 2)
	public void testUnfollowUser() throws InterruptedException {
		page.openExplore();
		page.searchUser1("linashaqoura");
		Thread.sleep(5000);
		page.clickFirstUser();
		page.clickUnfollowButton();
		page.cofirmUnfollowButton();
		Thread.sleep(2000);
		Assert.assertEquals(page.getFollowButtonText(), "Follow", "Button should change back to Follow after unfollow");
		page.clickBackArrow();
		page.clickBackArrowExplore();

	}

	@Test(priority = 3)
	public void testFollowInvalidUser() throws InterruptedException {
		page.openExplore();
		page.searchUser1("invalid!");
		Thread.sleep(2000);
		Assert.assertEquals(page.getNoResultsError(), "No results found", "Error message should be displayed");
	}
	
	


}
