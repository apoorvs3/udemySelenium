package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaits {
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(10))
				  .pollingEvery(Duration.ofSeconds(2))
				  .withMessage("Timed out after 30 seconds")
				  .ignoring(ElementNotInteractableException.class);
		
		driver.get("https://mail.google.com");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("apoorvlifeok@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']"))).sendKeys("haliulla");
		
	}
}

/*
 * ownership and learn and be curious, tdg
 * 
 * 
 * 
 * */
