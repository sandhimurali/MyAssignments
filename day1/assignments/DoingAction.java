package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoingAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		//1. Launch the url: 
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//2. Menu Bar--->Do click on shipment and mousehover on Tracker and Do rightClick on Tracker
		WebElement ship = driver.findElement(By.xpath("//span[text()='Shipments']"));
		Actions act=new Actions(driver);
		act.contextClick(ship).perform();
        
		//3. Slide Menu---->Do click Orders and click Back 
		WebElement order = driver.findElement(By.xpath("(//span[text()='Orders'])[2]"));
		act.click(order).perform();
		Thread.sleep(1000);
		WebElement bck = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-w']"));
		act.click(bck).perform();
		Thread.sleep(2000);
		driver.close();

	}

}
