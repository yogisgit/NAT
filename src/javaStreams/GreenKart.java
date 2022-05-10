package javaStreams;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKart {

	public static void main(String[] args) {
		
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all web elements into list
		List<WebElement> ls = driver.findElements(By.xpath("//tr/td[1]"));
		//capture text of all the web element into original list
		List<String> originalList = ls.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort the original list into sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		//compare original and sorted list
		Assert.assertTrue(sortedList.equals(originalList));
		
		//scan the name column with getText -> Beans -> print the price of the Beans
		
		List<String> price;
		do {
			
			//mention another list because if u use the existing list it contains only the data of first page
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeg(s)).collect(Collectors.toList());
			
			if(price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
			
		}while(price.size() < 1);
		
		System.out.println(price);
		
		//filter the web table using java stream
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> rice = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> check = rice.stream().filter(r->r.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(rice.size(), check.size());
	}
	
	private static String getPriceVeg(WebElement s) {
		String a = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return a;
	}

}
