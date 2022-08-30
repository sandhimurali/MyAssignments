package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovingDrag {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//2.Launch the url : https://www.leafground.com/drag.xhtml
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act=new Actions(driver);

		/*Draggable Columns  -Move the Column Name to Column Quanity
			         		 -Get the Toaster message to confirm it*/
		
		WebElement dragCol = driver.findElement(By.xpath("//span[text()='Name']"));		
		WebElement dragQual = driver.findElement(By.xpath("//span[text()='Quantity']"));
		act.dragAndDrop(dragCol, dragQual).perform();
		act.dragAndDrop(dragQual, dragCol).perform();
		Thread.sleep(1000);
		String toasterMsg = driver.findElement(By.xpath("//span[text()='Columns reordered']")).getText();
		System.out.println("Get the Toaster message : " +toasterMsg);
		
		//table[@role='grid'])[2]//tr[4]/td
		/*Draggable Rows  -Move the row 3 to row 4
			        	  -Get the Toaster message to confirm it*/
		Thread.sleep(3000);
		WebElement row3 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[4]/td[1]"));
		WebElement row4 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[5]/td[1]"));
		act.dragAndDrop(row4, row3).perform();
		String toasterMsg1 = driver.findElement(By.xpath("//span[text()='Row moved']")).getText();
		String toasterMsg2 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span/following-sibling::p")).getText();
		System.out.println("Get the Toaster message 1 : " +toasterMsg1  +(toasterMsg2));
		
	/*	Thread.sleep(2000);
		//String toasterMsg1 = driver.findElement(By.xpath("//span[text()='Row moved']")).getText();
		//div[@class='ui-growl-message']/span/following-sibling::p
		
		//Resize Image   -Resize the message and Verify it
		
		WebElement image = driver.findElement(By.xpath("//div[@class='ui-wrapper']//div"));
//		Point location = image.getLocation();
//		int x = location.getX();
//		int y = location.getY();
//		act.clickAndHold(image).dragAndDropBy(image, 200, 8).perform();
		Actions builder = new Actions(driver);
		
		
		int x = image.getLocation().getX();
		
		int y = image.getLocation().getY();
		
		System.out.println(x);
		System.out.println(y);
		
		builder.clickAndHold(image).moveByOffset(234,95).release().perform();
		Thread.sleep(2000);
		String msg = driver.findElement(By.xpath("//span[text()='Image resized']")).getText();
		System.out.println("Resize the message : " +msg);
		
		//Range Slider  -Give a range between 10 and 80 (use movebyOffset() for x values ,y should be 0  and use negative value for right move)
		WebElement range = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all')]"));	
		act.moveToElement(range).perform();
		Point location1 = range.getLocation();
		int x1 = location1.getX();
		int y1 = location1.getY();
		act.moveByOffset(10, 80).pause(300).moveByOffset(-15,0).perform();   */
	}

}
