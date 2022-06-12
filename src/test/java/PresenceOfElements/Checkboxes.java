package PresenceOfElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Checkboxes {
    static IsPresentPage pg ;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
//        driver.findElement(By.xpath("//table/tbody/tr/td/div[4]/input[1]")).click();
//        driver.findElement(By.xpath("//table/tbody/tr/td/div[4]/input[2]")).click();
//        driver.findElement(By.xpath("//table/tbody/tr/td/div[4]/input[3]"));
//        driver.findElement(By.xpath("//table/tbody/tr/td/div[4]/input[4]"));

        //better
//        for (int i = 1; i <= 4; i++) {
//            driver.findElement(By.xpath("//table/tbody/tr/td/div[4]/input[" + i + "]")).click();
//        }
        //much better
//        int i=1;
//        pg= new IsPresentPage(driver);
//
//        while(IsPresentPage.isElementPresent(By.xpath("//table/tbody/tr/td/div[4]/input[" + i + "]"))){
//            driver.findElement(By.xpath("//table/tbody/tr/td/div[4]/input[" + i + "]")).click();
//            i++;
//        }
//        System.out.println("Total checkboxes are "+ (i-1));
//        driver.quit();


        //best
        WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
        List<WebElement> checkboxes = block.findElements(By.name("sports"));
        for(WebElement checkbox: checkboxes){
            checkbox.click();
        }
        System.out.println("Total checkboxes are: "+ checkboxes.size());
    }
}
