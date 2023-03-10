package week4day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options  =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebElement men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		WebElement jackets = driver.findElement(By.xpath("(//a[text()='Jackets'])[1]"));
		
		
		Actions mh = new Actions(driver);
		mh.moveToElement(men).scrollToElement(jackets).click(jackets).perform();
        WebElement findElement = driver.findElement(By.xpath("//span[@class='title-count']"));
        String text = findElement.getText();
        System.out.println("Total no of Jackets: "+text);
        String totalCount = text.replaceAll("[^0-9]", "");
        System.out.println(totalCount);
        int count = Integer.parseInt(totalCount);
        System.out.println("count: "+count);
        
        WebElement findElement2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]"));
        String sum1 = findElement2.getText();
        System.out.println("No of regular Jackets:"+sum1);
        String categorySum1 = sum1.replaceAll("[^0-9]","");
        int intSum1 = Integer.parseInt(categorySum1);
        System.out.println(intSum1);
        
        WebElement findElement3 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]"));
        String sum2 = findElement3.getText();
        System.out.println("No of rain jackets: "+sum2);
        String categorySum2 = sum2.replaceAll("[^0-9]","");
        int intSum2 = Integer.parseInt(categorySum2);
        System.out.println(intSum2);
        
        int categorySum = intSum1 + intSum2;
        System.out.println(categorySum);
        
        if (count == categorySum) {
        	System.out.println("Is verified that count same as category sum");
        }else {
        	System.out.println("count is not matched with category sum");
        }
        
        Thread.sleep(3000);
        WebElement jacketCheckbox = driver.findElement(By.xpath("//input[@value='Jackets']"));
        Actions cc = new Actions(driver);
        cc.click(jacketCheckbox).perform();
        driver.findElement(By.xpath("//div[@class='brand-more']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
        WebElement dukeCheckbox = driver.findElement(By.xpath("//input[@value='Duke']"));
        Actions ch = new Actions(driver);
        ch.click(dukeCheckbox).perform();
        driver.findElement(By.xpath("(//span[contains(@class,'sprites-remove')])[1]")).click();
        
        Thread.sleep(3000);
        List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3"));
        for(WebElement brand:findElements) {
        	String text2 = brand.getText();
        	System.out.println(text2);
        }
        Thread.sleep(1000);	
        WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
        WebElement discount = driver.findElement(By.xpath("//label[text()='Better Discount']"));
        Actions mh1= new Actions(driver);
        mh1.moveToElement(sort).scrollToElement(discount).click(discount).perform();
        
        Thread.sleep(2000);
        WebElement findElement4 = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
        String text2 = findElement4.getText();
        System.out.println("price of first displayed product: "+text2);
        driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]")).click();
        
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> wHandle  = new ArrayList<String>(windowHandles);
        driver.switchTo().window(wHandle.get(1));
        System.out.println("title: "+driver.getTitle());
        
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snap/duke.png");
        FileUtils.copyFile(screenshotAs, dest);
        
        driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
        
        driver.quit();
         
        

	}

}
