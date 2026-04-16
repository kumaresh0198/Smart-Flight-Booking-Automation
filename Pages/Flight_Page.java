package Data_Driven_Project;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Flight_Page {
	
	WebDriver driver;

    public Flight_Page(WebDriver driver) {
        this.driver = driver;
    }
    
    public void select_cheap_flight() {
    	
    	List<WebElement> prices = driver.findElements(By.xpath("//td[6]"));
	    List<WebElement> submit = driver.findElements(By.xpath("//table//input[@type='submit']"));
        // creating a new list of double
	    List<Double> priceList = new ArrayList<>();
        // iterating each value and adding to new list
	    for (WebElement i : prices) {
	        String price_text = i.getText().replace("$", "");
	        double price = Double.parseDouble(price_text);
	        priceList.add(price);
	    }
        // finding the minimum price and its index position
	    double min_price = priceList.get(0);
	    int min_index = 0;

	    for (int i = 0; i < priceList.size(); i++) {
	        if (priceList.get(i) < min_price) {
	            min_price = priceList.get(i);
	            min_index = i;
	        }
	    }
	    submit.get(min_index).click();

    }

}
