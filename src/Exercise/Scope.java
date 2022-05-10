package Exercise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//to get the count of all the links present in web page
		//links will be created using tag a (anchor) in html
		int links = driver.findElements(By.tagName("a")).size();
		System.out.println(links);
		
		//to find the count of links which is present only in footer
		//first limit the driver to access only footer
		//to limit the driver create subset of the driver
		WebElement subDriver = driver.findElement(By.cssSelector("div#gf-BIG"));
		int flinks = subDriver.findElements(By.tagName("a")).size();
		System.out.println(flinks);
		
		//To access only one column in subset driver
		WebElement miniDriver = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		int columnLinks = miniDriver.findElements(By.tagName("a")).size();
		System.out.println(columnLinks);
		
		//to click all the links present in miniDriver and check whether all are opening
		for(int i=1; i<miniDriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickOn = Keys.chord(Keys.COMMAND, Keys.ENTER);
			miniDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOn);
			
		}
		
		//to get the title of windows opened
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
