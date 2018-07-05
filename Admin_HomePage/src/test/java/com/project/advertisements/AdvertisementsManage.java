package com.project.advertisements;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.project.login.Login;
public class AdvertisementsManage extends Login {
	@Test(priority=4,alwaysRun=true)
	public void adModule()
	{
		String name=driver.findElement(By.cssSelector("input.large.InputBoxDisabled.required")).getAttribute("value");
		driver.findElement(By.cssSelector("input[linkurl*=memberAds]")).click();
		String headerTable=driver.findElement(By.className("tdHeaderTable")).getText();
		String actualValue="Advertisements of "+name;
		assertEquals(headerTable, actualValue);
	}
	    @Test(priority=5,alwaysRun=true)
	    public void modifyAdvertisment() throws InterruptedException
	    {
	    	driver.findElement(By.cssSelector("img.edit.editAd")).click();
	    	driver.findElement(By.cssSelector("#modifyButton")).click();
	    	driver.findElement(By.cssSelector("input[name*=title]")).sendKeys("change title");
	    	driver.findElement(By.id("saveButton")).click();
	    	String modifyMasssge=driver.switchTo().alert().getText();
	    	driver.switchTo().alert().accept();
	    	assertEquals(modifyMasssge, "Advertisement modified", "you are not modify advertisment");
	    	System.out.println(modifyMasssge);
	    	 driver.findElement(By.cssSelector("input#backButton.button")).click();
		        Thread.sleep(10000);
	    }
	    @Test(priority=6,alwaysRun=true)
	    public void removeAdvertisment() throws InterruptedException 
	    {  
	    	driver.findElement(By.cssSelector("img.remove.removeAd")).click();
	    	String messageGet=driver.switchTo().alert().getText();
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().alert().accept();
	    	assertEquals(messageGet, "Remove advertisement?","not remove advertisement");
	    	System.out.println(messageGet);
	    }
	    
	    @Test(priority=7,alwaysRun=true)
	    public void addNewAd()
	    {
		driver.findElement(By.id("newButton")).click();
		/*List <WebElement> list=driver.findElements(By.cssSelector("input[value^=OFFER]"));
		
		System.out.println(list);*/
		//assertEquals(radioButValu, "Offer");
		driver.findElement(By.cssSelector("input[name*=title]")).sendKeys("Welcome to");
		String title=driver.findElement(By.cssSelector("input[name*=title]")).getAttribute("value");
		int count=title.length();
		if(count<=4)
			assertEquals(count, 5);
		else if(count>=25)
			assertEquals(count, 26);
		Select category=new Select(driver.findElement(By.cssSelector("select.InputBoxEnabled")));
		category.selectByValue("1");
		String storeCatog=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/select/option[2]")).getText();
		assertEquals(storeCatog, "Example ad category");
		driver.findElement(By.cssSelector("input[name*=price]")).sendKeys("12345");
		String price=driver.findElement(By.cssSelector("input[name*=price]")).getAttribute("value");
		//int yourNumber = Integer.parseInt(price);//need to ask

		boolean valu= driver.findElement(By.cssSelector("input[name*=permanent]")).isDisplayed();
		assertEquals(valu, true);
		// Publication Date (need to ask)
		driver.findElement(By.cssSelector("input[name*=begin]")).sendKeys("12/07/2018");
		String fmt =driver.findElement(By.cssSelector("input[name*=begin]")).getText();
		/*SimpleDateFormat fmat = new SimpleDateFormat("dd/MM/yyyy"); 
		try {
			Date Fdate = fmat.parse(fmt);
			if (((Comparable<Date>) fmat).compareTo(Fdate) >= 0) {
				return;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		driver.findElement(By.cssSelector("input[name*=end]")).sendKeys("16/07/2018");
		String exp =driver.findElement(By.cssSelector("input[name*=end]")).getText();
		/*SimpleDateFormat expdate = new SimpleDateFormat("dd/MM/yyyy"); 
		try {
			Date Edate = expdate.parse(exp);
			if (((Comparable<Date>) expdate).compareTo(Edate) >= 0) {
				return;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}*/
		driver.findElement(By.cssSelector("#cke_contents_descriptionText>iframe")).sendKeys("hi this is ad for you");
		driver.findElement(By.cssSelector("input#saveButton.button")).click();
	     String sendAd=driver.switchTo().alert().getText();
	     assertEquals(sendAd, "Advertisement inserted");
	     /*try{
	     driver.findElement(By.id("addPictureCheck")).click();
	     String boxClick=driver.findElement(By.cssSelector("input#pictureFile.upload.InputBoxEnabled")).getText();
	     System.out.println(boxClick);
	     }catch (Exception e) {
			
		}*/
	     System.out.println(sendAd);
	     driver.switchTo().alert().accept();
	}
	    @Test(priority=8,alwaysRun=true) 
	    public void disableExpire() throws InterruptedException
	    {
	    	driver.findElement(By.id("newButton")).click();
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("notExpirableCheck")).click();
	    	driver.findElement(By.cssSelector("input[name*=title]")).sendKeys("Welcome to");
			String title=driver.findElement(By.cssSelector("input[name*=title]")).getAttribute("value");
			int count=title.length();
			if(count<=4)
				assertEquals(count, 5);
			else if(count>=25)
				assertEquals(count, 26);
			Select category=new Select(driver.findElement(By.cssSelector("select.InputBoxEnabled")));
			category.selectByValue("1");
			driver.findElement(By.cssSelector("input[name*=price]")).sendKeys("12345");
			driver.findElement(By.cssSelector("input[name*=begin]")).sendKeys("12/07/2018");
			String fmt =driver.findElement(By.cssSelector("input[name*=begin]")).getText();
			assertEquals(fmt, ""," after disable date should not be take genetaring but it taken ");
			driver.findElement(By.cssSelector("input[name*=end]")).sendKeys("16/07/2018");
			String exp =driver.findElement(By.cssSelector("input[name*=end]")).getText();
			assertEquals(fmt, ""," after disable date should not be take expiry but it taken ");
			driver.findElement(By.cssSelector("#cke_contents_descriptionText>iframe")).sendKeys("hi this is ad for you");
			driver.findElement(By.cssSelector("input#saveButton.button")).click();
		     String sendAd=driver.switchTo().alert().getText();
		     assertEquals(sendAd, "Advertisement inserted"," Advertisement not inserted without expiry and crate date when i decible the expiry box ");
		     driver.switchTo().alert().accept();
	    }
	    
	@Test(priority=3)
	public void jumpToMemberProfile()
	{

		driver.findElement(By.id("memberUsername")).sendKeys("saa");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
