package TestNG;

//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
//import java.util.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
import java.lang.Thread;

public class SettingsAlert1_Test extends LocalSettings1_Test {
	int i,j,x,k;
//WebDriver d;
	@Test(alwaysRun=true,priority=11)
	public void f21() throws InterruptedException   {

		d.findElement(By.id("submenu9.1")).click();
		d.findElement(By.id("modifyButton")).click();
		d.findElement(By.name("setting(givenVeryBadRefs)")).click();
	
		String m1="Alert settings";
		String m2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[1]/td[1]")).getText();
		assertEquals(m1,m2);

		
		//updated values verification

				d.findElement(By.name("setting(givenVeryBadRefs)")).clear(); 
				d.findElement(By.name("setting(givenVeryBadRefs)")).sendKeys("3");


				d.findElement(By.name("setting(receivedVeryBadRefs)")).clear();
				d.findElement(By.name("setting(receivedVeryBadRefs)")).sendKeys("3");

				d.findElement(By.name("setting(idleInvoiceExpiration).number")).clear();

				d.findElement(By.name("setting(idleInvoiceExpiration).number")).sendKeys("3");




				d.findElement(By.name("setting(amountDeniedInvoices)")).clear(); 
				d.findElement(By.name("setting(amountDeniedInvoices)")).sendKeys("3");



				d.findElement(By.name("setting(amountIncorrectLogin)")).clear();
				d.findElement(By.name("setting(amountIncorrectLogin)")).sendKeys("3");

				String s1=	  d.findElement(By.name("setting(givenVeryBadRefs)")).getAttribute("value");
				String s2 = d.findElement(By.name("setting(receivedVeryBadRefs)")).getAttribute("value");
				String s3	=  d.findElement(By.name("setting(idleInvoiceExpiration).number")).getAttribute("value");
				String s4	=  d.findElement(By.name("setting(idleInvoiceExpiration).field")).getAttribute("value");
				String s5	=  d.findElement(By.name("setting(amountDeniedInvoices)")).getAttribute("value");
				String s6	 = d.findElement(By.name("setting(amountIncorrectLogin)")).getAttribute("value");
				d.findElement(By.id("saveButton")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				d.switchTo().alert().accept();

				String s11=	  d.findElement(By.name("setting(givenVeryBadRefs)")).getAttribute("value");
				String s22 = d.findElement(By.name("setting(receivedVeryBadRefs)")).getAttribute("value");
				String s33	=  d.findElement(By.name("setting(idleInvoiceExpiration).number")).getAttribute("value");
				String s44	=  d.findElement(By.name("setting(idleInvoiceExpiration).field")).getAttribute("value");
				String s55	=  d.findElement(By.name("setting(amountDeniedInvoices)")).getAttribute("value");
				String s66	 = d.findElement(By.name("setting(amountIncorrectLogin)")).getAttribute("value");

				assertEquals(s1,s11);
				assertEquals(s2,s22);
				assertEquals(s3,s33);
				assertEquals(s4,s44);	
				assertEquals(s5,s55);
				assertEquals(s6,s66);
			
				d.findElement(By.id("modifyButton")).click();
		
		//all fields should be editable ---------

		System.out.println(d.findElement(By.name("setting(givenVeryBadRefs)")).isEnabled());
		System.out.println(d.findElement(By.name("setting(receivedVeryBadRefs)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(idleInvoiceExpiration).number")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(amountDeniedInvoices)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(amountIncorrectLogin)")).isEnabled());
		System.out.println(d.findElement(By.name("setting(idleInvoiceExpiration).field")).isEnabled());

		boolean b1=	d.findElement(By.name("setting(givenVeryBadRefs)")).isEnabled();
		assertEquals(b1, true);
		boolean b2	=d.findElement(By.name("setting(receivedVeryBadRefs)")).isEnabled(); 
		assertEquals(b2, true);
		boolean b3=	d.findElement(By.name("setting(idleInvoiceExpiration).number")).isEnabled(); 
		assertEquals(b3, true);
		boolean b4=	d.findElement(By.name("setting(amountDeniedInvoices)")).isEnabled();
		assertEquals(b4, true);
		boolean b5=	d.findElement(By.name("setting(amountIncorrectLogin)")).isEnabled(); 
		assertEquals(b5, true);
		boolean b6=	d.findElement(By.name("setting(idleInvoiceExpiration).field")).isEnabled(); 
		assertEquals(b6, true);


		Thread.sleep(1000);
		System.out.println("23456789876543234567890");

		//incorrect login attempts and blocking of user

		//valid value

		d.findElement(By.name("setting(amountIncorrectLogin)")).clear();
		d.findElement(By.name("setting(amountIncorrectLogin)")).sendKeys("3");
		String c1=d.findElement(By.name("setting(amountIncorrectLogin)")).getAttribute("value");
		int x=Integer.parseInt(c1);
		System.out.println(x);
		if(x<=10 && x>=0)
		{
			System.out.println("correct no of attempts");
		}
		else

			System.out.println("entered incorrect no of attempts");

		Thread.sleep(400);


		//invalid value

		d.findElement(By.name("setting(amountIncorrectLogin)")).clear();
		d.findElement(By.name("setting(amountIncorrectLogin)")).sendKeys("12");
		String c2=d.findElement(By.name("setting(amountIncorrectLogin)")).getAttribute("value");
		int x1=Integer.parseInt(c2);
		System.out.println(x1);
		if(x1<=10 && x1>=0)

			System.out.println("correct no of attempts");
		else
		{
			System.out.println("entered incorrect no of attempts");
			assertEquals(x1,"1-10");
		}

		
	}
	
	

	@Test( alwaysRun=true,priority=12)

	public void f22() throws InterruptedException{


	/*	//blocking of user
		
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
			
			d.findElement(By.xpath(".//*[@id='virtualKeyboard']/div[1]/input[2]")).click();
			d.findElement(By.xpath(".//*[@id='virtualKeyboard']/div[1]/input[3]")).click();
			d.findElement(By.xpath(".//*[@id='virtualKeyboard']/div[1]/input[4]")).click();
			d.findElement(By.xpath("//*[@type='submit']")).click();
			d.findElement(By.xpath("//*[@id='btn']")).click();	
			Thread.sleep(1000);
		}
		d.findElement(By.xpath(".//*[@id='virtualKeyboard']/div[1]/input[2]")).click();
		d.findElement(By.xpath(".//*[@id='virtualKeyboard']/div[1]/input[3]")).click();
		d.findElement(By.xpath(".//*[@id='virtualKeyboard']/div[1]/input[4]")).click();
		d.findElement(By.xpath("//*[@type='submit']")).click();
		String n1="Your login is now temporarily blocked";
		String n2=d.findElement(By.cssSelector("td.tdContentTable.innerBorder")).getText();

		d.findElement(By.xpath("//*[@id='btn']")).click();	
		assertEquals(n1,n2);
		System.out.println("Your login is now temporarily blocked");

	
	}
	*/
	}

}
