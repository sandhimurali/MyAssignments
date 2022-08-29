package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlighTicket {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		//1. Load https://www.irctc.co.in/
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		//2. Click on OK button in the dialog  
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		//3. Click on FLIGHTS link            
		driver.findElement(By.linkText("FLIGHTS")).click();			
		
		//4. Go to the Flights tab
		
		//5. Print title of the child window and close the window
		Set<String> windowHandles = driver.getWindowHandles();
        /*int size = windowHandles.size();
        System.out.println(size);
        
        for(String wh:windowHandles) {
          System.out.println(wh);                
        }*/
    //    convert set to list
        List<String> switchTOWindow=new ArrayList<String>(windowHandles);
        //switch to the required child window
        driver.switchTo().window(switchTOWindow.get(1));
        String title = driver.getTitle();    
        System.out.println(title);
        driver.close();
		//6. close all windows
        driver.quit();
	}

}
