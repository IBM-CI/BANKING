package TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;


public class Settingsaccess1 extends SettingsAlert1 {
	int i,j;

	@Test(alwaysRun=true,priority=13)
	public void enabled() throws InterruptedException {
		
		Thread.sleep(1000);
		
		
		
		d.findElement(By.xpath(".//*[@id='submenu9.2']")).click();
		
		d.findElement(By.id("modifyButton")).click();


		System.out.println(d.findElement(By.name("setting(virtualKeyboard)")).isEnabled());



		System.out.println(d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).isEnabled()); 

		System.out.println(d.findElement(By.name("setting(numericPassword)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(allowMultipleLogins)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(allowOperatorLogin)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(adminTimeout).number")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(adminTimeout).field")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(memberTimeout).number")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(memberTimeout).field")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(poswebTimeout).number")).isEnabled());
		System.out.println(d.findElement(By.name("setting(poswebTimeout).field")).isEnabled());  
		System.out.println(d.findElement(By.name("setting(administrationWhitelist)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(usernameGeneration)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(usernameLength).min")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(usernameLength).max")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(usernameRegex)")).isEnabled());
		System.out.println(d.findElement(By.name("setting(transactionPasswordChars)")).isEnabled()); 

		boolean a1=	d.findElement(By.name("setting(virtualKeyboard)")).isEnabled();
		assertEquals(a1, true);


		boolean a2	=d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).isEnabled(); 
		assertEquals(a2, true);

		boolean a3=	d.findElement(By.name("setting(numericPassword)")).isEnabled(); 
		assertEquals(a3, true);
		boolean a4=	d.findElement(By.name("setting(allowMultipleLogins)")).isEnabled();
		assertEquals(a4, true);
		boolean a5=	d.findElement(By.name("setting(allowOperatorLogin)")).isEnabled(); 
		assertEquals(a5, true);
		boolean a6=d.findElement(By.name("setting(adminTimeout).number")).isEnabled(); 
		assertEquals(a6, true);
		boolean a7=	d.findElement(By.name("setting(adminTimeout).field")).isEnabled(); 
		assertEquals(a7, true);
		boolean a8=	d.findElement(By.name("setting(memberTimeout).number")).isEnabled(); 
		assertEquals(a8, true);
		boolean a9=	d.findElement(By.name("setting(memberTimeout).field")).isEnabled(); 
		assertEquals(a9, true);
		boolean a10=d.findElement(By.name("setting(poswebTimeout).number")).isEnabled();
		assertEquals(a10, true);
		boolean a11=d.findElement(By.name("setting(poswebTimeout).field")).isEnabled();  
		assertEquals(a11, true);
		boolean a12=d.findElement(By.name("setting(administrationWhitelist)")).isEnabled(); 
		assertEquals(a12, true);
		boolean a13=d.findElement(By.name("setting(usernameGeneration)")).isEnabled(); 
		assertEquals(a13, true);
		boolean a14=d.findElement(By.name("setting(usernameLength).min")).isEnabled(); 
		assertEquals(a14, true);
		boolean a15=d.findElement(By.name("setting(usernameLength).max")).isEnabled(); 
		assertEquals(a15, true);
		boolean a16=d.findElement(By.name("setting(usernameRegex)")).isEnabled();
		assertEquals(a16, true);
		boolean a17=d.findElement(By.name("setting(transactionPasswordChars)")).isEnabled(); 
		assertEquals(a17, true);





	} 


	@Test(alwaysRun=true,priority=14)
	public void submittab()
	{

	/*	d.findElement(By.name("setting(virtualKeyboard)")).click();
		d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).click();
		d.findElement(By.name("setting(numericPassword)")).click();
		d.findElement(By.name("setting(allowMultipleLogins)")).click();


//clicking second time
		
		d.findElement(By.name("setting(virtualKeyboard)")).click();
		Actions t=new Actions(d);
		t.sendKeys(Keys.TAB).build().perform();
		boolean b1=	d.findElement(By.name("setting(virtualKeyboard)")).isSelected();

		d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).click();
		Actions t1=new Actions(d);
		t1.sendKeys(Keys.TAB).build().perform();
		boolean b2=d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).isSelected();

		d.findElement(By.name("setting(numericPassword)")).click();
		Actions t2=new Actions(d);
		t2.sendKeys(Keys.TAB).build().perform();
		boolean b3 =d.findElement(By.name("setting(numericPassword)")).isSelected();

		d.findElement(By.name("setting(allowMultipleLogins)")).click();
		Actions t3=new Actions(d);
		t3.sendKeys(Keys.TAB).build().perform();
		boolean b4=d.findElement(By.name("setting(allowMultipleLogins)")).isSelected();



		Actions t4=new Actions(d);
		t4.sendKeys(Keys.TAB).build().perform();
		boolean b5=d.findElement(By.name("setting(allowOperatorLogin)")).isSelected();

*/
	/*	//text box
		d.findElement(By.name("setting(adminTimeout).number")).clear();
		d.findElement(By.name("setting(adminTimeout).number")).sendKeys("1");
		String s1=d.findElement(By.name("setting(adminTimeout).number")).getAttribute("value");
		int x1=Integer.parseInt(s1);



		d.findElement(By.name("setting(adminTimeout).field")).click();
		WebElement number6=d.findElement(By.name("setting(adminTimeout).field"));	
		Select timefor=new Select(number6);
		List<WebElement> formatdetails=timefor.getOptions();
		d.findElement(By.name("setting(adminTimeout).field")).click();
		formatdetails.get(0).click();
		String s22=formatdetails.get(0).getText();





		d.findElement(By.name("setting(memberTimeout).number")).clear();
		d.findElement(By.name("setting(memberTimeout).number")).sendKeys("1");
		String s2=d.findElement(By.name("setting(memberTimeout).number")).getAttribute("value");
		int x2=Integer.parseInt(s2);

		d.findElement(By.name("setting(memberTimeout).field")).click();
		WebElement number7=d.findElement(By.name("setting(memberTimeout).field"));	
		Select timefor1=new Select(number7);
		List<WebElement> formatdetails1=timefor1.getOptions();
		d.findElement(By.name("setting(memberTimeout).number")).click();
		formatdetails1.get(0).click();
		String s21=formatdetails1.get(0).getText();



		d.findElement(By.name("setting(poswebTimeout).number")).clear();
		d.findElement(By.name("setting(poswebTimeout).number")).sendKeys("1");
		Actions t7=new Actions(d);
		t7.sendKeys(Keys.TAB).build().perform();
		String s3=d.findElement(By.name("setting(poswebTimeout).number")).getAttribute("value");
		int x3=Integer.parseInt(s3);

		d.findElement(By.name("setting(poswebTimeout).field")).click();
		WebElement number44=d.findElement(By.name("setting(memberTimeout).field"));	
		Select time9=new Select(number44);
		List<WebElement> fortdetails89=time9.getOptions();
		d.findElement(By.name("setting(poswebTimeout).number")).click();
		fortdetails89.get(0).click();
		String s991=fortdetails89.get(0).getText();




		d.findElement(By.name("setting(administrationWhitelist)")).clear();
		d.findElement(By.name("setting(administrationWhitelist)")).sendKeys("#Any host");
		Actions t8=new Actions(d);
		t8.sendKeys(Keys.TAB).build().perform();
		String s4=d.findElement(By.name("setting(administrationWhitelist)")).getAttribute("value");


		d.findElement(By.name("setting(usernameGeneration)")).click();


		d.findElement(By.name("setting(usernameLength).min")).clear();
		d.findElement(By.name("setting(usernameLength).min")).sendKeys("5");
		Actions t9=new Actions(d);
		t9.sendKeys(Keys.TAB).build().perform();
		String s5=d.findElement(By.name("setting(usernameLength).min")).getAttribute("value");
		int x5=Integer.parseInt(s5);



		d.findElement(By.name("setting(usernameLength).max")).clear();
		d.findElement(By.name("setting(usernameLength).max")).sendKeys("10");
		Actions t10=new Actions(d);
		t10.sendKeys(Keys.TAB).build().perform();
		String s6=d.findElement(By.name("setting(usernameLength).max")).getAttribute("value");
		int x6=Integer.parseInt(s6);


		d.findElement(By.name("setting(usernameRegex)")).clear();
		d.findElement(By.name("setting(usernameRegex)")).sendKeys("hey");
		Actions t11=new Actions(d);
		t11.sendKeys(Keys.TAB).build().perform();
		String s7=d.findElement(By.name("setting(usernameRegex)")).getAttribute("value");


		d.findElement(By.name("setting(transactionPasswordChars)")).clear();
		d.findElement(By.name("setting(transactionPasswordChars)")).sendKeys("hii");
		Actions t12=new Actions(d);
		t12.sendKeys(Keys.TAB).build().perform();
		String s8=d.findElement(By.name("setting(transactionPasswordChars)")).getAttribute("value");


		d.findElement(By.id("saveButton")).click();
		d.switchTo().alert().accept();


/*
		boolean b11=	d.findElement(By .name("setting(virtualKeyboard)")).isSelected();

		assertEquals(b1, b11);
		boolean b22=d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).isSelected();
		assertEquals(b2, b22);

		boolean b33 =d.findElement(By.name("setting(numericPassword)")).isSelected();
		assertEquals(b3, b33);


		boolean b44=d.findElement(By.name("setting(allowMultipleLogins)")).isSelected();
		assertEquals(b4, b44);



		boolean b55=d.findElement(By.name("setting(allowOperatorLogin)")).isSelected();
		assertEquals(b5, b55);

*/
/*
		String s11=d.findElement(By.name("setting(adminTimeout).number")).getAttribute("value");
		int y1=Integer.parseInt(s11);
		assertEquals(x1, y1);

		d.findElement(By.name("setting(adminTimeout).field")).click();
		WebElement num1=d.findElement(By.name("setting(adminTimeout).field"));	
		Select time=new Select(num1);
		List<WebElement> timedetails=time.getOptions();
		d.findElement(By.name("setting(adminTimeout).field")).click();
		formatdetails.get(0).click();
		String s111=timedetails.get(0).getText();
		assertEquals(s111,s22);

		String s23=d.findElement(By.name("setting(memberTimeout).number")).getAttribute("value");
		int y2=Integer.parseInt(s23);
		assertEquals(y2, x2);




		d.findElement(By.name("setting(memberTimeout).field")).click();
		WebElement number10=d.findElement(By.name("setting(memberTimeout).field"));	
		Select time1=new Select(number10);
		List<WebElement> fortdetails1=time1.getOptions();
		d.findElement(By.name("setting(memberTimeout).number")).click();
		fortdetails1.get(0).click();
		String s222=fortdetails1.get(0).getText();
		assertEquals(s222,s21);


		String s33=d.findElement(By.name("setting(poswebTimeout).number")).getAttribute("value");
		int y8=Integer.parseInt(s33);
		assertEquals(x3, y8);



		d.findElement(By.name("setting(poswebTimeout).field")).click();
		WebElement number11=d.findElement(By.name("setting(memberTimeout).field"));	
		Select time3=new Select(number11);
		List<WebElement> fortdetails11=time3.getOptions();
		d.findElement(By.name("setting(poswebTimeout).number")).click();
		fortdetails11.get(0).click();
		String s99=fortdetails1.get(0).getText();
		assertEquals(s99,s991);




		String s44=d.findElement(By.name("setting(administrationWhitelist)")).getAttribute("value");
		assertEquals(s4, s44);


		String s55=d.findElement(By.name("setting(usernameLength).min")).getAttribute("value");
		int y5=Integer.parseInt(s55);
		assertEquals(x5, y5);

		String s66=d.findElement(By.name("setting(usernameLength).max")).getAttribute("value");
		int y6=Integer.parseInt(s66);
		assertEquals(y6, x6);

		String s77=d.findElement(By.name("setting(usernameRegex)")).getAttribute("value");
		assertEquals(s7, s77);


		String s88=d.findElement(By.name("setting(transactionPasswordChars)")).getAttribute("value");
		assertEquals(s8, s88);
		System.out.println("values are updated successfully");


		
*/
	/*	
		d.findElement(By.name("setting(virtualKeyboard)")).click();
		d.findElement(By.name("setting(virtualKeyboard)")).click();
		boolean b1=	d.findElement(By.name("setting(virtualKeyboard)")).isSelected();

		d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).click();
		boolean b2=d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).isSelected();
		d.findElement(By.name("setting(numericPassword)")).click();
		
		d.findElement(By.name("setting(numericPassword)")).click();
		boolean b3 =d.findElement(By.name("setting(numericPassword)")).isSelected();
		d.findElement(By.name("setting(allowMultipleLogins)")).click();
		d.findElement(By.name("setting(allowMultipleLogins)")).click();
		boolean b4=d.findElement(By.name("setting(allowMultipleLogins)")).isSelected();


		d.findElement(By.name("setting(allowOperatorLogin)")).click();
		d.findElement(By.name("setting(allowOperatorLogin)")).click();
		boolean b5=d.findElement(By.name("setting(allowOperatorLogin)")).isSelected();
		*/

		//text box
		d.findElement(By.name("setting(adminTimeout).number")).clear();
		d.findElement(By.name("setting(adminTimeout).number")).sendKeys("1");
		String s1=d.findElement(By.name("setting(adminTimeout).number")).getAttribute("value");


		d.findElement(By.name("setting(adminTimeout).field")).click();


		d.findElement(By.name("setting(memberTimeout).number")).clear();
		d.findElement(By.name("setting(memberTimeout).number")).sendKeys("1");
		String s2=d.findElement(By.name("setting(memberTimeout).number")).getAttribute("value");



		d.findElement(By.name("setting(memberTimeout).field")).click();


		d.findElement(By.name("setting(poswebTimeout).number")).clear();
		d.findElement(By.name("setting(poswebTimeout).number")).sendKeys("1");
		String s3=d.findElement(By.name("setting(poswebTimeout).number")).getAttribute("value");



		d.findElement(By.name("setting(poswebTimeout).field")).click();


		d.findElement(By.name("setting(administrationWhitelist)")).clear();
		d.findElement(By.name("setting(administrationWhitelist)")).sendKeys("#Any host");
		String s4=d.findElement(By.name("setting(administrationWhitelist)")).getAttribute("value");


		d.findElement(By.name("setting(usernameGeneration)")).click();


		d.findElement(By.name("setting(usernameLength).min")).clear();
		d.findElement(By.name("setting(usernameLength).min")).sendKeys("4");
		String s5=d.findElement(By.name("setting(usernameLength).min")).getAttribute("value");



		d.findElement(By.name("setting(usernameLength).max")).clear();
		d.findElement(By.name("setting(usernameLength).max")).sendKeys("12");
		String s6=d.findElement(By.name("setting(usernameLength).max")).getAttribute("value");


		d.findElement(By.name("setting(usernameRegex)")).clear();
		d.findElement(By.name("setting(usernameRegex)")).sendKeys("hello");
		String s7=d.findElement(By.name("setting(usernameRegex)")).getAttribute("value");


		d.findElement(By.name("setting(transactionPasswordChars)")).clear();
		d.findElement(By.name("setting(transactionPasswordChars)")).sendKeys("ABCDEFGHIJ");
		String s8=d.findElement(By.name("setting(transactionPasswordChars)")).getAttribute("value");


		d.findElement(By.id("saveButton")).click();
		d.switchTo().alert().accept();

/*
		boolean b11=	d.findElement(By.name("setting(virtualKeyboard)")).isSelected();
		assertEquals(b1, b11);
		boolean b22=d.findElement(By.name("setting(virtualKeyboardTransactionPassword)")).isSelected();
		assertEquals(b2, b22);

		boolean b33 =d.findElement(By.name("setting(numericPassword)")).isSelected();
		assertEquals(b3, b33);

		boolean b44=d.findElement(By.name("setting(allowMultipleLogins)")).isSelected();
		assertEquals(b4, b44);


		boolean b55=d.findElement(By.name("setting(allowOperatorLogin)")).isSelected();
		assertEquals(b5, b55);

*/

		String s11=d.findElement(By.name("setting(adminTimeout).number")).getAttribute("value");
		assertEquals(s1, s11);

		String s22=d.findElement(By.name("setting(memberTimeout).number")).getAttribute("value");
		assertEquals(s2, s22);


		String s33=d.findElement(By.name("setting(poswebTimeout).number")).getAttribute("value");
		assertEquals(s3, s33);


		String s44=d.findElement(By.name("setting(administrationWhitelist)")).getAttribute("value");
		assertEquals(s4, s44);


		String s55=d.findElement(By.name("setting(usernameLength).min")).getAttribute("value");
		assertEquals(s5, s55);

		String s66=d.findElement(By.name("setting(usernameLength).max")).getAttribute("value");
		assertEquals(s6, s66);

		String s77=d.findElement(By.name("setting(usernameRegex)")).getAttribute("value");
		assertEquals(s7, s77);


		String s88=d.findElement(By.name("setting(transactionPasswordChars)")).getAttribute("value");
		assertEquals(s8, s88);
		System.out.println("submit is working");
	

	}


	@Test(alwaysRun=true,priority=15)

	public void sessionAdmin() throws InterruptedException
	{  

		d.findElement(By.id("modifyButton")).click();

		String time= d.findElement(By.name("setting(adminTimeout).number")).getAttribute("value");
		int z2=Integer.parseInt(time);
		assertEquals(z2, 1);

		System.out.println("admin session logout time: "+z2);


		d.findElement(By.name("setting(adminTimeout).field")).click();
		WebElement nu=d.findElement(By.name("setting(adminTimeout).field"));	
		Select timefor=new Select(nu);
		List<WebElement> formatdetails23=timefor.getOptions();
		d.findElement(By.name("setting(adminTimeout).field")).click();
		formatdetails23.get(1).click();
		String timeAtt=formatdetails23.get(1).getText();


		assertEquals(timeAtt, "Minute(s)");
		
		d.findElement(By.id("saveButton")).click();
		Thread.sleep(500);
		d.switchTo().alert().accept();

		

		System.out.println(timeAtt);


		
		if(timeAtt.equals("Minute(s)"))
		{
			
			Thread.sleep(z2*60*1000);
		}
		else if(timeAtt.equals("Hour(s)"))
		{
			Thread.sleep(z2*3600*60*1000);
			

		}
		else if(timeAtt.equals("Seconds(s)"))
		{
			
			Thread.sleep(z2*1000);
		}
		else if(timeAtt.equals("Day(s)"))
		{
			
			Thread.sleep(z2*24*60*60*1000);
		}




	}


}


