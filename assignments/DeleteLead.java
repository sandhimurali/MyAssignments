package weeek2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//1	Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2 Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5	Click crm/sfa link
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();		
		
		//8	Click on Phone 
		driver.findElement(By.xpath("//span[text()='Phone']")).click();		
 
		//9	Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("9876543221");		
	
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//11	Capture lead ID of First Resulting lead
		Thread.sleep(1000);
		String name = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		System.out.println(name);
		
		//12	Click First Resulting lead
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//13	Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();  
		
		//14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();		

		//15	Enter captured lead ID
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Sandhiya");

		//16	Click find leads button
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();

		//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement disabled=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		System.out.println("No records to display in the Lead list " +disabled.isDisplayed());
		//18	Close the browser (Do not log out)
		Thread.sleep(3000);
		driver.close();		
	}

}
