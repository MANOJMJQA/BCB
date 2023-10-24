package PageObjectModel;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

import BCBBaseclass.BaseClass;

public class EssentialUserPage extends BaseClass {

	public EssentialUserPage(WebDriver driver) {

		this.driver = driver;

	}

	By youtube = By.xpath("//li[@id='youtube_url']");
	By youtubeInputBox = By.xpath("//input[@id='youtubeUrl']");
	By checkbox = By.xpath("//div[@id='files-list-container_youtube']/div[1]/div[1]/span");
	By selectAllURL = By.xpath("//div[@id='select_youtube']/span[1]");
	By BulkDelete = By.xpath("//div[@id='select_youtube']/span[2]");
	By singleDelete = By.xpath("//div[@id='files-list-container_youtube']/div[1]/div[2]/span/span");
	By updateUrl = By.xpath("//button[@id='submitButton_youtube']");
	By refreshButton = By.xpath("//img[@id='iconYoutube']");
	By synctext = By.xpath("//span[@id='Synced-Inprogress']");
	By BotSelect = By.xpath("//div[@id='page']/section//div[2]/div/div[3]/div/div/div[1]/div");
	By AddUrl = By.xpath("//button[@id='submit-youtube']");
	By errorToast = By.xpath("//div[@id='toast-container']/div/div");

	// Video update

	By VideoClick = By.xpath("//li[@id='mp4']");
	By videoupload = By.xpath("//input[@id='upload-files_video']//parent::p");
	By Checkboxvideo = By.xpath("//div[@id='files-list-container_video']/div/div[1]/span[1]");
	By videoSelectAll = By.xpath("//div[@id='files-list-sec_video']/div[2]/span[1]");
	By deleteAllvideo = By.xpath("//div[@id='files-list-sec_video']/div[2]/span[2]");
	By singleDeleteVideo = By.xpath("//div[@id='files-list-container_video']/div/div[2]/span/span");
	By updateVideo = By.xpath("//button[@id='submitButton_video']");
	By syncinprogressvideotext = By.xpath("//div[@id='files-list-container_video']/div/div[2]/span");
	By Videorefresh = By.xpath("//img[@id='iconVideo']");
	By syncvideotext = By.xpath("//div[@id='toast-container']/div/div");
	By InclueText = By.xpath("//h4[contains(text(),'Included Video Files ')]");

	// Website Url Paths

	By WebsiteClick = By.xpath("//li[@id='website_url']");
	By WebsiteInput = By.xpath("//input[@id='website']");
	By AddWebsite = By.xpath("//button[@id='submit-website']");
	By UpdateWebsite = By.xpath("//button[@id='submitButton_website']");
	By listofcheckbox = By.xpath("//div[@id='files-list-container_website_url']/div/div[1]/span");
	By WebsiteSycninprogress = By.xpath("//div[@id='files-list-container_website_url']/div[1]/div[2]/span");
	By WebsiteRefresh = By.xpath("//img[@id='iconWebsite']");

	// selecting single Youtube URL
	public void singleYoutubeUr() throws InterruptedException {
		this.JSclick(BotSelect, 10);
		this.JSclick(youtube, 10);
		this.SendkeysBy(youtubeInputBox, "https://youtu.be/eFTSYBVtrhI?feature=shared", 10);
		this.JSclick(AddUrl, 10);
		//
		try {
			this.scrolldownElement(10, updateUrl);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);
//		this.mouseActionClicks(checkbox, 5);
		this.JSclick(checkbox, 10);

		this.JSclick(updateUrl, 10);
		// this.gettingtext(errorToast, 10);

//		if (this.conditionCheck(5, errorToast)) {
//			Boolean text = false;
//			do {
//				if (this.gettingtext(errorToast, 10).equals("Select URL to Sync")) {
//
//					this.mouseActionClicks(checkbox, 10);
//					this.JSclick(updateUrl, 10);
//					if (this.conditionCheck(5, errorToast)) {
//						if (this.gettingtext(errorToast, 10).equals("Select URL to Sync")) {
//							text = true;
//						}
//					}
//				}
//			} while (text);
//
//		}

		this.textinvisibility(synctext, 10);
		this.JSclick(refreshButton, 10);

	}

	boolean until;

	public void UpdateSingleVideo() throws InterruptedException, AWTException {
		this.JSclick(BotSelect, 10);
		this.JSclick(VideoClick, 10);

		try {
			this.scrolldownElement(10, InclueText);

		} catch (Exception e) {

		}

		Thread.sleep(5000);
		// this.SendkeysBy(videoupload, System.getProperty("user.dir") + "\\local
		// files\\thirsty-crow.mp4", 10);
		this.mouseActionClicks(videoupload, 10);
		Thread.sleep(3000);
		this.attachmentFile("C:\\Users\\manoj\\eclipse-workspace\\BCBFrame\\local files\\thirsty-crow.mp4");
		Thread.sleep(5000);
		try {
			this.scrolldownElement(10, InclueText);

		} catch (Exception e) {

		}
		this.JSclick(Checkboxvideo, 10);
		this.JSclick(updateVideo, 10);
		// this.gettingtext(syncvideotext, 10);
//		this.JSclick(Videorefresh, 10);

		do {

//			if (this.gettingtext(syncinprogressvideotext, 10).equals("Sync Inprogress")) {
			this.JSclick(Videorefresh, 10);

//			}

		} while (!this.trycatchInvisible(10, syncinprogressvideotext));

	}

	static Boolean check;
	static int j;

	// update10 website URL
	public void WebsiteURL() throws InterruptedException {
		this.JSclick(BotSelect, 10);
		this.JSclick(WebsiteClick, 10);
		this.SendkeysBy(WebsiteInput,
				"https://www.apple.com/in/?afid=p238%7Cs8Vs8GkTq-dc_mtid_187079nc38483_pcrid_677073186442_pgrid_112258962467_pntwk_g_pchan__pexid__&cid=aos-IN-kwgo-brand--slid---product-",
				10);
		this.JSclick(AddWebsite, 10);
		Thread.sleep(3000);

		

			int i = 0;

			List<WebElement> list = driver
					.findElements(By.xpath("//div[@id='files-list-container_website_url']/div/div/span/label"));
			System.out.println(list.size());
			for (WebElement webElement : list) {
				System.out.println(webElement);
				i++;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", webElement);

				if (i == 5) {
					break;

				}
		
	}
	}
	}

