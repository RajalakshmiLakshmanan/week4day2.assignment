package week4day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSelectable {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElement(By.xpath("//li[contains(@class,'ui-widget-content ui-selectee')]"));
		WebElement item2 = driver.findElement(By.xpath("(//li[contains(@class,'ui-widget-content')])[2]"));
		WebElement item4 = driver.findElement(By.xpath("(//li[contains(@class,'ui-widget-content')])[4]"));
		WebElement item6 = driver.findElement(By.xpath("(//li[contains(@class,'ui-widget-content')])[6]"));
		
		Actions ss = new Actions(driver);
		ss.keyDown(Keys.CONTROL)
		  .click(item1)
          .click(item2)
          .click(item4)
          .click(item6)
          .keyUp(Keys.CONTROL)
          .perform();
		
	}

}
