package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomerservice {

	public static void main(String[] args) throws InterruptedException {

		//1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//2.Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//3.Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");

		//4. Enter the password as " Password#123 "
		driver.findElement(By.id("password")).sendKeys("Password#123");
		
		//5.click on the login button
		driver.findElement(By.id("Login")).click();

		//6.click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		
		
		//7.Switch to the next window using Windowhandles.
		Set<String> windowHandles=driver.getWindowHandles();
		List<String>switchTowindow=new ArrayList<String>(windowHandles);
		
		//8.click on the confirm button in the redirecting page
		Thread.sleep(3000);
		driver.switchTo().window(switchTowindow.get(1));
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();		
		
		//9.Get the title
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();

		
		//10.Get back to the parent window
		Set<String> windowHandles1=driver.getWindowHandles();
		List<String>switchTowindow1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(switchTowindow1.get(0));

		
		//11.close the browser
		driver.close();

	}

}
