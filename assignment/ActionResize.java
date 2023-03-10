package week4day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionResize {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0);
		
		WebElement reSize = driver.findElement(By.xpath("(//div[@id='resizable']/div)[3]"));
		
		Actions re = new Actions(driver);
		//re.click(reSize).perform();
		Thread.sleep(3000);
		re.dragAndDropBy(reSize, 190, 200).perform();
		
        
	}

}
