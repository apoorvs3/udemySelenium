package section17_frames_pdf_options;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabsWindows {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hello selenium 4");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.gmail.com");
		
		System.out.println(driver.getWindowHandles().size());
		
		Set<String> wins = driver.getWindowHandles();
		Iterator<String> iterator = wins.iterator();
		
		List<String> winIndex = new ArrayList<String>();
		while(iterator.hasNext()) {
			winIndex.add(iterator.next());	//adding from set to list
		}
		driver.switchTo().window(winIndex.get(0));
		System.out.println("First win: "+driver.getTitle());
		
		driver.switchTo().window(winIndex.get(1));
		System.out.println("Second win: "+driver.getTitle());
		
		driver.switchTo().window(winIndex.get(2));
		System.out.println("Third win: "+driver.getTitle());
		
		
		driver.quit();
	}
}
