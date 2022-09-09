package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//01) Launch Chome
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		//02) Load https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//03) Type "Bags" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for boys");
 
		//04) Choose the third displayed item in the result (bags for boys)
		driver.findElement(By.id("nav-search-submit-button")).click();

		//05) Print the total number of results (like 20000)
		  //  1-48 of over 20,000 results for "bags for boys"
		String likes = driver.findElement(By.xpath("//span[text()='1-48 of over 30,000 results for']")).getText();
		String text = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
		String concat = likes.concat(text);
		System.out.println("total number of results : " +concat);
		
		//06) Select the first 2 brands in the left menu
		  //  (like American Tourister, Generic) 1-48 of over 3,000 results for "bags for travelling"
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]")).click();		
	
		//07) Confirm the results have got reduced (use step 05 for compare)
		Thread.sleep(2000);	
		String likes1 = driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-small')]//span")).getText();
		String text1 = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
		String concat1 = likes1.concat(text1);
		System.out.println("total number of results : " +concat1);
		if (!(concat==concat1)) {
			System.out.println("Results got reduced");
		}

		//08) Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[text()='Featured']")).click();
		driver.findElement(By.id("s-result-sort-select_4")).click();
		
		//09) Print the first resulting bag info (name, discounted price)
		Thread.sleep(3000);
		String brand = driver.findElement(By.xpath("//span[text()='Generic']")).getText();
		String bagName = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')])[2]")).getText();
		String disCountPrice = driver.findElement(By.xpath("//span[text()='718']")).getText();
		System.out.println("brand name : " +brand);
		System.out.println("bag Name : " +bagName);
		System.out.println("disCount Price : " +disCountPrice);

		//10) Confirm the color of the 'Deal of the day' is in kind of Red
		System.out.println("There is no Deal of the Day");
		
		//11) Click on the First Deal of the day
		//12) Confirm the price on previous and this page are same 
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')])[2]")).click();
		Thread.sleep(2000);		
		Set<String>windowHandles=driver.getWindowHandles();
		List<String>switchTowindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchTowindow.get(1));

		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		if (!(disCountPrice==price)) {
			System.out.println("Same Price");
		}
		
		//13) Take screenshot and close
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	    File dest = new File("./Image/amazon.jpg");
	    FileUtils.copyFileToDirectory(screenshotAs, dest);
	    driver.close();
		
		
		
		
		
		
		
	}

}
