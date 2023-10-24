package PageObjectModel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BCBBaseclass.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) throws IOException {

		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
		String APP_URL = null;
		if (APP_URL == null) {
			APP_URL = getPropertyValue("BetaURL");
		}
		driver.get(APP_URL);

	}

	By loginClick = By.xpath("//header[@id='masthead']//div/div/div/div[3]/div/span[1]/a/button");
	By Email = By.xpath("//input[@id='email']");
	By Password = By.xpath("//input[@id='password']");
	By Login = By.xpath("//button[@id='loginsubmit']");
	By InvalidCreademail = By.xpath("//p[contains(text(),'Please enter a valid email address.')]");
	By InvalidCreadPass = By.xpath("//p[contains(text(),'Please Enter valid Password.')]");
	By Newregistration = By.xpath("//*[@id=\"page\"]/section/div[1]/div/div/div/div/form/div[1]/p");
	By sucesstoast = By.xpath("//h1[contains(text(),'My Chatbots')]");

	public void emptyValidation() {

		this.JSclick(loginClick,10);
		this.SendkeysBy(Email, "",10);
		this.SendkeysBy(Password, "",10);
		this.JSclick(Login,10);
		this.gettingtext(InvalidCreadPass,10);
		this.gettingtext(InvalidCreademail,10);

	}

	public void invalidcreadvalidationmail() {
		this.JSclick(loginClick,10);
		this.JSclick(Email,10);
		this.SendkeysBy(Password, "Password@123",10);
		this.JSclick(Login,10);
		this.gettingtext(InvalidCreademail,10);
	}

	public void InvalidCreadpass() {
		this.JSclick(loginClick,10);
		this.SendkeysBy(Email, "manivel@zaigoinfotech.com",10);
		this.JSclick(Login,10);
		this.gettingtext(InvalidCreadPass,10);

	}

	public void Newemailregistration() {
		
		this.JSclick(loginClick,10);
		this.SendkeysBy(Email, "ManojMJ192@gmail.com",10);
		this.SendkeysBy(Password, "password@123",10);
		this.JSclick(Login,10);
		this.gettingtext(Newregistration,10);

	}
	
	public void sucessLogin() {
		
		this.JSclick(loginClick,10);
		this.SendkeysBy(Email, "Manivel@zaigoinfotech.com",10);
		this.SendkeysBy(Password, "Password@123",10);
		this.JSclick(Login,10);
		this.gettingtext(sucesstoast,10);

	}
}
