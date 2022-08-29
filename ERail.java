package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERail {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(1000);
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS", Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU", Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		Thread.sleep(1000);
		List<WebElement> rowcount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']/tr"));
		int rowsize = rowcount.size();
		System.out.println("Number of rows : " +rowsize);
		
		System.out.println("Train Names");
		 List<String> lsttrain=new ArrayList<String>();
		for(int i=1;i<=rowsize;i++) {
		String name = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']/tr["+i+"]/td[2]")).getText();
		System.out.println(name);
		Thread.sleep(2000);
		driver.close();
		lsttrain.add(name);
		}

		System.out.println(lsttrain);
	}

}
