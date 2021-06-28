package SeleniumAutomation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleScripts {
	
	
	public void switchWindow(){
		
	//Code to launch a new window
	System.setProperty("webdriver.chrome.driver", "C://browserdrivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://demo.guru99.com/popup.php");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//*[contains(@href, 'popup.php')]")).click();
	
	String MainWindow=driver.getWindowHandle();
	
	Set<String> s1=driver.getWindowHandles();
	Iterator<String> i1=s1.iterator();
	
	while(i1.hasNext())
	{
		String ChildWindow= i1.next();
		if(!MainWindow.equalsIgnoreCase(ChildWindow)) 
		{
			driver.switchTo().window(ChildWindow);
			driver.findElement(By.name("emailid"))
			.sendKeys("testmail@gmail.com");
			
			driver.findElement(By.name("btnLogin")).click();
			
			driver.close();
			
		}
	}
	driver.switchTo().window(MainWindow);
	

	}
	public void handleAlertBox() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		
		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.findElement(By.name("submit")).submit();
		
		Alert alert = driver.switchTo().alert();
		
		String alertMessage = driver.switchTo().alert().getText();
		
		System.out.println(alertMessage);
		driver.switchTo().alert().dismiss();
		Thread.sleep(5000); 
		
		
		
	}
	
	
}
