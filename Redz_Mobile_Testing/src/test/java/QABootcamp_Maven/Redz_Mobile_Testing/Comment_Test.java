package QABootcamp_Maven.Redz_Mobile_Testing;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Comment_Test extends TestBase {
	Comment comment;
	private String comments = "Nice";
	
	@BeforeClass
	public void setUpPage() {
		comment = new Comment(driver);
	}
	
	
	@Test(priority=0)
	public void checkAddComment() throws InterruptedException  {
		comment.typeComment(comments);
		Assert.assertTrue(comment.checkAddComent(comments),"Comment should be displayed");
		
		
		
	}
	@Test(priority=1)
	public void checkLikeComment() throws InterruptedException {
		
		comment.like_Comment();
		comment.closeCommentPage();
		comment.openComentPage();
		Thread.sleep(2000);
		Assert.assertTrue(comment.checkLike("1"),"Count of likes should be 1");
	}
	

	
	
	@Test(priority=2)
	public void checkUpdateComment() {
		comment.editComment("Great");
		
		Assert.assertTrue(comment.checkUpdated(),"Comment should be Updated");

		
	}
	
	@Test(priority=3)
	public void checkUnLikeComment() throws InterruptedException {
		
		comment.like_Comment();
		comment.closeCommentPage();
		comment.openComentPage();
		
		Assert.assertFalse(comment.hasLikes(),"Count of likes should be 0");
	}
	

	@Test(priority=4)
	public void checkReplayComment() throws InterruptedException {
		comment.replayComment();
		
		Assert.assertTrue(comment.checkReplay(), "Replay message should be visible");
	
	}
	
	@Test(priority=5)
	public void checkNestidReplayComment() throws InterruptedException {
		comment.nestidReplayComment();
		
		Assert.assertTrue(comment.checkNestidReplay(), "Nestid replay message should be visible");
	
	}
	
	@Test(priority=6)
	public void checkDeleteComment() throws InterruptedException {
		Thread.sleep(3000);
		comment.deleteComment();
		
		Assert.assertTrue(comment.checkDeleted(),"Comment should be deleted");

		
	}
	
	@Test(priority=7)
	public void checkSaveVideo() throws InterruptedException {
	    int before = comment.getSaveCount();
	    comment.ClickSave();
	    int after = comment.getSaveCount();

	    Assert.assertTrue(after > before, "Save video should increase the count");
	}

	
	@Test(priority=8)
	public void checkUnSaveVideo() throws InterruptedException {
	    int before = comment.getSaveCount();
	    comment.ClickSave(); 
	    int after = comment.getSaveCount();

	    Assert.assertTrue(after < before, "UnSave video should decrease the count");
	}
	
	@Test(priority=9)
	public void checkSendVideo() throws InterruptedException {
		comment.ShareVideo();
		
		Assert.assertTrue(comment.checkVideoSent(),"Video should be send to friend");

		
	}
	
	

}
