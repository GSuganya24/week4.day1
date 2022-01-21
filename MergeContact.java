package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {
		//Setup the driver
		WebDriverManager.chromedriver().setup();
		//Launch the Browser
		ChromeDriver driver = new ChromeDriver();
		//Load the url
		driver.get("http://leaftaps.com/opentaps/");
		//Maximise the browser
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("DemoSalesManager");
		
		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click Contacts Tab
				driver.findElement(By.linkText("Contacts")).click();
				
	    //Click Merge contact
				driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	    
		//Click on the widget from the From Contact
				driver.findElement(By.xpath("//input[@id = 'partyIdFrom']/following::a")).click();
			Thread.sleep(1000);
				
		//Move to the opened window
		Set<String> window1 = driver.getWindowHandles();
		List<String> load = new ArrayList<String>(window1);
		driver.switchTo().window(load.get(1)); //Move to the new Window
		//Find the first element and click
		driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(load.get(0));//Move to the parent window
		//Click on the widget from the To Contact
		driver.findElement(By.xpath("//input[@id = 'partyIdTo']/following::a")).click();
		Thread.sleep(1000);
		
		
		//Move to the opened window
		Set<String> window2 = driver.getWindowHandles();
		List<String> load1 = new ArrayList<String>(window2);
		driver.switchTo().window(load1.get(1));
		//Click on the second resulting element
		driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(load1.get(0)); //Move to the parent window
		//Click on the merge button
		driver.findElement(By.xpath("//a[text() = 'Merge']")).click();
		//Accept the alert
		driver.switchTo().alert().accept();
		//verify the Title
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Contact")) {
			System.out.println("Merge Successful");
		}else {
			System.out.println("Merge Unsuccessful");
		}
		driver.close();
		
	}
}
