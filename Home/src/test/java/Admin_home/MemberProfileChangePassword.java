
package Admin_home;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class MemberProfileChangePassword extends ApplicationStatus {
	@Test(priority=5,alwaysRun=true)
	public void ChangePasswordForMember() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[1]/td[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("12345");;
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("12345");
        driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[5]/td/input")).click();
		String passchaForMem= driver.switchTo().alert().getText();
		assertEquals(passchaForMem, "The password was modified");
		System.out.println("password is modifed");
		driver.switchTo().alert().accept();
		/*driver.navigate().back();
		Thread.sleep(2000);*/
		
	}
	@Test(priority=4,alwaysRun=true)
	public void jumpToMemberProfile()
	{
		//driver.findElement(By.id("memberUsername")).click();
		driver.findElement(By.id("memberUsername")).sendKeys("sanam");
       /*driver.findElement(By.id("memberUsername")).sendKeys(Keys.DOWN);
		driver.findElement(By.className("selected")).click();*/
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
