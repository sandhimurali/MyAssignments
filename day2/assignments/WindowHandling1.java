package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		 //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		 //2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		 //3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		 //4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		 //5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		  	
		 //6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		 //7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		 //8. Click on First Resulting Contact
		Thread.sleep(3000);
		Set<String>windowHandles=driver.getWindowHandles();
		List<String>switchTowindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchTowindow.get(1));

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();		
		
		 //9. Click on Widget of To Contact
		Thread.sleep(1000);
		Set<String>windowHandles1=driver.getWindowHandles();
		List<String>switchTowindow1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(switchTowindow1.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		 //10. Click on Second Resulting Contact
		Set<String>windowHandles2=driver.getWindowHandles();
		List<String>switchTowindow2=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(switchTowindow2.get(1));

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		  
		 //11. Click on Merge button using Xpath Locator
		Set<String>windowHandles3=driver.getWindowHandles();
		List<String>switchTowindow3=new ArrayList<String>(windowHandles3);
		driver.switchTo().window(switchTowindow3.get(0));
		driver.findElement(By.className("buttonDangerous")).click();
		  
		 //12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		  
		 //13. Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
		
	}

}
