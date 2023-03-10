package week4day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement LorelParis = driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]"));
		Actions build = new Actions(driver);
		build.moveToElement(brands).click(LorelParis).perform();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		WebElement findElement = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]"));
		System.out.println(findElement.getText());
		WebElement findElement1 = driver.findElement(By.xpath("(//span[@class='filter-value'])[2]"));
		System.out.println(findElement1.getText());
		
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> whandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(whandle.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		WebElement findElement2 = driver.findElement(By.className("css-1jczs19"));
		System.out.println(findElement2.getText());
		
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		WebElement findElement3 = driver.findElement(By.xpath("(//div[contains(@class,'footer-layout')]//span)[1]"));
		String text = findElement3.getText();
		System.out.println("grand total of product:" +text);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		WebElement element = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']"));
		String price=element.getText();
		System.out.println("price details" +price);
		
		if(text.equals(price))
		{
			System.out.println("Its confirmed that grand total same as final price");
		}
		driver.quit();
				
	}

}
