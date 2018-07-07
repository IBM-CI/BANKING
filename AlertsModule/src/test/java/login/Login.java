package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;
	@Test(priority=2)
	  public void Login_alerts_history() 
	  {
		  
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
			driver.findElement(By.id("cyclosPassword")).sendKeys("1234");
			driver.findElement(By.xpath("//input[@class='button']")).click();
	  }
	  @Test(priority=1)
		public void beforeTest() {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8585/do/login");

	}

}
