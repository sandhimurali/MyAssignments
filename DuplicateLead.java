package Week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sandhiya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("sandy");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("5");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sandhimurali@gmail.com");
		driver.findElement(By.className("smallSubmit")).click();		
		String title =driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Duplicate Lead")).click();		
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABC");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("sandhiya murali");
		driver.findElement(By.className("smallSubmit")).click();		
		String title1 =driver.getTitle();
		System.out.println(title1);
		driver.close();
	}

}
