package weeek2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
    public static void main(String[] args) {		
    	WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//1	Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("sandhiya");
		
		//9	Click Find leads button
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		
		//10 Click on first resulting lead
		driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewLead?partyId=20196'])[3]")).click();
		
		/** 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out) */

	}

}
