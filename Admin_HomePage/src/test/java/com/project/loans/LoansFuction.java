package com.project.loans;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.project.login.Login;

public class LoansFuction extends Login {
	@Test(priority=4)
	public void loanPageAfterClickSubmit() throws InterruptedException
	{
	driver.findElement(By.cssSelector("input.linkButton[linkurl*=grantLoan]")).click();	
	Thread.sleep(1000);
	String name=driver.findElement(By.cssSelector(".large.InputBoxDisabled")).getAttribute("value");
	Thread.sleep(1000);
	String actualValu=driver.findElement(By.cssSelector("td.tdHeaderTable")).getText();
	assertEquals(actualValu, "Grant loan to "+name,"goes to wrong page");
	}
	@Test(priority=5,alwaysRun=true)
	public void viewLoan() throws InterruptedException
	{    
	     driver.findElement(By.cssSelector("#backButton")).click();
	     Thread.sleep(1000);
		driver.findElement(By.cssSelector("input.linkButton[linkurl*=searchLoans]")).click();
		String view=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[1]/td[1]")).getText();
	    System.out.println(view);
	    assertEquals(view, "Search results");
	}
	@Test(priority=3)
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
