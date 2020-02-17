package support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Environment {
	
	public static WebDriver createChrome()	 {
		
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Filipe\\Desktop\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
 
        driver.get("http://booking.com");
 
        return driver;
    }


}
