package week4day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDropable {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.switchTo().frame(0);
		WebElement dragBox = driver.findElement(By.xpath("//div[contains(@class,'ui-draggable-handle')]"));
		WebElement dropBox = driver.findElement(By.xpath("//div[contains(@class,'ui-droppable')]"));
		
		Actions db = new Actions(driver);
		db.dragAndDrop(dragBox, dropBox).perform();
	}

}
