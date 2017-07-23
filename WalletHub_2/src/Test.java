package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium Jars\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("samir.9898580540@gmail.com");
		//driver.findElement(By.xpath("/html/body/main/div/form/div[1]/input")).sendKeys("samir.9898580540@gmail.com");
		//driver.findElement(By.xpath("/html/body/main/div/form/div[2]/input")).sendKeys("Admin@123");
		
		driver.findElement(By.id("pass")).sendKeys("rrr@2012");
		driver.findElement(By.id("u_0_t")).click();
		//driver.findElement(By.xpath(".//*[@id='join-login']/form/div[5]/button[2]")).click();
		driver.close();
	}

}
