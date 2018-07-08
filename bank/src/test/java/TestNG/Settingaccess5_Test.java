package TestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class Settingaccess5_Test extends Testaccess4_Test {


	@Test(alwaysRun=true, priority=18)
	public void session2() throws InterruptedException {


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
	
	
		  @Test(alwaysRun=true,priority=19)
		  public void virtual() throws InterruptedException   {
			
			  Thread.sleep(1000);
			  
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


		

	

