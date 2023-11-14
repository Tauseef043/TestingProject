package TestCasess;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTestCase {
	WebDriver driver;
	
	Properties prop;
	FileInputStream fis;
	
	// 1- register valid email and valid pass
	// 2- register invalid email and pass
	// 3- valied email and invalid pass
	// 4- invalied emaild and valid pss
	// 5 try register empty fields
	
	
	
	//TestNG Anotations
//	@AfterTest()
//	@BeforeClass
//	@AferClass
	
	
	@BeforeTest
	public void config() throws IOException
	{
		 driver = new ChromeDriver(); // Browser driver object

		// created browser driver
		// google chrome or firefox or internet expored

//		
//		chrome=> webdriver.chrome.drive
//		firefox=> webdriver.gecko.drive
//		internet explorer=> explorer webdriver.IE.drive

		// setting up path for browser driver
		 
		 
		 
		 prop=new Properties();
			
			fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\inputData.propties");
			prop.load(fis);

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");

		driver.get(prop.getProperty("baseURL")); // redirect website
	}
	

	@Test(priority=1)
	public void RegisterUSerWIthValidCref() throws InterruptedException // any name based upon test case

	
	{
		
	

		driver.manage().window().maximize(); // full screen mode
//		driver.manage().window().minimize();

//		driver.close(); it will clos the opened window
		// click register button
		driver.findElement(By.xpath("//a[@class='text-reset']")).click();

		// type in first name field

		driver.findElement(By.id("firstName")).sendKeys(prop.getProperty("fName"));

		Thread.sleep(1000); // 1000=> 1 sec 10000=> 10 seconds , 5000=> 6 seconds

		// type in last name field
		driver.findElement(By.id("lastName")).sendKeys(prop.getProperty("lName"));
		Thread.sleep(1000);
		driver.findElement(By.id("userEmail")).sendKeys(prop.getProperty("Uemail"));
		Thread.sleep(1000);
		driver.findElement(By.id("userMobile")).sendKeys(prop.getProperty("phone"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//option[@value='3: Engineer']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value='Female']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("userPassword")).sendKeys(prop.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.id("confirmPassword")).sendKeys(prop.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login")).click();

		Thread.sleep(2000);

		WebElement successMSGText = driver
				.findElement(By.xpath("//h1[normalize-space()='Account Created Successfully']"));

		String sunccesMsg = "";

		sunccesMsg = successMSGText.getText().toString();

		System.out.println(sunccesMsg);

//		
//		In Selenium, Asserts are validations or checkpoints for an application.
//		Assertions state confidently that application behavior is working as expected.
//		Asserts in Selenium validate the automated test cases that help testers understand
//		if tests have passed or failed. Types of Assertions. Hard Assertions.

		// Verify either testcase is passed or failed

		Assert.assertEquals(successMSGText.getText().toString(), "Account Created Successfully",
				"required text is not matched");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		Thread.sleep(1000); // for delay

		String title = driver.getTitle().toString(); // to get current webpage Title
		String URl = driver.getCurrentUrl().toString(); // to get current webpage URL

		System.out.println(title);
		System.out.println(URl);

		Assert.assertEquals(title, "Let's Shop"); // to verify page title
		Assert.assertEquals(URl, "https://rahulshettyacademy.com/client/auth/login", "UrL is not same as expected"); // verify
																														// page
																														// URL

//		//one method
//		driver.findElement(By.id("userEmail")).clear();
//		driver.findElement(By.id("userEmail")).sendKeys("type text here");
//		
//		//second mehtod
//		WebElement emailLocator= driver.findElement(By.id("userEmail"));
//		emailLocator.clear();
//		emailLocator.sendKeys("TYPE TEXT HERE";)

	}
	@Test(priority=2)
	public void LoginUSerWIthEmptyCred()
	{
		driver.findElement(By.id("login")).click();
		
		
		String errorMsg=driver.findElement(By.xpath("//div[contains(text(),'*Email is required')]")).getText().toString();
		
		System.out.println(errorMsg);
		Assert.assertEquals(errorMsg, "*Email is required","email or password field must be empty");
		
	}
	@AfterTest
	public void closeWIndow()
	{
		driver.close(); //close widnows
	}
	
}
