package section17_frames_pdf_options;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionsUsage {
	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		Map<String, String> mobileEm = new HashMap<String, String>();
		mobileEm.put("deviceName", "iPhone X");
		
		
//		opt.addArguments("--headless");
		opt.setAcceptInsecureCerts(true);
//		opt.addArguments("disable-infobars");		--does not work
		opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));	//	--remove info bar
//		opt.addArguments("window-size=1920,720");
		opt.addArguments("incognito");
		
		opt.setExperimentalOption("mobileEmulation", mobileEm);
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(opt);
		
		driver.get("https://www.selenium.dev/documentation/");
		System.out.println(driver.getTitle());
	}
}
