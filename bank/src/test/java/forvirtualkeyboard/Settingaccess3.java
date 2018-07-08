package forvirtualkeyboard;

import org.testng.annotations.Test;
import TestNG.Settingaccess5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;


public class Settingaccess3 extends Settingaccess5{
	//WebDriver d;
  @Test(alwaysRun=true,priority=19)
  public void virtual() throws InterruptedException   {
	
	  Thread.sleep(500);
	  
			d.findElement(By.id("cyclosUsername")).sendKeys("admin");
			d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
		    
			d.findElement(By.xpath("//*[@type='submit']")).click();
			d.findElement(By.xpath(".//*[@id='menu9']")).click();
			d.findElement(By.xpath(".//*[@id='submenu9.2']")).click();
			d.findElement(By.id("modifyButton")).click();

			boolean s2= d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).isSelected();
			assertEquals(s2,true);
			System.out.println("virtual keyboard is enabled");
			d.findElement(By.xpath(".//*[@id='menu15']/span[2]")).click();
			Thread.sleep(1000);
			d.switchTo().alert().accept();
			Thread.sleep(1000);
			d.findElement(By.id("cyclosUsername")).sendKeys("admin");
			d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
		    
			d.findElement(By.xpath("//*[@type='submit']")).click();

  }

}
