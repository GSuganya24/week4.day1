package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertLearning {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://www.leafground.com/pages/Alert.html");
	driver.manage().window().maximize();
	//Click button AlertBox
	driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	//Click button ConfirmBox
	driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	//Click the PromptAlert Button
	driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
	Thread.sleep(1000);
	Alert alert = driver.switchTo().alert();
	alert.sendKeys("Suganya");
	alert.accept();
	//Click LineBreaks button
	driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	//Click SweetAlert
	driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='OK']")).click();
}
}
