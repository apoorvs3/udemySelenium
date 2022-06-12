package assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaptchaPlay {
	public static void main(String[] args) throws InterruptedException {
		for(int j=0; j<5; j++) {
		WebDriver driver = null;
		driver = InitiateMe.InitiateDriver(driver, "chrome");
		
			driver.get("https://timesofindia.indiatimes.com/poll.cms");
			driver.findElement(By.xpath("//input[@value='2']")).click();
			String captcha = driver.findElement(By.id("mathq2")).getText();
			String num = "";
			String sign = "";

			for (int i = 0; i < captcha.length(); i++) {
				if (!Character.isSpace(captcha.charAt(i))&&
						!Character.isDigit(captcha.charAt(i)) &&
						!Character.isLetter(captcha.charAt(i))) {
					if (captcha.charAt(i)=='+') {
						sign += "+";
					} else if (captcha.charAt(i)=='-') {
						sign += "-";
					}

				} else if (Character.isDigit(captcha.charAt(i))) {
					num += captcha.charAt(i) + " ";
				}
			}
			String[] numbers = num.split(" ");
			int num1 = Integer.parseInt(numbers[0]);
			int num2 = Integer.parseInt(numbers[1]);
			int result = 0;
			if (sign.equals("+")) {
				result = num1 + num2;
			} else if (sign.equals("-")) {
				result = num1 - num2;
			}

			System.out.println("Result is: " + result);
			driver.findElement(By.id("mathuserans2")).sendKeys(String.valueOf(result));
			driver.findElement(By.cssSelector("div[class='homesprite vot']")).click();
			Thread.sleep(3000);
			driver.quit();
		}
	
	}
}
