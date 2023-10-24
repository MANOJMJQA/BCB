package PageObjectModel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import BCBBaseclass.BaseClass;

public class DatasourcePage extends BaseClass {

	WebDriver driver;

	public DatasourcePage(WebDriver driver) throws IOException {

	this.driver =driver;
	
	}
	By loginClick = By.xpath("//header[@id='masthead']//div/div/div/div[3]/div/span[1]/a/button");
	By Email = By.xpath("//input[@id='email']");
	By Password = By.xpath("//input[@id='password']");
	By Login = By.xpath("//button[@id='loginsubmit']");
    By BotSelect = By.xpath("//div[@id='page']/section//div[2]/div/div[3]/div/div/div[1]/div");
	By knowledgeBase = By.xpath("//a[contains(text(),'Knowledge Base')]");
	By uploadFiles = By.xpath("//input[@id='upload-files']");
	By singlePDF = By.xpath("//div[@id='files-list-container']/div");
	By checkbox = By.xpath("//div[@id='files-list-container']/div/div[1]/span[1]");
	By updatePdf = By.xpath("//button[@id='submitButton-pdf']");

	
	//Check Character count and upload website url for free user
	
	
	
	
	
	
	public void SinglePDF() {
		
		this.JSclick(BotSelect,10);
		this.gettingtext(knowledgeBase,10);
		this.SendkeysBy(uploadFiles,System.getProperty("user.dir")
				+ "\\local files\\software test.pdf",10 );
		this.JSclick(checkbox,10);
		this.JSclick(loginClick,10);
		

	}
	
	
	
}

     