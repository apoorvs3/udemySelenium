package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenPrinting {
	public static void main(String[] args) throws IOException {
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		
		driver.get("https://www.way2automation.com/");
		WebElement above  = driver.findElement(By.xpath("//*[@id=\"menu-item-27578\"]/a/span[2]"));
		File aboveScreenShot = above.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(aboveScreenShot, new File(".//src/test/java/screenshot/above.png"));
		
	}
}
