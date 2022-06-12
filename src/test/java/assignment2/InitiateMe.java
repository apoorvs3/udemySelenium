package assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitiateMe {
	static WebDriver driver;
	public static WebDriver InitiateDriver(WebDriver driver) {
		if (driver==null) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
	
		return driver;
	}
}
