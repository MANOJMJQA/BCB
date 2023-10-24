package BCBBaseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriverWait wait;
	public static WebDriver driver;
	WebElement element = null;

	public void inputtext(Object elementORlocator, String value, int one) {

		wait = new WebDriverWait(driver, (one));

		if (elementORlocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementORlocator));

		} else if (elementORlocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementORlocator));

		}
		element.sendKeys(value);

	}

	public void mouseActionClicks(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public void mouseAction(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public String getText(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		return element.getText();
	}

	public String getTextAttribute(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		return element.getAttribute("value");
	}

	public void invisible(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			wait.until(ExpectedConditions.invisibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated((By) elementOrLocator));
		}

	}

	public Boolean conditionChecking(Object elementOrLocator, int value) {
		Boolean text = false;
		wait = new WebDriverWait(driver, value);
		try {
			if (elementOrLocator instanceof WebElement) {
				element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
			} else if (elementOrLocator instanceof By) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
			}
			text = element.isEnabled();
		} catch (Exception e) {
			return text;
		}
		return text;
	}

	public Boolean invisibleConditionChecking(Object elementOrLocator, int value) {
		Boolean text = false;
		wait = new WebDriverWait(driver, value);
		try {
			if (elementOrLocator instanceof WebElement) {
				text = wait.until(ExpectedConditions.invisibilityOf((WebElement) elementOrLocator));
			} else if (elementOrLocator instanceof By) {
				text = wait.until(ExpectedConditions.invisibilityOfElementLocated((By) elementOrLocator));
			}
		} catch (Exception e) {
			return text;
		}
		return text;
	}

	public static String getPropertyValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream stream = new FileInputStream(
				System.getProperty("user.dir") + "\\Reusable Records\\PropertyFile");
		properties.load(stream);
		String value = (String) properties.get(key);
		return value;
	}

	public void clearField(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		element.clear();

	}

	public void clickButton(Object elementOrLocator, int value, String event) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		if (event.equals("Click")) {
			element.click();
		} else if (event.equals("JS Click")) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void SendkeysBy(By element, String value, int one) {
		wait = new WebDriverWait(driver, (one));
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated((element)));
		element2.sendKeys(value);

	}

	public void SendkeysBy1(By element, String value) {
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated((element)));
		element2.sendKeys(value);

	}

	public void Sendkeyelement(WebElement element, String value) {
		WebElement element2 = wait.until(ExpectedConditions.visibilityOf(element));
		element2.sendKeys(value);

	}

	public String gettingtext(By send, int one) {
		wait = new WebDriverWait(driver, (one));
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(send)).getText();
		System.out.println(text);

		return text;
	}

	public List<WebElement> listofwebelement(By element,int one) {
		wait = new WebDriverWait(driver, (one));
		List<WebElement> until = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		
        return until;
	}
	
	

	public void JSclick(By click, int one) {
		wait = new WebDriverWait(driver, (one));
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(click));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", until);

	}
	
	public void JSclick(WebElement click, int one) {
		wait = new WebDriverWait(driver, (one));
		WebElement until = wait.until(ExpectedConditions.visibilityOf(click));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", until);

	}

	public void normalclick(By locator, int one) {

		wait = new WebDriverWait(driver, (one));
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		until.click();

	}

	public void textinvisibility(By element, int one) {
		wait = new WebDriverWait(driver, (one));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

	}

	public boolean conditionCheck(int one, By checkco) {

		boolean text = false;
		wait = new WebDriverWait(driver, one);
		try {

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(checkco));
			text = element.isDisplayed();

		} catch (Exception e) {
			return text;

		}
		return text;

	}

	public void scrolldownElement(int one, By element) {

		wait = new WebDriverWait(driver, one);

		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(until);
		actions.perform();

	}

	public void Wait(int one, By element) {

		wait = new WebDriverWait(driver, one);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

	public static void attachmentFile(String location) throws AWTException {
		StringSelection selection = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public boolean trycatchBy(int one, By Welement) {
		boolean until;

		try {

			wait = new WebDriverWait(driver, one);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(Welement));
			until = element.isDisplayed();

		} catch (Exception e) {

			return until = false;
		}
		return until;

	}
	
	public boolean trycatchInvisible(int one,By Welement) {
		
		boolean until;
		
		try {
			wait = new WebDriverWait(driver, one);
			until = wait.until(ExpectedConditions.invisibilityOfElementLocated(Welement));
			
			
			
		} catch (Exception e) {
			
			return until= false;
			
			
		}
		return until;
		
		

	}

}
