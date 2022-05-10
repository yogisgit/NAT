import java.time.Duration;
import java.util.Set;
import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.xpath("//a[@target=\"_blank\"]")).click();
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		String email = driver.findElement(By.cssSelector("ul[class='clearfix'] li")).getText();
		String text = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/h2/span")).getText().split("&")[1].trim().split(" ")[0];
		System.out.println(text);
		driver.close();
		
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(email);
		driver.close();

	}

}
