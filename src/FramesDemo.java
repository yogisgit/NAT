import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		
		System.setProperty("webDriver.ChromeDriver", "/Users/yogi/Java/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		System.out.println(driver.findElement(By.id("draggable")).getText());
		
		//to drag and drop we need to use actions class
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, destination).build().perform();
		
		//switch back to default content
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Demos")).click();
		

	}

}
