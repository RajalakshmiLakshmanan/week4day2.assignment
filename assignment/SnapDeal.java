package week4day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//span[contains(text(),'Men')]
		WebElement menFashion = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		WebElement sportsShoe = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		Actions build = new Actions(driver);
		build.moveToElement(menFashion).click(sportsShoe).perform();
		
		WebElement shoesCount = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[1]"));
		System.out.println("total Men's Shoes available: "+shoesCount.getText());
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.className("sort-label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for(WebElement price:elements) {
			String text = price.getText();
			System.out.println("List of price :"+text);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']/span")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow ')]")).click();
		//driver.findElement(By.xpath("//label[@for='Size_s-7']/a")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='navFiltersPill']/a"));
		for(WebElement filters:findElements) {
			String text = filters.getText();
			System.out.println("filter applied: "+text);
		}
		WebElement picture = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		WebElement quickView = driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div"));
        Actions db=new Actions(driver);
        db.moveToElement(picture).click(quickView).perform();
        
        
        Thread.sleep(1000);
        WebElement price = driver.findElement(By.xpath("(//div[contains(@class,'product-price')]/span)[1]"));
        System.out.println("product price: "+price.getText());
        Thread.sleep(1000);
        WebElement discount = driver.findElement(By.xpath("(//div[contains(@class,'product-price')]/span)[2]"));
        System.out.println("discount applied:"+discount.getText());
        
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
        File destn=new File("./snap/shoe.png");
        FileUtils.copyFile(screenshotAs, destn);
        
        driver.close();
        
        
	}

}
