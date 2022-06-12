package section17_frames_pdf_options;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Co_ordinates {
	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://accounts.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement img = driver.findElement(By.xpath("//*[@id=\"logo\"]/div"));
		
		Rectangle rect = img.getRect();
		
		System.out.println("Height: "+ rect.getHeight());
		System.out.println("Width: "+ rect.getWidth());
		System.out.println("x codnt: "+ rect.getX());
		System.out.println("y codnt: "+ rect.getY());
		
	}
}
