package TestCasess;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestCase2 {
	WebDriver driver;
	String URL = "";
	Properties prop;
	FileInputStream  fis;

	@BeforeTest
	public void config() throws IOException {
		
		prop=new Properties();
		
		fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\inputData.propties");
		
		
		prop.load(fis);
		
//		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		
		
		driver = new ChromeDriver(); // Browser driver object

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

		
		
		//Production Beta local/staging
		driver.get(prop.getProperty("baseURL")); // redirect website
	}

	@Test(priority = 1)
	public void loginUserWithValidCred() throws InterruptedException {
		driver.findElement(By.id("userEmail")).sendKeys(prop.getProperty("userEmail"));
		driver.findElement(By.id("userPassword")).sendKeys(prop.getProperty("userPass"));
		driver.findElement(By.id("login")).click();

		Thread.sleep(5000);
		URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, prop.getProperty("HomePageURL"), "URL is not as expected");
	}

	@Test(priority = 2)
	public void loginWIthInvalidCred() {

	}

	@Test(priority = 3)
	public void loginWIthEmptyCred() {

	}

	@Test(priority = 4)
	public void loginWIthValidEMailAndInvalidPASSS() {

	}

	@Test(priority = 5)
	public void forgotPassTest() {
		// click on forgot pass button
		// page will open
		// get title and URL of the page
		// verify it is correct or not
	}

}
