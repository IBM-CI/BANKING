package TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

public class Settingaccess2 extends Settingsaccess1 {

	//WebDriver d;
	@Test(alwaysRun=true,priority=16)

	public void sessionMember() throws InterruptedException
	{  



		//logout-admin(after session expires)


	//	d.findElement(By.xpath(".//*[@id='menu0']")).click();

	//	String ses3=d.findElement(By.xpath(".//*[@id='tdContents']/table/tbody/tr[1]/td/center/div")).getText();

	//	String ses2="Please login again to continue.";

	//	assertEquals(ses3,ses2);
		d.findElement(By.xpath(".//*[@id='menu0']/span[2]")).click();
		String Log= d.findElement(By.xpath(".//*[@id='tdContents']/table/tbody/tr[1]/td/center/div")).getText();
		System.out.println(Log);
		String b1="Please login again to continue.";
		assertEquals(Log, b1);


		if(Log.equals("Please login again to continue."))
		{
			System.out.println("successful time out");
		}

		System.out.println(" session is expired :admin");



		d.findElement(By.id("cyclosUsername")).sendKeys("admin");
		d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
	    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
	    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
	    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
	    d.findElement(By.xpath("//*[@type='submit']")).click();
	    
		
		d.findElement(By.xpath(".//*[@id='menu9']")).click();
		d.findElement(By.xpath(".//*[@id='submenu9.2']")).click();
		

}
}
