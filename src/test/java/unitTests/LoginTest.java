package unitTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	
	@Rule
	public ErrorCollector ec = new ErrorCollector();
	
	//This happens ONCE BEFORE ANY METHODS ARE RUN
	@BeforeClass
	public static void preRequisites() {
		System.out.println("This happens ONCE BEFORE ANY METHODS ARE RUN... prob to load files or a DB connection");
	}
	
	//This happens BEFORE EVERY METHOD
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		// Code for Chrome Security Issue
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// Add 'options' as argument
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
	}
	
	
	@Test
	public void loginWithValidCredentials() {
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		try {
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		}catch(Throwable e) {
			System.out.println(e.getMessage());
			ec.addError(e);
		}
	}
	
	@Test
	public void loginWithInvalidCredentials() {
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("amotooo@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		try {
		Assert.assertTrue(driver.findElement(By.
		xpath("//div[@id='account-login']/div[contains(text),'Warning: No match for E-Mail Address and/or Password.')]")).isDisplayed());
		}catch(Throwable e) {
			System.out.println(e.getMessage());
			ec.addError(e);
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void releaseResources() {
		System.out.println("Release All Resources");
	}
	
}
