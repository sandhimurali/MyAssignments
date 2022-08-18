package weeek2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();

		// Step 2: Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();

		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// Step 4: Maximise the window
		driver.manage().window().maximize();

		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.name("firstname")).sendKeys("sandhiya");
		
		// Step 8: Enter the last name
		driver.findElement(By.name("lastname")).sendKeys("M");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		
		// Step 10: Enter the password
		driver.findElement(By.id("password_step_input")).sendKeys("Mnbvcxz@1");
		
		// Step 11: Handle all the three drop downs
		WebElement Dob = driver.findElement(By.id("day"));
		Select day=new Select(Dob);
		day.selectByIndex(4);
		WebElement Dateofbirth = driver.findElement(By.id("month"));
		Select month=new Select(Dateofbirth);
		month.selectByIndex(10);
		WebElement Dob2 = driver.findElement(By.id("year"));
		Select year=new Select(Dob2);
		year.selectByValue("1988");
		// Step 12: Select the radio button "Female" 
		//  ( A normal click will do for this step) 
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
	}

}
