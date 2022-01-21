package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePage {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/pages/frame.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.switchTo().frame(0); //Using Index
	WebElement click = driver.findElement(By.id("Click"));
	//Take the Screenshot of the product
	File source = click.getScreenshotAs(OutputType.FILE);
	File destination = new File("./images/SortByLowToHigh.png");
	FileUtils.copyFile(source, destination); 
	click.click();
	
	driver.switchTo().defaultContent();
	//Nested frame
	driver.switchTo().frame(1);
	driver.switchTo().frame("frame2"); //Using Id
	driver.findElement(By.id("Click1")).click();
	driver.switchTo().defaultContent();
	
	//Find the number of frames
	List<WebElement> tags = driver.findElements(By.tagName("iframe"));
	System.out.println("Total number of Frames visible in the main page : " +tags.size());
	
	driver.close();
	
	
}
}
