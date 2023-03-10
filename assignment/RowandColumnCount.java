package week4day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RowandColumnCount {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		List<WebElement> findElements = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
		int rSize = findElements.size();
		System.out.println("No of rows in table: "+rSize);
		
		List<WebElement> findElements2 = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr[2]/td"));
		int cSize = findElements2.size();
		System.out.println("No of Columns in table: "+cSize);
		
		
		

	}

}
