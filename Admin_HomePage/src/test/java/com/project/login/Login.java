package com.project.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;
	
	@Test(priority=2)
	public void loginDetail()
	{
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.id("cyclosPassword")).sendKeys("1234");
		driver.findElement(By.className("button")).click();
	}
	@Test(priority=1)
	public void browserLunch()
	{
		driver=new FirefoxDriver();
	    driver.get("http://localhost:8585/do/login");
	    driver.manage().window().maximize();
	    //driver.manage().window().fullscreen();
	}
	

}
