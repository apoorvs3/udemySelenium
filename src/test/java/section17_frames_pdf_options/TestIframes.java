package section17_frames_pdf_options;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIframes {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//not found bcoz inside iframe
		//driver.findElement(By.xpath("//html//body//h1"));
		
		//first frame
		driver.switchTo().frame("iframeResult");
		System.out.println(driver.findElement(By.xpath("//html//body//h2")).getText());
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//frame inside frame - since it can be multiple choose 1,2,3...
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//html//body//h1")).getText());
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//switch back to first parent
		driver.switchTo().parentFrame();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		
		driver.quit();
	}
}
