package week4day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options  =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> wHandle = new ArrayList<String>(handles);
		driver.switchTo().window(wHandle.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("Title: "+driver.getTitle());
		driver.switchTo().window(wHandle.get(0));
		driver.close();
			

	}

}
