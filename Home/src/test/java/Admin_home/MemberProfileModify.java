package Admin_home;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class MemberProfileModify extends MemberProfileChangePassword {
	@Test(priority=7,alwaysRun=true)
	public void modifyMemberProfile() throws InterruptedException
	{   
	    
		String InputComment="welcome to the section show are are you apply or not if yes ignore if not please apply";

		//driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[2]/td[2]/input")).click();
		//List<WebElement> list=driver.findElement(By.xpath("//*[@name='newGroupId'][@value='11']")).getAttribute("value");
		driver.findElement(By.cssSelector("input[linkurl*='changeMemberGroup']")).click();
		Select group=new Select(driver.findElement(By.name("newGroupId")));
		if(driver.findElement(By.cssSelector("input.large.InputBoxDisabled")).getAttribute("value").equals("Full brokers"))
		group.selectByValue("5");
		else
			group.selectByValue("9");
		//driver.findElement(By.xpath("//*[@value='11']")).click();
		driver.findElement(By.xpath("//*[@id='comments']")).sendKeys(InputComment);
		String comment=driver.findElement(By.id("comments")).getAttribute("value");
        int length=comment.length();
        if(length>40)
		assertEquals(length, 40);
        driver.findElement(By.cssSelector("input.button[value=Submit]")).click();
        driver.switchTo().alert().accept();
	}
	@Test (priority=8,alwaysRun=true)
	public void historyTab()
	{
		
		String history=driver.findElement(By.xpath(".//*[@id='tdContents']/table/tbody/tr[1]/td[1]")).getText();
		//if(history.equals("History"))
		assertEquals(history, "History","there have some problem the didn't show history");
		System.out.println(history+" is showing");
	}
	    @Test(priority=9,alwaysRun=true)
	    public void getHistoryTable() throws InterruptedException
	    {
			
		String historyTable= driver.findElement(By.xpath(".//*[@id='tdContents']/table")).getText();
		System.out.println(historyTable);
		driver.navigate().back();
		Thread.sleep(2000);
	}
	@Test(priority=6,alwaysRun=true)
	public void backNevigationForMemberModify()
	{
		driver.findElement(By.id("backButton")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
