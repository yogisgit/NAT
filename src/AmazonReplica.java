import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonReplica {
	
	public static void main(String...args) throws InterruptedException {
		
		String[] items = {"Cucumber", "Brocolli", "Beetroot"};
		int j=0;
		System.setProperty("webDriver.Chrome.driver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size(); i++) {
			String[] product = products.get(i).getText().split("-");
			String productList = product[0].trim();
			
			//format it to get actual vegetable name
			//convert array into array list for easy search
			//check whether name you extracted is present in arrayList or not
			
			List itemsList = Arrays.asList(items);
			if(itemsList.contains(productList)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==items.length) {
					break;
				}
			}
		}
		
		driver.close();
	}
}
