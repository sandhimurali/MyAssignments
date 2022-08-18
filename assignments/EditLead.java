package weeek2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
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
		
		//8	Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Sandhiya");
		
		//9	Click Find leads button
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		
		//10 Click on first resulting lead
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//11 Verify title of the page
		String name=driver.getTitle();
		System.out.println(name);
		
		//12 Click Edit
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra']/a)[3]")).click();
		
		// 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();	
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("ABC");	
		
		// 14 Click Update
		driver.findElement(By.name("submitButton")).click();	

		// 15 Confirm the changed name appears   
		String findElement = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(findElement);
		Thread.sleep(3000);
		
		/* 16 Close the browser (Do not log out) */
		driver.close();
	}

}
