import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BCBBaseclass.BaseClass;
import BrowserSetup.Setup;

import PageObjectModel.EssentialUserPage;
import PageObjectModel.LoginPage;

public class Essentialplan extends BaseClass{
	
	WebDriver driver;

	@BeforeClass
	public void browerstart() throws IOException {
		this.driver = Setup.startBrowser();
		
		

	}
	
	//Update single Youtube URL
	//@Test(priority=1)
	public void YoutubeUrl() throws Exception {
		LoginPage loginpage = PageFactory.initElements(this.driver, LoginPage.class);
		loginpage.sucessLogin();
		EssentialUserPage user = PageFactory.initElements(driver,EssentialUserPage.class );
		user.singleYoutubeUr();
		

	}
	//Upload single video
//	@Test(priority=1)
	public void singleVideo() throws InterruptedException, AWTException {
		
		LoginPage loginpage = PageFactory.initElements(this.driver, LoginPage.class);
		loginpage.sucessLogin();
		EssentialUserPage user = PageFactory.initElements(driver,EssentialUserPage.class );
		user.UpdateSingleVideo();

	}
	
	
	//User try to upload more than 10URL at the time
	@Test(priority = 1)
	public void WebSiteUrl() throws InterruptedException {
		
		LoginPage loginpage = PageFactory.initElements(this.driver, LoginPage.class);
		loginpage.sucessLogin();
		EssentialUserPage user = PageFactory.initElements(driver,EssentialUserPage.class );
		user.WebsiteURL();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
