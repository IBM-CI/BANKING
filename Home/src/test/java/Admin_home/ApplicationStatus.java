package Admin_home;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
 
public class ApplicationStatus extends Login {
	//WebDriver driver;
	@Test(priority=3)
	public void checkAppDetail()
	{ 
		String headerField= driver.findElement(By.className("headerField")).getText();
		assertEquals(headerField, "3.7.3");
		System.out.println("version is = 3.7.3");
		String uptime=driver.findElement(By.id("uptime")).getText();
		System.out.println("Application uptime "+uptime);
		
		String unreadMassege=driver.findElement(By.id("unreadMessages")).getText();
		System.out.println("unread Massege "+unreadMassege);
		System.out.println("openInvoices "+driver.findElement(By.id("openInvoices")).getText());
        System.out.println("connected Admins "+driver.findElement(By.id("connectedAdmins")).getText());
        System.out.println("connected Members "+driver.findElement(By.id("connectedMembers")).getText());
        System.out.println("connected Brokers "+driver.findElement(By.id("connectedBrokers")).getText());
        System.out.println("No of system Alerts "+driver.findElement(By.id("systemAlerts")).getText());
        System.out.println("No of member Alerts " +driver.findElement(By.id("memberAlerts")).getText());
        System.out.println("No of errors "+driver.findElement(By.id("errors")).getText());
         System.out.println(driver.findElement(By.cssSelector(".loginData")).getText());  
         System.out.println(driver.findElement(By.xpath(".//*[@id='loginDataBar']/span[2]")).getText());
	}
}
