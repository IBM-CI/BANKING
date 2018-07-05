package com.project.accountInformation;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.project.login.Login;

public class AccountInformation extends Login {
@Test(priority=4)
public void accoutInfo() throws InterruptedException
{
	driver.findElement(By.cssSelector("input.linkButton[linkurl*=accountOverview]")).click();
	String paymentHistory=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[3]/td/table")).getText();
	System.out.println(paymentHistory);
	Select paymentType=new Select(driver.findElement(By.cssSelector("select[name*=paymentFilter]")));
	List<WebElement> listOfPayment=paymentType.getOptions();
	String list_cat[]=new String[]{"All","Commission payments","Loan payments","Member payments","System payments","Taxes and fees","Voucher payments"};
	//Iteration for getting value from dropbox	
	for(int i=0;i<listOfPayment.size();i++)
	{//System.out.println(listOfPayment.get(i).getText());
		assertEquals(listOfPayment.get(i).getText(), list_cat[i]);
	}
	driver.findElement(By.cssSelector("#memberUsername")).sendKeys("saa");
	Thread.sleep(1000);
	String actualMember=driver.findElement(By.cssSelector("#memberUsername")).getAttribute("value");
	assertEquals(actualMember, "saam", "not taken when give username some char ");
	String actualFullName=driver.findElement(By.cssSelector("#memberName")).getAttribute("value");
	assertEquals(actualFullName, "sameer arjun", "Full name is not showing ");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("input[name*=begin]")).sendKeys("15/06/2018");
	driver.findElement(By.cssSelector("input[name*=end]")).sendKeys("02/07/2018");
	driver.findElement(By.className("full")).sendKeys("i need my statment");
	String description=driver.findElement(By.className("full")).getAttribute("value");
	int sizeOfDsc=description.length();
	System.out.println(sizeOfDsc);
	if(sizeOfDsc>25)
		assertEquals(sizeOfDsc, 25);
	/*String actual=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[3]/td/table")).getText();
	assertEquals(actual, paymentHistory);*/
	}
@Test(priority=5,alwaysRun=true)
public void submit()
{   driver.findElement(By.className("button")).click();
   String afterSubmit=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[1]/td[1]")).getText();
   assertEquals(afterSubmit, "Search results");
	}
@Test(priority=3)
public void jumpToMemberprofile()
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
