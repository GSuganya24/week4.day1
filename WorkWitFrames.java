package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWitFrames {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.switchTo().frame("frame1");
	driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Selenium");
	driver.switchTo().frame("frame3");
	WebElement text = driver.findElement(By.id("a"));
	boolean isChecked = text.isSelected();
	if(!isChecked) {
		text.click();
	}else {
		System.out.println("Is already checked");
	}
	driver.switchTo().defaultContent();//Comes out of all the frames
	driver.switchTo().frame("frame2");
	WebElement dd = driver.findElement(By.id("animals"));
	Select dropdown = new Select(dd);
	dropdown.selectByValue("avatar");
	List<WebElement> options = dropdown.getOptions();
	for(WebElement a : options) {
		String x = a.getText();
		System.out.println(x);
	}
	driver.close();
	
}
}
