package Data_Driven_Project;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Project {
	
	    WebDriver driver;
	    String url = "https://blazedemo.com/";
	    

	    @BeforeClass
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	    }

	    @DataProvider(name = "cities")
	    public Object[][] Listofdata(){ 
			return new Object[][] {
				{"Paris","London"},
				{"Portland","Cairo"},
				{"Boston","Rome"}
			};
		}
	    
	    @BeforeMethod
	    public void loadApp() {
	        driver.get(url);
	    }
	    
	    @Test(dataProvider ="cities" )
	    public void flight_booking(String dep, String des) {
	    	Home_Page home = new Home_Page(driver);
	    	Flight_Page flight = new Flight_Page(driver);
	    	Booking_Page booking = new Booking_Page(driver);
	    	
	    	home.selectCities(dep, des);
	    	home.clickFindFlights();
	    	
	    	flight.select_cheap_flight();
	    	booking.filling_details();
	    }
	    
	    @AfterMethod
	    public void screenshot() throws IOException {
	    	Booking_Page booking = new Booking_Page(driver);

	    	booking.screenshot();
	    }	   

	    @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	

}
