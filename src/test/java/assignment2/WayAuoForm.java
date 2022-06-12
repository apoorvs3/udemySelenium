package assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WayAuoForm {
	public static void main(String[] args) {
		WebDriver driver =null;
		driver=InitiateMe.InitiateDriver(driver);
		
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Megha");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Meghalaya");
		WebElement countryDropDown = driver.findElement(By.cssSelector("select[name='country']"));
		Select sl = new Select(countryDropDown);
		sl.selectByValue("Mongolia");
		
	}
}
