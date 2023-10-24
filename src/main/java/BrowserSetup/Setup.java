package BrowserSetup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import BCBBaseclass.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup extends BaseClass {

	public static WebDriver startBrowser() throws IOException {
		WebDriver driver = null;

		if (getPropertyValue("BrowserName").equals("Chrome")) {

			WebDriverManager.chromedriver().clearDriverCache();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "incognito",
					"window-size=1920,1080");

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		}

		if (getPropertyValue("BrowserName").equals("Edge")) {

			WebDriverManager.edgedriver().clearDriverCache();
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		}

		if (getPropertyValue("BrowserName").equals("Firefox")) {
			WebDriverManager.firefoxdriver().clearDriverCache();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "-private");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		}
		return driver;

	}

}
