package week4day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActions {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.switchTo().frame(0);
		WebElement dragBox = driver.findElement(By.xpath("//div[contains(@class,'ui-draggable-handle')]"));
        Actions dg = new Actions(driver);
        dg.dragAndDropBy(dragBox, 100, 75).perform();
        
        
	}
        
		

}
