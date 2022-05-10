package Miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageCookies {

	public static void main(String[] args) {
		
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//to delete session id cookie provide the name of the cookie
		driver.manage().deleteCookieNamed("SessionKey");
		
		driver.get("https://expired.badssl.com/");

	}

}
