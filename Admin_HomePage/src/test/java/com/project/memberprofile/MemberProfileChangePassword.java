
package com.project.memberprofile;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.project.login.Login;

import com.project.applicationstatus.*;
public class MemberProfileChangePassword extends Login {
	@Test(priority=4)
	public void ChangePasswordForMember()
	{
		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[1]/td[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("12345");;
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("12345");
        driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[5]/td/input")).click();
		String passchaForMem= driver.switchTo().alert().getText();
		assertEquals(passchaForMem, "The password was modified");
		System.out.println("password is modifed");
		driver.switchTo().alert().accept();
	}
	@Test(priority=3)
	public void jumpToMemberProfile()
	{
		//driver.findElement(By.id("memberUsername")).click();
		driver.findElement(By.id("memberUsername")).sendKeys("samrr");
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
