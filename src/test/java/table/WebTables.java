package table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/sql/sql_select.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//table")));
		
		List<WebElement> rowNum = driver.findElements(By.xpath("//table//tbody//tr"));
		List<WebElement> colms = driver.findElements(By.xpath("//table//tbody//tr[1]//th"));
		
		System.out.println("Rows are "+ rowNum.size()+" columns are: "+colms.size());
		//1st rows is for headings
		
		for(int i=2; i<=rowNum.size(); i++) {
			for(int j=1; j<=colms.size(); j++) {
				
				System.out.print(driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td["+j+"]")).getText()+"\t");
			}
			System.out.println();
		}
		
	}
}
