import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		System.setProperty("webDriver.Chrome.driver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");  //this has in-build synchronization wait
		driver.navigate().to("https://rahulshettyacademy.com");  //this will just navigate to the page
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.close();
	}

}
