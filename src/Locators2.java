import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webDriver.Chrome.driver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Inks");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		String actual = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(actual, "You are successfully logged in.");
		String actual1 = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(actual1, "Hello Inks,");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}

}
