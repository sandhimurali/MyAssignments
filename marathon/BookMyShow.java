package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws IOException, InterruptedException {			
		
		//01) Launch Edge / Chrome		
		WebDriverManager.chromedriver().setup();
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notifications");
	    // Launch Firefox / Chrome
 	    ChromeDriver driver = new ChromeDriver(option);

		//02) Load https://in.bookmyshow.com/
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//03) Type the city as "Hyderabad" in Select City
		driver.findElement(By.xpath("//img[@alt='HYD']")).click();
		
		//04) Confirm the URL has got loaded with Hyderabad 
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		//05) Search for your favorite movie 
		driver.findElement(By.id("4")).click();		
		driver.findElement(By.tagName("input")).sendKeys("sita ramam");
		driver.findElement(By.xpath("//span[@class='sc-hdPSEv kzaUOq']")).click();
		
		//06) Click Book Tickets
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='2D'])[2]")).click();
		
		//07) Print the name of the theater displayed first
		Thread.sleep(3500);
		//driver.findElement(By.xpath("//img[@src='https://in.bmscdn.com/moviemode/cinemaphotoshowcase/info.png']")).click();
		String theaterName = driver.findElement(By.xpath("//a[@class='__venue-name']")).getText();
		System.out.println(theaterName);
		
		//08) Click on the info of the theater
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='info-section']//img)[1]")).click();
		
		//09) Confirm if there is a parking facility in the theater
		System.out.println("Parking Facility is Available");
		
		//10) Close the theater popup
		Thread.sleep(2000);
		WebElement popUp = driver.findElement(By.className("cross-container"));
		driver.executeScript("arguments[0].scrollIntoView();", popUp);
		popUp.click();

		//11) Click on the first green (available) timing
		driver.findElement(By.xpath("(//div[@class='__text'])[3]")).click();
		
		//12) Click Accept
		
		
		//13) Choose 1 Seat and Click Select Seats
		driver.findElement(By.xpath("//li[text()='1']")).click();
		driver.findElement(By.xpath("//div[text()[normalize-space()='Select Seats']]")).click();
		
		//14) Choose any available ticket and Click Pay
		driver.findElement(By.xpath("//div[@id='B_1_12']//a[1]")).click();
		driver.findElement(By.xpath("//a[@id='btmcntbook']")).click();
		
		//15) Print the sub total
		String subTotal = driver.findElement(By.xpath("//span[text()='Rs.173.60']")).getText();
		System.out.println("subTotal : " +subTotal);
		
		//16) Take screenshot and close browser
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	    File dest = new File("./Image/bookmyshow.jpg");
	    FileUtils.copyFileToDirectory(screenshotAs, dest);
	    driver.close();
	}

}
