package unitTests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search {
	@Rule
	public ErrorCollector ec = new ErrorCollector();
	
	@Test
	public void searchForAValidProduct() {
		
		WebDriverManager.chromedriver().setup();

		// Code for Chrome Security Issue
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver;

		// Add 'options' as argument
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("http://tutorialsninja.com/demo/");
		
		String expectedTitle = "Your Store 1";  //Wrong
		String actualTitle = driver.getTitle();
		
		//try catch with Throwable allows the FAIL of expected vs actual to continue the test with a PASS
		//Error Collector will give a ERROR status
		try {
		Assert.assertEquals(expectedTitle, actualTitle);
		}catch(Throwable e) {
			System.out.println(e.getMessage());
			ec.addError(e);
		}
		
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']//button")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
		driver.quit();
	}
	
}
