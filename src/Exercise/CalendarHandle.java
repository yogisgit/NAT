package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandle {

	public static void main(String[] args) {
		
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.findElement(By.id("travel_date")).click();
		
		//July 13
		
		while(!driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']")).getText().contains("July")) {
			driver.findElement(By.cssSelector("div.datepicker-days th.next")).click();
		}
		
		int dateCount = driver.findElements(By.className("day")).size();
		
		for(int i=0; i<dateCount; i++) {
			String date = driver.findElements(By.className("day")).get(i).getText();
			
			if(date.equalsIgnoreCase("29")) {
				driver.findElements(By.className("day")).get(i).click();
			}
		}

	}

}
