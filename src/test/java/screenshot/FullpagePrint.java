package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.HasFullPageScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullpagePrint {
	public static void main(String[] args) throws IOException {
		FirefoxDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.way2automation.com/");

		if (driver instanceof FirefoxDriver) {
			driver.manage().window().maximize();
			File fullPage = driver.getFullPageScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(fullPage, new File("./src/test/java/screenshot/full.png"));
		}

	}
}
