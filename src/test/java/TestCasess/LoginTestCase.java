package TestCasess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestCase {
	WebDriver driver;
	String URL = "";

	@BeforeTest
	public void config() {
		driver = new ChromeDriver(); // Browser driver object

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

		driver.get("https://rahulshettyacademy.com/client/"); // redirect website
	}

	@Test(priority = 1)
	public void loginUserWithValidCred() throws InterruptedException {
		driver.findElement(By.id("userEmail")).sendKeys("Shahad3@mailinator.com");
		driver.findElement(By.id("userPassword")).sendKeys("123456Aa@");
		driver.findElement(By.id("login")).click();

		Thread.sleep(5000);
		URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "https://rahulshettyacademy.com/client/dashboard/dash", "URL is not as expected");
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
