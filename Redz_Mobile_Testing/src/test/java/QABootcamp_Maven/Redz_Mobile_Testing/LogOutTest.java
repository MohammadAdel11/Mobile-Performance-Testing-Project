package QABootcamp_Maven.Redz_Mobile_Testing;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogOutTest extends TestBase {
	
	LogOut logOut;

	@BeforeClass
	public void setUpPage() {
		logOut = new LogOut(driver);
	}
	
	@Test
	public void checkLogOut() {
		logOut.logOut();
		
		Assert.assertTrue(logOut.checkLogOut(),"(Log into Redz) Should appear");
	}

}
