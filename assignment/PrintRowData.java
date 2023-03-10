package week4day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PrintRowData {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='render']//tbody/tr"));
		int size = findElements.size();
		System.out.println("Row size :" +size);
		Thread.sleep(2000);
		
		List<WebElement> findElements2 = driver.findElements(By.xpath("//div[@class='render']//tbody/tr[1]/td"));
		int size2 = findElements2.size();
		System.out.println("Column size:"+size2);
		
		for(int i=1;i<=size;i++) {
			for(int j=1;j<=size2;j++) {
				
				WebElement findElement = driver.findElement(By.xpath("//div[@class='render']//tbody/tr["+i+"]/td["+j+"]"));
				String text = findElement.getText();
				System.out.println(text);
			}
			
		}

}
}