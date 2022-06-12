package section17_frames_pdf_options;

import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintPDF {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
//		Pdf myPdf = driver.print(new PrintOptions());
		Pdf myPdf = ((PrintsPage) driver).print(new PrintOptions());	//in case using webdriver
		
		
//		Files.write(Paths.get(".//src/test/java/section17_frames_pdf_options/sel.pdf"), OutputType.BYTES.convertFromBase64Png(myPdf.getContent()));
		
	}
}
