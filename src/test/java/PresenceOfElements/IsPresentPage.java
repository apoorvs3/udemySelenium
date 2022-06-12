package PresenceOfElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IsPresentPage {
    public static WebDriver driver;
    public IsPresentPage(WebDriver driver){
        this.driver = driver;
    }
    public static boolean isElementPresent(By by){
        int size_ = driver.findElements(by).size();
        return size_ != 0;
    }

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println((isElementPresent(By.xpath("//*[@id=\"js-link-box-en\"]/strongfffff"))));


        driver.quit();
    }
}
