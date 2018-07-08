package TestNG;

import org.testng.annotations.Test;

import forvirtualkeyboard.Settingaccess3;

import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;


public class Settingaccess6 extends Settingaccess3 {
	
@Test(alwaysRun=true,priority=20)

 public void blockingofuser() throws InterruptedException  {
	//blocking of user
	d.findElement(By.id("menu9")).click();
	d.findElement(By.id("submenu9.1")).click();
	d.findElement(By.id("modifyButton")).click();
	
	
			d.findElement(By.name("setting(amountIncorrectLogin)")).click();
			d.findElement(By.name("setting(amountIncorrectLogin)")).clear();
			d.findElement(By.name("setting(amountIncorrectLogin)")).sendKeys("3");
			String c3=d.findElement(By.name("setting(amountIncorrectLogin)")).getAttribute("value");
			System.out.println(c3);
			int x4=Integer.parseInt(c3);

			

			d.findElement(By.id("menu15")).click();
			Thread.sleep(1000);
			d.switchTo().alert().accept();
			Thread.sleep(1000);
			
			d.findElement(By.id("cyclosUsername")).sendKeys("admin");
			for(int k=1;k<x4;k++)
			{
				
				d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
			    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
			    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
			   
				d.findElement(By.xpath("//*[@type='submit']")).click();
				d.findElement(By.xpath("//*[@id='btn']")).click();	
				Thread.sleep(1000);
			}
			Thread.sleep(500);
			d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();

		    
			d.findElement(By.xpath("//*[@type='submit']")).click();
			
			System.out.println(d.findElement(By.cssSelector("td.tdContentTable.innerBorder")).getText());
			
			String expectedurl="http://localhost:8585/do/error";
			String actualurl=d.getCurrentUrl();
			assertEquals(actualurl, expectedurl);
			d.findElement(By.xpath("//*[@id='btn']")).click();	
		


	  
  }
}
