package Banking_alerts;

import org.testng.annotations.Test;

import login.Login;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class System_alerts extends Login{



	//******************************************system alerts*****************************************
	@Test(priority=3,alwaysRun=true)
	public void sys_Alerts() throws InterruptedException//this annotation is for managing the system alerts...
	{
		driver.findElement(By.xpath("//*[@id='menu2']/span[2]")).click();//for clicking the alerts
		driver.findElement(By.xpath("//*[@id='submenu2.0']/span[2]")).click();//for clicking the system alerts
		System.out.println(driver.findElement(By.xpath("//*[@id='tdContents']/form/table[1]")).getText());
		Thread.sleep(1000);
	}
	@Test(priority=4,alwaysRun=true)
	public void delete_sys_alerts()
	{
		driver.findElement(By.xpath("//*[@id='tdContents']/form/table[2]/tbody/tr/td[2]/input")).click();//for clicking the remove selected
		System.out.println(driver.switchTo().alert().getText());//for printing the text from the alert window
		driver.switchTo().alert().accept();//for accepting the alert that is clicking on ok button..
		driver.findElement(By.xpath("//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/input")).click();//for selecting the system alerts that is the checkbox.
		driver.findElement(By.xpath("//*[@id='tdContents']/form/table[2]/tbody/tr/td[2]/input")).click();//for clicking on the remove button for removing the selected checkboxes.	  
		System.out.println(driver.switchTo().alert().getText());//for getting the testmessage from the alert..
		driver.switchTo().alert().accept();
		String messageForDelete=driver.switchTo().alert().getText();
		assertEquals(messageForDelete, "The selected alert(s) have been removed");//assertEquals for delete confirmation
		System.out.println("The selected alert(s) have been removed");
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().accept();

			}

}
