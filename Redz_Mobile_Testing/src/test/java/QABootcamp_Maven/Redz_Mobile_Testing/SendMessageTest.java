package QABootcamp_Maven.Redz_Mobile_Testing;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SendMessageTest extends TestBase {
	FollowUnfollowPage page1;
	SendMessagePage page;
	@BeforeClass
	public void setUpPage() {
		 page1 = new FollowUnfollowPage(driver);
	         page = new SendMessagePage(driver);

	}

    @Test(priority = 1)
    public void testSendMessageValid() throws InterruptedException {
        page1.openExplore();
		page1.openSearch();
		page1.searchUser1("linashaqoura");
		Thread.sleep(5000);
        page.openProfile();
        page.clickMessageButton();
        page.writeMessage("Hello");
        Thread.sleep(5000);
        page.sendMessage();
        Assert.assertTrue(page.isMessageInChatHistory("Hello"), "Message should appear in chat history");
    }
    
    @Test(priority = 2)
    public void testSendEmptyMessage() throws InterruptedException {
       
        page1.openExplore();
		page1.openSearch();
		page1.searchUser1("linashaqoura");
		Thread.sleep(5000);
        page.openProfile();
        page.clickMessageButton();
        page.writeMessage(" ");
        page.sendMessage();
        Assert.assertEquals(page.getErrorMessage(), "Message cannot be empty", "Error should be displayed for empty message");
    }


}
