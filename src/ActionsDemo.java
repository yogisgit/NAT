import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox")))
		//.click().keyDown(Keys.SHIFT).sendKeys("cars").build().perform();
		
		a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox")))
		.click().keyDown(Keys.SHIFT).sendKeys("c").keyUp(Keys.SHIFT).sendKeys("ars").build().perform();
		
		a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).contextClick().build().perform();
	}

}
