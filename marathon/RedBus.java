package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {

		//01) Launch Firefox / Chrome
	/*	WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();       */
		WebDriverManager.chromedriver().setup();
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notifications");
	    // Launch Firefox / Chrome
 	    ChromeDriver driver = new ChromeDriver(option);

 	    //02) Load https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//03) Type "Chennai" in the FROM text box
	    driver.findElement(By.id("src")).clear();
	    driver.findElement(By.id("src")).sendKeys("Chennai");
	    driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		//driver.findElement(By.id("src")).sendKeys("Chennai" ,Keys.ENTER);
		
		//04) Type "Bangalore" in the TO text box
	    driver.findElement(By.id("dest")).clear();
	    driver.findElement(By.id("dest")).sendKeys("Bangalore");
	    driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		//driver.findElement(By.id("dest")).sendKeys("Bangalore", Keys.ENTER);
		
		//05) Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//label[@for='onward_cal']")).click();
		driver.findElement(By.xpath("//td[text()='8']")).click();
		
		//06) Click Search Buses
		driver.findElement(By.id("search_btn")).click();
		
		//07) Print the number of buses shown as results (ex:104 Buses found)
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
		Thread.sleep(2000);
		String busesFound = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of Buses : " +busesFound);
		
		//08) Choose SLEEPER in the left menu 
		WebElement sleeper = driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[1]"));
		driver.executeScript("arguments[0].scrollIntoView();", sleeper);
		sleeper.click();
		
		//09) Print the name of the second resulting bus 
		String secBusName = driver.findElement(By.xpath("(//div[contains(@class,'column-two p-right-10')]//div[1])[2]")).getText();
	    System.out.println("second resulting bus name : " +secBusName);
	    
		//10) Click the VIEW SEATS of that bus
	    driver.findElement(By.xpath("(//div[contains(@class,'button view-seats')])[2]")).click();
	    
		//11) Take screenshot and close browser
	    File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	    File dest = new File("./Image/shot.jpg");
	    FileUtils.copyFileToDirectory(screenshotAs, dest);
	    driver.close();
}

}
