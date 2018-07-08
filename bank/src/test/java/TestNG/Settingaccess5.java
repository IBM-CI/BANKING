package TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class Settingaccess5 extends Access4 {


	@Test(alwaysRun=true, priority=18)
	public void session2() {


		d.findElement(By.id("cyclosUsername")).sendKeys("saanvi");

		d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
		d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
		d.findElement(By.xpath("//*[@type='submit']")).click();



		//logout of member


		d.findElement(By.xpath(".//*[@id='menu6']")).click();
		d.switchTo().alert().accept();



	}
}
