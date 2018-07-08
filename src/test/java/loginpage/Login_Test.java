package loginpage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login_Test {
	
	 WebDriver driver;
	 String name = "admin";
	//----------------------Entering URL-------------------//
	
@Test(priority=1,alwaysRun=true)
public void url() {
	 
	  driver = new FirefoxDriver();
	  driver.get("http://localhost:8585/do/login");
}
//--------------------user name---------------------------//
@Test(priority=2,alwaysRun=true)
	public void username(){
	  
	 
	  driver.findElement(By.id("cyclosUsername")).sendKeys(name);  //User name
	}
//---------------------length----------------------//
@Test(priority=3,alwaysRun=true)
	public void length(){
	  
	  int namesize = name.length();
	  if(namesize<4)
			assertEquals(namesize,4,"username should not be less than 4 characters");
		else if(namesize>10)
			assertEquals(namesize,10,"username should not be more than 10 characters");
}
//-------------------no special character allowed---------------//
@Test(priority=4,alwaysRun=true)
	public void noSpecial(){
	
	  String[] invalidChars = {"#", "!", "$", "@", "%", "^", "&","*",")","(","-","_","=","+","[","]","{","}","|","'",";",":","/","?",">","<","."};
	  for (String invalid : invalidChars) {
			if(name.contains(invalid)){

				assertEquals(invalid,name,"Special characters are not accepted");

			}
			
			
			
		}
	
}
//-------------------no numeric allowed------------------//
@Test(priority=5,alwaysRun=true)
	public void noNumeric(){
	  
	  String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9","0"};
	  for (String num : numbers) {
			if(name.contains(num)){

				assertEquals(num,name,"Numbers are not accepted");

			}
			
		}
	  
}




		  

//------------ Giving password through virtual Keyboard by Caps lock On --------------//
@Test(priority=6,alwaysRun=true)
public void capslock(){
	 
			 try {
				driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[2]/table/tbody/tr[2]/td/input[1]")).click();  //Caps lock
				
					//Password through virtual keyboard
					driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[1]/input[1]")).click();
					driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[1]/input[2]")).click();
					driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[1]/input[3]")).click();
					driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[1]/input[5]")).click();

				 
				 	driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[2]/table/tbody/tr[2]/td/input[2]")).click();  //Clear 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 	
	  

	  
		  
		
}
//---------------------------------Checking clear button-------------------//
@Test(priority=7,alwaysRun=true)
public void clear(){
	  try {
		if(driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[2]/table/tbody/tr[2]/td/input[2]")).isEnabled()){
			 	driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[2]/table/tbody/tr[2]/td/input[2]")).click();  //Clear 
			 	} 
		 String actual=driver.findElement(By.xpath("//*[@id='cyclosPassword']")).getText();
assertEquals(actual,"");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//----------------------------Password through virtual keyboard--------------------------------//
@Test(priority=8,alwaysRun=true)
public void password(){
	//  if(driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[2]/table/tbody/tr[2]/td/input[2]")).isEnabled()){
	  
	  try {
		driver.findElement(By.xpath("//*[@id='virtualKeyboard']/div[2]/table/tbody/tr[2]/td/input[1]")).click();  //Caps lock 
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    


	  
	  try {
		driver.findElement(By.xpath("//*[@id='cyclosPassword']")).sendKeys("1234");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
	  


 
//----------------------------------------Checking  home page-----------------------//
@Test(priority=10,alwaysRun=true)
public void homepage(){
	  String expectedurl="http://localhost:8585/do/admin/home";
		String actualurl=driver.getCurrentUrl();
		assertEquals(actualurl,expectedurl,"The home page  is not displayed");
}

//-------------------------------------Checking Submit button-----------------------------//
@Test(priority=9,alwaysRun=true)//pror=9
public void submit(){
	  driver.findElement(By.xpath("//*[@class='button' and @value='Submit']")).click();    //submit button
		
}

}
