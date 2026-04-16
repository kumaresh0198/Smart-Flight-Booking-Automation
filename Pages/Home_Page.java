package Data_Driven_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Home_Page {
	
	
	WebDriver driver;
	
	public Home_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectCities(String dep, String des) {
        Select from = new Select(driver.findElement(By.name("fromPort")));
        from.selectByVisibleText(dep);

        Select to = new Select(driver.findElement(By.name("toPort")));
        to.selectByVisibleText(des);
    }

    public void clickFindFlights() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
