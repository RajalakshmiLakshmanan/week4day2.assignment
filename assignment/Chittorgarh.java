package week4day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chittorgarh {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
        
		List<WebElement> findElements = driver.findElements(By.xpath("//table[contains(@class,'table-bordered table-striped')]/tbody/tr"));
		int size = findElements.size();
		System.out.println("Number of Nse Bulk deals: "+size);
		List<String> nseBulkDealsName =new ArrayList<String>();
		//int listSize = nseBulkDealsName.size();
		
		for(int i=1;i<=size;i++) {
			WebElement element = driver.findElement(By.xpath("//table[contains(@class,'table-bordered table-striped')]/tbody/tr["+i+"]/td[1]/a"));
			String text = element.getText();
			System.out.println(text);
			nseBulkDealsName.add(text);
			
		}
		
		int listSize = nseBulkDealsName.size();
		Set<String> setList =new HashSet<String>(nseBulkDealsName);
		int setSize = setList.size();
		
		if(listSize==setSize) {
			System.out.println("no duplicates are found");
		}else {
			
			System.out.println("duplicates are found");
		}
		
	}

}
