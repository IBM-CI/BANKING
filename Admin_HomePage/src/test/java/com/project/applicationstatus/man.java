/*package com.project.applicationstatus;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class man {
WebDriver driver;

	@Test
	public void testing1()
	{
		String InputComment="welcome to the section";
		
		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[2]/td[2]/input")).click();
		//driver.findElement(By.xpath("//*[@name='newGroupId' and @value='11']")).click();
		Select group=new Select(driver.findElement(By.name("newGroupId")));
		group.selectByValue("9");
		//driver.findElement(By.xpath("//*[@value='11']")).click();
		
		driver.findElement(By.xpath("//*[@id='comments']")).sendKeys("welcome to the section");
		//driver.findElement(By.cssSelector("//*[@name='tripType' and @value='oneway']")).click();
		
	
		String message=driver.findElement(By.id("comments")).getAttribute("value");
		System.out.println(message.length());
		
		if (message.length()>40){
			
		}else
		{
			String expectected_text="The member's group was changed";
			String actual_text= driver.switchTo().alert().getText();
			assertEquals(actual_text, expectected_text);
		}
			
	}
	
	@BeforeTest
	public void Login()
	{
		driver=new FirefoxDriver();
		driver.get("http://localhost:8585/do/login");		
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.id("cyclosPassword")).sendKeys("1234");
		driver.findElement(By.className("button")).click();
		driver.findElement(By.id("memberUsername")).sendKeys("samrr");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/