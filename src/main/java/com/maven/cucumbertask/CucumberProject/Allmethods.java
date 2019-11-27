package com.maven.cucumbertask.CucumberProject;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import okio.Options;

public class Allmethods {

	public static WebDriver driver;

	public static WebDriver getBrowser(String browserName) throws Exception {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\JavaClass\\CucumberProject\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\JavaClass\\CucumberProject\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "D:\\JavaClass\\CucumberProject\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Invalid browser name");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception("Issue is browser launch");
		}

	}

	public static void getUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception("URL Is not valid");
		}
	}

	public static void waitForElementVisiblity(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) throws Exception {
		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsEnabled(WebElement element) throws Exception {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();

		}
	}
	public static String getText(WebElement element) throws Exception {
		try {
			String text = element.getText();
			System.out.println(text);
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	public static String getAttributeValue(WebElement element, String values) throws Exception {
		try {
			String attribute = element.getAttribute(values);
			System.out.println(attribute);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public static void clickAlerts( String condition, String values) throws Throwable {
		Alert al = driver.switchTo().alert();
		if (condition.equalsIgnoreCase("accept")) {
			al.accept();
		}else if (condition.equalsIgnoreCase("dismiss")) {
			al.dismiss();
		}else if (condition.equalsIgnoreCase("sendkeys")) {
			al.sendKeys(values);
		}else {
			throw new Exception("Not a valid options");

		}

		
		
	}
	
	public static void clearValuesinElement(WebElement element) throws Exception {
		try {
			element.clear();
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void inputValestoElement(WebElement element, String values) throws Exception {
		try {
			waitForElementVisiblity(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				clearValuesinElement(element);
				element.sendKeys(values);

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void clickOntheElement(WebElement element) throws Exception {
		try {
			waitForElementVisiblity(element);
			element.click();
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();

		}
	}
	
	public static void moveTOtheElement(WebElement element) throws Exception {
		try {
			waitForElementVisiblity(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
			;
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();

		}

	}

	public static void driverNavigate(String options) throws Exception {
		if (options.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (options.equalsIgnoreCase("backward")) {
			driver.navigate().back();
		} else if (options.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		} else {
			throw new Exception("Not a valid option");
		}

	}

	public static void driverNavigateToUrl(String url) {
		driver.navigate().to(url);
	}

	public static String getPageTitle() throws Exception {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getCurrentURL() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void selectOptionInDD(WebElement element, String options, String values) throws Exception {
		waitForElementVisiblity(element);
		Select sc = new Select(element);
		if (options.equalsIgnoreCase("index")) {
			sc.selectByIndex(Integer.parseInt(values));
		} else if (options.equalsIgnoreCase("value")) {
			sc.selectByValue(values);
		} else if (options.equalsIgnoreCase("visibletext")) {
			sc.selectByVisibleText(values);
		} else {
			throw new Exception("Not a valid options");

		}

	}

	public static void scrollToElement(WebElement element) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollUsingCoordinates(int width, int height) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollToPageHeight(String options) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (options.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		} else if (options.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} else {
			throw new Exception("Not a valid option");
		}
	}

	public static void dragAndDroptoElement(WebElement source, WebElement target) throws Exception {
		waitForElementVisiblity(source);
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).build().perform();
	}

	public static void rightClickOntheElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();

	}

	public static void doubleClickOntheElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).build().perform();
	}

	public static void actionsforSendkeys(WebElement element, String values) {
		Actions ac = new Actions(driver);
		ac.sendKeys(element, values).build().perform();
	}

	public static void actionsForClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.click(element).build().perform();
	}

	public static void takeScreenShot(String filename) throws IOException {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			File des = new File("D:\\JavaClass\\CucumberProject\\Projectscreenshot" + filename + ".png");
			FileUtils.copyFile(temp, des);
		} catch (WebDriverException e) {

			e.printStackTrace();
		}

	}

	public static void switchToWindows(String pageTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String x : windowHandles) {
			driver.switchTo().window(x);
			String title = driver.getTitle();
			if (title.equals(pageTitle)) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Title is mismatched");
			}
		}

	}

	public static void switchToWindows(int index) throws Exception {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> li = new ArrayList<String>();
			li.addAll(windowHandles);
			String winID = li.get(index);
			driver.switchTo().window(winID);
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception();
		}

	}

}
