package Admin_home;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AccountInformation extends AccountModule {
@Test(priority=19,alwaysRun=true)
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
  }
    @Test(priority=20,alwaysRun=true)
    public void accountName() throws InterruptedException{
	driver.findElement(By.cssSelector("#memberUsername")).sendKeys("sanam");
	Thread.sleep(1000);
	String actualMember=driver.findElement(By.cssSelector("#memberUsername")).getAttribute("value");
	assertEquals(actualMember, "sanam", "not taken when give username some char ");
	String actualFullName=driver.findElement(By.cssSelector("#memberName")).getAttribute("value");
	assertEquals(actualFullName, "sanam", "Full name is not showing ");
	Thread.sleep(1000);
    }
	@Test(priority=21,alwaysRun=true)
    public void datePassing(){
	driver.findElement(By.cssSelector("input[name*=begin]")).sendKeys("15/06/2018");
	driver.findElement(By.cssSelector("input[name*=end]")).sendKeys("02/07/2018");
	driver.findElement(By.className("full")).sendKeys("i need my statment");
	String description=driver.findElement(By.className("full")).getAttribute("value");
	int sizeOfDsc=description.length();
	System.out.println(sizeOfDsc);
	if(sizeOfDsc>=25)
		assertEquals(sizeOfDsc, 25);
	/*String actual=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[3]/td/table")).getText();
	assertEquals(actual, paymentHistory);*/
	}
@Test(priority=22,alwaysRun=true)
public void submit() throws InterruptedException
{   driver.findElement(By.className("button")).click();
   String afterSubmit=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[1]/td[1]")).getText();
   assertEquals(afterSubmit, "Search results");
   driver.navigate().back();
   Thread.sleep(1000);
   driver.navigate().back();
   Thread.sleep(1000);
	}
/*@Test(priority=3)
public void jumpToMemberprofile()
{
	driver.findElement(By.id("memberUsername")).sendKeys("sanam");

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}*/
}
