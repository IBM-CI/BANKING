package TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Access4 extends Settingaccess2 {
	
	
	
  @Test(alwaysRun=true, priority=17)
  public void func() throws InterruptedException {
	  
	  d.findElement(By.id("modifyButton")).click();

		String time= d.findElement(By.name("setting(memberTimeout).number")).getAttribute("value");
		int z1=Integer.parseInt(time);
		assertEquals(z1, 1);



		d.findElement(By.name("setting(memberTimeout).field")).click();
		WebElement number0=d.findElement(By.name("setting(memberTimeout).field"));	
		Select timefor0=new Select(number0);
		List<WebElement> formatdetails0=timefor0.getOptions();
		d.findElement(By.name("setting(memberTimeout).number")).click();
		formatdetails0.get(1).click();
		String timeAtt=formatdetails0.get(1).getText();
		assertEquals(timeAtt, "Minute(s)");
		System.out.println("member session logout time: "+z1);



		d.findElement(By.id("saveButton")).click();
		
		d.switchTo().alert().accept();
	  
	  //logout
		d.findElement(By.xpath(".//*[@id='menu15']")).click();
		Thread.sleep(500);
		d.switchTo().alert().accept();
		
		Thread.sleep(1000);
	  
	  
	//login-member
			d.findElement(By.id("cyclosUsername")).sendKeys("saanvi");
			d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
		    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
		    
			d.findElement(By.xpath("//*[@type='submit']")).click();



          

			if(timeAtt.equals("Minute(s)"))
			{
				Thread.sleep(1*60*1000);
			}
			else if(timeAtt.equals("Hour(s)"))
			{

				Thread.sleep(z1*3600*60*1000);

			}
			else if(timeAtt.equals("Seconds(s)"))
			{

				Thread.sleep(z1*1000);
			}
			else if(timeAtt.equals("Day(s)"))
			{

				Thread.sleep(z1*24*60*60*1000);
			}

			//logout of member when session expires

			d.findElement(By.xpath(".//*[@id='menu0']")).click();

			String ses=d.findElement(By.xpath(".//*[@id='tdContents']/table/tbody/tr[1]/td/center/div")).getText();

			String ses1="Please login again to continue.";

			assertEquals(ses,ses1);

			System.out.println(" session is expired :member");


		}
	  
	  
	
}