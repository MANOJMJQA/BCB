import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BCBBaseclass.BaseClass;
import BrowserSetup.Setup;
import PageObjectModel.LoginPage;

public class login extends BaseClass {
	WebDriver driver = null;

	@BeforeClass
	public void browerstart() throws IOException {
		this.driver = Setup.startBrowser();

	}

//	@AfterClass
//	private void afterMethid() {
//		this.driver.quit();
//
//	}
	// testcase for empty validation
	@Test(priority = 1)
	public void verifyinvalidcred() {

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.emptyValidation();

	}

	// testcase for invalid email address
	@Test(priority = 2)
	public void verifyinvalidemail() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
         loginpage.invalidcreadvalidationmail();
		
	}
	 @Test(priority=3)
//  verify invalid password
	public void invalidpass() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.InvalidCreadpass();
		

	}
	 @Test(priority=4)
	 public void Newuser() {
		 LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		 loginpage.Newemailregistration();

	}
	 @Test(priority=5)
	 public void sucesslogin() {
		 LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		 loginpage.sucessLogin();

	}
	 
	 

}
