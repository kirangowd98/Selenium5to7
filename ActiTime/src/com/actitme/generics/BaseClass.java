package com.actitme.generics;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;

public class BaseClass {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public   WebDriver driver;
	public FileLib f=new FileLib();
	@BeforeTest
	public void openBrowser() throws IOException {
		String browser = f.getPropertyFileData("browser");
		if(browser.equals("chrome")) {
		driver= new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver= new FirefoxDriver();
				}

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@BeforeMethod
	public void login() throws IOException {
		
		driver.get(f.getPropertyFileData("url"));
		driver.findElement(By.id("username")).sendKeys(f.getPropertyFileData("username"));
		driver.findElement(By.name("pwd")).sendKeys(f.getPropertyFileData("password"));
		driver.findElement(By.xpath("//div[.='Login ']")).click();
	}
	
	@AfterMethod
public void logout() throws InterruptedException {
	Thread.sleep(3000);
	HomePage h=new HomePage(driver);
	h.clickOnLogout();
}
}
