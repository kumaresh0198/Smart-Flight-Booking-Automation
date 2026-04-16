package Data_Driven_Project;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Booking_Page {
	
	WebDriver driver;

    public Booking_Page(WebDriver driver) {
        this.driver = driver;
    }
    
    public void filling_details() {
    	
    	driver.findElement(By.id("inputName")).sendKeys("kumar");
	    driver.findElement(By.id("address")).sendKeys("chennai");
	    driver.findElement(By.id("city")).sendKeys("chennai");
	    driver.findElement(By.id("state")).sendKeys("tamilnadu");
	    driver.findElement(By.id("zipCode")).sendKeys("600100");
	    driver.findElement(By.id("creditCardNumber")).sendKeys("1234567890123456");
	    
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    }
    
    public void screenshot() throws IOException {
    	String path ="C:\\Users\\kumut\\eclipse-workspace\\Testng\\screenshot\\src";
    	
    	TakesScreenshot srcshot = (TakesScreenshot) driver;
    	Random rnd = new Random(); 
		int no = rnd.nextInt();
		String path_1 = path + no + ".png";
		File src = srcshot.getScreenshotAs(OutputType.FILE);
		File dst = new File(path_1);
		FileUtils.copyFile(src, dst);
		
    }

}
