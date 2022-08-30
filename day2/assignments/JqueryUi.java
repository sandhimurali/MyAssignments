package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryUi {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//Load the url as "https://jqueryui.com/sortable/ "
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Actions act=new Actions(driver);

		//SwitchTo frame 
		driver.switchTo().frame(0);
		
		//use ActionsClass to move the element 4 to 6
		Thread.sleep(3000);
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[4]/span[1]"));
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']/li[5]/span[1]"));		
		WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[6]/span[1]"));
		act.dragAndDrop(item1, item3).perform();
		act.dragAndDrop(item3, item1).perform();
		act.dragAndDrop(item2, item1).perform();
		driver.close();
		

	}

}
