package assignment1;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Way2auto {
	public static void main(String[] args) {
		WebDriver driver=InititateDriver.InitiateMe("chrome");
		
		driver.get("https://www.google.co.in/");
		Actions ac = new Actions(driver);
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("way2Automation");
		search.sendKeys(Keys.ENTER);
		
		//click on result for way2auto
		String result = driver.findElement(By.partialLinkText("Way2Automation")).getText();
		if(result.contains("Way2Automation")) {
			driver.findElement(By.partialLinkText("Way2Automation")).click();
		}
		
		
		//checking for all the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		
		//recording in a file
		LinkedList<String> store = new LinkedList<String>();
		int i=1;
		for(WebElement link: links) {
			if(link.getText().equals("")) {
				store.add("Link number "+ i+ " has no text");
//				System.out.println("Link number "+ i+ " has no text");
				i++;
				continue;
			}
//			System.out.println("Link number "+ i+ " is "+link.getText());
			store.add("Link number "+ i+ " is "+link.getText());
			i++;
		}
		try {
//			WriteInFile.writeInTxt(store);
			WriteInFile.WriteInExcel(store);
		} catch (Exception e) {
			System.out.println("bbb");
		}
		
		driver.quit();
	}
}
