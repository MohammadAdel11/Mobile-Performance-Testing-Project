package QABootcamp_Maven.Redz_Mobile_Testing;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Like_Test extends TestBase {
	Like like;

	@BeforeClass
	public void setUpPage() {
		like = new Like(driver);
	}
	
	@Test(priority=1)
	public void checkLikeVideo() throws InterruptedException {
	    int before = like.getLikeCount();
	    like.ClickLike();
	    int after = like.getLikeCount();

	    Assert.assertTrue(after > before, "Like video should increase the count");
	}

	@Test(priority=2)
	public void checkUnLikeVideo() throws InterruptedException {
	    int before = like.getLikeCount();
	    like.ClickLike(); 
	    int after = like.getLikeCount();

	    Assert.assertTrue(after < before, "UnLike video should decrease the count");
	}

}
