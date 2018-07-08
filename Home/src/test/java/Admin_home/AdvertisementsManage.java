package Admin_home;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class AdvertisementsManage extends MemberProfileModify {
	@Test(priority=10,alwaysRun=true)
	public void adModule() throws InterruptedException
	{
		
		String name=driver.findElement(By.cssSelector("input.large.InputBoxDisabled.required")).getAttribute("value");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[linkurl*=memberAds]")).click();
		String headerTable=driver.findElement(By.className("tdHeaderTable")).getText();
		String actualValue="Advertisements of "+name;
		assertEquals(headerTable, actualValue);
	}
	    @Test(priority=11,alwaysRun=true)
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
	    @Test(priority=12,alwaysRun=true)
	    public void removeAdvertisment() throws InterruptedException 
	    {  
	    	driver.findElement(By.cssSelector("img.remove.removeAd")).click();
	    	String messageGet=driver.switchTo().alert().getText();
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().alert().accept();
	    	assertEquals(messageGet, "Remove advertisement?","not remove advertisement");
	    	System.out.println(messageGet);
	    }
	    
	    @Test(priority=13,alwaysRun=true)
	    public void addNewAd()
	    {
		driver.findElement(By.id("newButton")).click();
		/*List <WebElement> list=driver.findElements(By.cssSelector("input[value^=OFFER]"));
		
		System.out.println(list);*/
		//assertEquals(radioButValu, "Offer");
		driver.findElement(By.cssSelector("input[name*=title]")).sendKeys("Welcome to i will try with more then 25 title");
		String title=driver.findElement(By.cssSelector("input[name*=title]")).getAttribute("value");
		
		Select category=new Select(driver.findElement(By.cssSelector("select.InputBoxEnabled")));
		category.selectByValue("1");
		String storeCatog=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/select/option[2]")).getText();
		assertEquals(storeCatog, "Example ad category");
		driver.findElement(By.cssSelector("input[name*=price]")).sendKeys("12345");
		//String price=driver.findElement(By.cssSelector("input[name*=price]")).getAttribute("value");
		String price=driver.findElement(By.cssSelector("input[name*=price]")).getAttribute("value");
		boolean valu= driver.findElement(By.cssSelector("input[name*=permanent]")).isDisplayed();
		assertEquals(valu, true);
		// Publication Date (need to ask)
		driver.findElement(By.cssSelector("input[name*=begin]")).sendKeys("12/07/2018");
		String fmt =driver.findElement(By.cssSelector("input[name*=begin]")).getText();
		driver.findElement(By.cssSelector("input[name*=end]")).sendKeys("16/07/2018");
		String exp =driver.findElement(By.cssSelector("input[name*=end]")).getText();
		driver.findElement(By.cssSelector("#cke_contents_descriptionText>iframe")).sendKeys("hi this is ad for you");
		driver.findElement(By.cssSelector("input#saveButton.button")).click();
	     String sendAd=driver.switchTo().alert().getText();
	     assertEquals(sendAd, "Advertisement inserted");
	     
	     System.out.println(sendAd);
	     driver.switchTo().alert().accept();
	     int count=title.length();
			if(count<=4)
				assertEquals(count, 5);
			else if(count>=25)
				assertEquals(count, 25,"the valu of title must take 4 to 25 but it take more then 25");
			int priceLength=price.length();
			if(priceLength<=4){
				assertEquals(priceLength, 10);
				}
			}
	    @Test(priority=14,alwaysRun=true) 
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
	    /*@Test(priority=9,alwaysRun=true) 
	    public void closeBrowser()
	    {
	    	driver.close();
	    }*/
	/*@Test(priority=3)
	public void jumpToMemberProfile()
	{

		driver.findElement(By.id("memberUsername")).sendKeys("samrr");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
