package Admin_home;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AccountModule extends AdvertisementsManage {
	@Test(priority=15,alwaysRun=true)
	public void account()
	{
		
		driver.findElement(By.xpath(".//*[@id='menu0']/span[2]")).click();
		driver.findElement(By.id("memberUsername")).sendKeys("sanam");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td/fieldset/table/tbody/tr[1]/td[2]/input")).click();
		String name=driver.findElement(By.cssSelector("input.large.InputBoxDisabled.required[name*=name]")).getAttribute("value");
		driver.findElement(By.cssSelector("input[linkurl*=accountOverview]")).click();
		String accountActual=driver.findElement(By.cssSelector("td.tdHeaderTable")).getText();
		String expectedOutput="Search transactions of "+ name+ " on Member account";
		assertEquals(accountActual, expectedOutput, "Search transactions not verify ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=16,alwaysRun=true)
	public void clickPayment() throws InterruptedException{
		driver.findElement(By.cssSelector("input#backButton")).click();// for come back from account infornmation to main page
		driver.findElement(By.cssSelector("input[linkurl*=payment]")).click();
		driver.findElement(By.cssSelector("#amount")).sendKeys("1000");
		//for checking  one or more dropdown is present in deposit type
		Select depositToAccount=new Select(driver.findElement(By.cssSelector("#type")));
		List<WebElement> listOfPayment=depositToAccount.getOptions();
		//String expected_list_pay_option[]=new String[]{""};
		for(int i=0;i<listOfPayment.size();i++)
		{
			assertEquals(listOfPayment.get(i).getText(), "Debit to member", " it showing more then 'Debit to member' list ");
		}
	}
		@Test(priority=17,alwaysRun=true)
		public void afterPayType() throws InterruptedException{ 
	    Select depositToAccount=new Select(driver.findElement(By.cssSelector("#type")));
		depositToAccount.selectByVisibleText("Debit to member");
		driver.findElement(By.cssSelector("#description")).sendKeys("you get 1000 from admin");
		String comment=driver.findElement(By.cssSelector("#description")).getAttribute("value");
		if(comment.length()>50)
			assertEquals(comment, 50);
		}
		@Test(priority=18,alwaysRun=true)
		public void affterCommentClickToSubmit() throws InterruptedException{
		driver.findElement(By.cssSelector("#submitButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".button")).click();//submit button for conformetion
		try {
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String pStatus=driver.findElement(By.cssSelector(".tdHeaderTable")).getText();//for verify payment success or not
		assertEquals(pStatus, "Successful payment"," payment unsuccesful");
		driver.findElement(By.cssSelector("#backToMemberProfileButton")).click();
		
		
	}
	/*@Test(priority=3,alwaysRun=true)
	public void jumpToMemberProfile()
	{

		driver.findElement(By.id("memberUsername")).sendKeys("sanam");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/}
