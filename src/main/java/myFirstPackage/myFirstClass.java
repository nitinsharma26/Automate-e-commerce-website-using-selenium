package myFirstPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class myFirstClass {

 public static void take_screenshot() {
		try {
	        Thread.sleep(300);
	        Robot r = new Robot();

	        // It saves screenshot to desired path
	        String path = "E://Shot.jpg";

	        // Used to get ScreenSize and capture image
	        Rectangle capture = 
	        new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	        BufferedImage Image = r.createScreenCapture(capture);
	        ImageIO.write(Image, "jpg", new File(path));
	        System.out.println("Screenshot saved");
	    }
	    catch (Exception ex) {
	        System.out.println(ex);
	    } 
 }

    public static void main(String[] args) throws InterruptedException {
    	//Add your ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nitin Sharma\\Desktop\\testfolder\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/?ref=hackernoon.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1600)");

        driver.findElement(By.cssSelector("img[alt='Breathe-Easy Tank']")).click();
        js.executeScript("window.scrollBy(0,350)");

        driver.findElement(By.id("option-label-size-143-item-167")).click();
        driver.findElement(By.id("option-label-color-93-item-57")).click();

        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("2");
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(6000);
        js.executeScript("window.scrollBy(0,-350)","");
        Thread.sleep(3000);
        driver.findElement(By.className("minicart-wrapper")).click();    
        Thread.sleep(4000);
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        Thread.sleep(6000);

        driver.findElement(By.xpath("//div[@class='control _with-tooltip']//input[@id='customer-email']")).sendKeys("nitinvbps@gmail.com");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Nitin");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[2]/div[1]/input[1]")).sendKeys("Sharma");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[3]/div[1]/input[1]")).sendKeys("Capgemini");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("South Delhi, Delhi");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[4]/div[1]/input[1]")).sendKeys("New Delhi");

        Select reg = new Select(driver.findElement(By.xpath("//select[@name='region_id']")));
        reg.selectByVisibleText("Arizona");

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[7]/div[1]/input[1]")).sendKeys("1100480-214543");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[9]/div[1]/input[1]")).sendKeys("3453674735");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='ko_unique_1']")).click();
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("input[name='billing-address-same-as-shipping']")).click();
        driver.findElement(By.xpath("//span[text()='Place Order']")).click();  
        Thread.sleep(3000);
        take_screenshot();
    }
}

