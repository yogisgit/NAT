package Exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ScrollDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//java script executor object creation
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//scrolling window
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(5000);
		//scrolling table element
		//selecting js dom and providing css selector as query selector in js
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		//sum 4 column of the table
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		
		int sum=0;
		
		for(int i=0; i<values.size(); i++) {
			
			//String a = values.get(i).getText();
			//System.out.println(a);
			sum = sum + Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println(sum);
		int total = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);

	}

}
