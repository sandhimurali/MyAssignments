package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		//Step:1-Launch the url (https://www.redbus.in/)
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Step:2-Enter From -Madiwala Bangalore
		driver.findElement(By.id("src")).sendKeys("Madiwala Bangalore",Keys.ENTER );

		//Step:3-Enter To Koyambedu Chennai
		driver.findElement(By.id("dest")).sendKeys("Koyambedu Chennai",Keys.ENTER);
		
		//Step:4-Select the Date 30-September-2022
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//td[@class='next']")).click();
		//driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[7]/td[5]")).click();
		driver.findElement(By.xpath("//tr[@class='rb-monthHeader']")).click();
		driver.findElement(By.xpath("//td[text()='30']")).click();
		Thread.sleep(2000);
		driver.close();
/*		WebElement findElement = driver.findElement(By.xpath("//button[text()='Search Buses']"));
		Actions act=new Actions(driver);
		act.moveToElement(findElement).click().perform();
		//driver.executeScript("arguments[0].click();", findElement);

//		
		//Step:5-Print the Title of the page
		/*String title = driver.getTitle();
		System.out.println(title);
		*/
	}

}
