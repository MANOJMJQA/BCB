import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BCBBaseclass.BaseClass;
import BrowserSetup.Setup;
import PageObjectModel.DatasourcePage;
import PageObjectModel.LoginPage;
import net.bytebuddy.asm.Advice.This;

public class Datasource extends BaseClass {

	WebDriver driver;

	@BeforeClass
	public void browerstart() throws IOException {
		this.driver = Setup.startBrowser();

	}

	@Test(priority = 1)
	public void sucesslogin() {
		LoginPage loginpage = PageFactory.initElements(this.driver, LoginPage.class);
		loginpage.sucessLogin();
		
	}
	
	@Test(priority=2)
	public void singlePdf() {
		DatasourcePage source = PageFactory.initElements(this.driver,DatasourcePage.class);
		source.SinglePDF();
		

	}

	
	
	
}
