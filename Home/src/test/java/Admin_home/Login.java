package Admin_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;
	
	@Test(priority=2)
	public void loginDetail()
	{
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		try{
			
             driver.findElement(By.xpath(".//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal'][@value='1']")).click();
             driver.findElement(By.xpath(".//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal'][@value='2']")).click();
             driver.findElement(By.xpath(".//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal'][@value='3']")).click();
             driver.findElement(By.xpath(".//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal'][@value='4']")).click();
             driver.findElement(By.xpath(".//*[@id='virtualKeyboard']/div[2]/table/tbody/tr[2]/td/input[3]")).click();
		
		}
		catch (Exception e) {
			//System.out.println(e.toString());
		}
		try{
		driver.findElement(By.xpath(".//*[@id='cyclosPassword']")).sendKeys("1234");
		driver.findElement(By.xpath(".//*[@id='cyclosLogin']/table/tbody/tr[3]/td/input")).click();
		}
		catch (Exception e) {
			//System.out.println(e.toString());
		}
		
		
	}
	@Test(priority=1)
	public void browserLunch()
	{
		driver=new FirefoxDriver();
	    driver.get("http://localhost:8585/do/login");
	    driver.manage().window().maximize();
	    //driver.manage().window().fullscreen();
	}
	/*	*/	

}
