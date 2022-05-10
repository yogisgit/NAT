package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//above
		//below
		//toLeftOf
		//toRightOf
		
		//above method syntax
		WebElement wb1 = driver.findElement(By.name("name"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(wb1)).getText());
		
		//below method
		WebElement wb2 = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(wb2)).click();
		
		//toLeftOf
		WebElement wb3 = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(wb3)).click();
		
		//toRightOf
		WebElement wb4 = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(wb4)).getText());
		
	}

}
