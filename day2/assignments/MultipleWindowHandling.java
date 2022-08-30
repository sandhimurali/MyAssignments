package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		//Step :1 https://www.leafground.com/window.xhtml
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	    //Step :2    Click Open Multiple 
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Thread.sleep(1000);
		Set<String>windowHandles=driver.getWindowHandles();
		List<String>switchTowindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchTowindow.get(2));
	       
		//Step :3  Get the size of available Windows
		//Dimension size = driver.findElement(By.xpath("//body[@class='main-body ui-input-filled']")).getSize();
		Set<String> windowHandles1 = driver.getWindowHandles();
        int windSize = windowHandles1.size();
        System.out.println(windSize);
        Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(switchTowindow.get(1));
		driver.close();

		
		//Step :4 switch to last window 
		driver.switchTo().window(switchTowindow.get(0));

	    //Step :5 Get the Title of the Window
		String title = driver.getTitle();
		System.out.println(title);
	    
		//Step :6 Close all the windows except last window
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

}
