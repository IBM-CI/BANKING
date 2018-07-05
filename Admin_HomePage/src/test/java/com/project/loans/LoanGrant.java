package com.project.loans;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.project.login.Login;

public class LoanGrant extends Login {
	
	@Test(priority=4,alwaysRun=true)
	public void loanPage() throws InterruptedException
	{    
		String expected=driver.findElement(By.cssSelector("input.large.InputBoxDisabled.required")).getAttribute("value");
		driver.findElement(By.cssSelector("input.linkButton[linkurl*=grantLoan]")).click();	
		Thread.sleep(1000);
		String actualValuname=driver.findElement(By.cssSelector(".large.InputBoxDisabled")).getAttribute("value");
		Thread.sleep(1000);
		//String actualValu=driver.findElement(By.cssSelector("td.tdHeaderTable")).getText();
		assertEquals(actualValuname, expected," wrong page defult user name is not present in loan page ");
	}
	@Test(priority=5,alwaysRun=true)
	public void loanDetail()
	{
		Select type=new Select(driver.findElement(By.cssSelector("select#transferType")));
		List<WebElement> item= type.getOptions();
		for(int i=0;i<item.size();i++)
		{
			//assert for loan list is show or not
		assertEquals(item.get(i).getText(), "Loan","Some problem in Type becuse type is alwayes show Loan option only ");
			//System.out.println(item.get(i).getText());
		}
		driver.findElement(By.cssSelector("#amount")).sendKeys("1230");
		String amount=driver.findElement(By.cssSelector("#amount")).getAttribute("value");
		int charAmount=amount.length();
		if(charAmount>10)
			assertEquals(charAmount, 10);
	}
     @Test(priority=6,alwaysRun=true)
     public void otherDetailForLoan()
     {
    	 driver.findElement(By.cssSelector(".small.InputBoxEnabled")).sendKeys("danish");
    	 String identy=driver.findElement(By.cssSelector(".small.InputBoxEnabled")).getAttribute("value");
    	 int identyNu=identy.length();
    	 if(identyNu>10)
    		 assertEquals(identyNu, 10);
     }
     @Test(priority=7,alwaysRun=true)
     public void moreDetail()
     {
    	 driver.findElement(By.cssSelector("input[name*]repaymentDate")).sendKeys("01/07/2018");
    	 driver.findElement(By.cssSelector("textarea[name*=description]")).sendKeys("please approve my loan ");
    	 String desc=driver.findElement(By.cssSelector("textarea[name*=description]")).getText();
    	 int desCount=desc.length();
    	 if(desCount>100)
    	 assertEquals(desc, 100);
     }
	@Test(priority=3,alwaysRun=true)
	public void jumpToMemberProfile()
	{

		driver.findElement(By.id("memberUsername")).sendKeys("saa");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
