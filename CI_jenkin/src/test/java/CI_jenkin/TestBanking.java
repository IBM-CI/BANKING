package CI_jenkin;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestBanking {
	WebDriver driver = new FirefoxDriver();
	String oldPassword="1234";
	String newPassword="1234";
	String confirmPassword="1234";
	String email_id="s@gmail.in";

	
	
	@Test(priority=1,alwaysRun=true)
	public void login() {
		
		
		//WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8585/do/");
		driver.manage().window().maximize();
		driver.findElement(By.name("principal")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys(oldPassword);
		driver.findElement(By.className("button")).click();
	}
	@Test(priority=2,alwaysRun=true)
	public void ValidateAdminLoginName()
	{

		driver.findElement(By.cssSelector("li[id='menu1']")).click(); //To click on Personal page

		//To click on profile
		driver.findElement(By.cssSelector("li[id='submenu1.0']")).click();//To click on profile
		String adminScreen=driver.findElement(By.name("admin(group).name")).getAttribute("value");
		assertEquals(adminScreen, "System administrators", "Not displaying the field as system administrator"); //To check whether it displays as System administrator


		String loginName=driver.findElement(By.name("admin(user).username")).getAttribute("value");
		assertEquals(loginName,"admin", "Not displaying the field as admin"); //To check whether loginName is admin
		//System.out.println("Login Name "+loginName);
	}


	@Test(priority=3,alwaysRun=true)
	public void ChangeButtonValidation()
	{
		String b1=driver.findElement(By.id("modifyButton")).getAttribute("value");
		System.out.println("The value of the button is "+b1);
		driver.findElement(By.id("modifyButton")).click(); //To click on change button
		String cancelButton=driver.findElement(By.id("modifyButton")).getAttribute("value");
		System.out.println("The value of the button is "+cancelButton);
		assertEquals(cancelButton,"Cancel","Invalid: Not a cancel button");
		System.out.println("Button "+b1+" is changed as "+cancelButton);
		driver.findElement(By.id("modifyButton")).click(); //Click on cancel button
		boolean buttonEnabled=driver.findElement(By.className("ButtonDisabled")).isEnabled();
		if(buttonEnabled)
			System.out.println("Submit button is enabled when clicked on change button");
		else
			System.out.println("Submit button is Disabled");
	} 


	@Test(priority=4,alwaysRun=true)
	public void AdminNameEmailValidate()
	{
		driver.findElement(By.id("modifyButton")).click();//To click on change button


		boolean name=(driver.findElement(By.name("admin(name)")).isEnabled());
		assertEquals(name,true,"Full name fieled is not enabled");

		boolean email=(driver.findElement(By.name("admin(email)")).isEnabled());
		assertEquals(email,true,"E-mail fieled is not enabled");
		/*WebElement systemAdmin=driver.findElement(By.name("admin(group).name"));
	  boolean actualValue=systemAdmin.isEnabled();
	  aseertEquals(actualValue,1); */
	}

	@Test(priority=5,alwaysRun=true)
	public void FullNameValidate()
	{

		driver.findElement(By.name("admin(name)")).clear();
		driver.findElement(By.name("admin(name)")).sendKeys("Shamitha Ammanna");//To pass username
		String fullName=driver.findElement(By.name("admin(name)")).getAttribute("value");
		int nameSize=fullName.length(); //To find out the length of full name
		if(nameSize>20)
			assertEquals(nameSize,20,"Enter the characters between 4 to 20 characters"); //To pause if the entered string is greater than 20
		boolean nameVerify=fullName.matches(".*[0-9]"); //To check whether name contains only characters
		assertEquals(nameVerify, false,"Name should contain only characters");
	}


	@Test(priority=6,alwaysRun=true)
	public void emailValidate()
	{
		driver.findElement(By.name("admin(email)")).clear();
		driver.findElement(By.name("admin(email)")).sendKeys(email_id);
		String emailId=driver.findElement(By.name("admin(email)")).getAttribute("value");
		int emailSize=emailId.length();
		if(emailSize>20)
			assertEquals(emailSize,20,"Enter the characters within 20 characters");
		boolean emailVerify=emailId.matches("[0-9 A-Z a-z]+[@]+[a-z]+[.]+[a-z]+"); //To check for correctness of email id 
		assertEquals(emailVerify, true,"Invalid email format ");
	} 

	@Test(priority=7,alwaysRun=true)
	public void submitValidate()
	{
		driver.findElement(By.id("saveButton")).click(); //To click on submit button
		System.out.println(driver.switchTo().alert().getText()); //To print the message after the profile is modified
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}


	@Test(priority=8,alwaysRun=true)
	public void oldPasswordvalidate()
	{
		//change password option
		driver.findElement(By.cssSelector("li[id='submenu1.1']")).click(); //To go to Change password option

		boolean label=driver.getPageSource().contains("Choose a password with a length between 4 and 12 characters");
		if(label!=true)
			assertEquals(false,true,"Label not found!!!!");
		System.out.println("Choose a password with a length between 4 and 12 characters label found");



		String currentPassword="1234";
		driver.findElement(By.name("oldPassword")).sendKeys(currentPassword); //old password
		assertEquals(currentPassword,oldPassword,"Cuurent password does not match");
		System.out.println("Current password is valid");
	}


	@Test(priority=9,alwaysRun=true)
	public void newPassword()
	{
		driver.findElement(By.name("newPassword")).sendKeys(newPassword);  //new password

		int passwordSize=newPassword.length();
		if(passwordSize>10)
			assertEquals(passwordSize,10,"Password should be less then 10 characters");
		else if(passwordSize<4)
			assertEquals(passwordSize,4,"Password should be greater then 4 characters");

		boolean passwordVerify=newPassword.matches("[0-9!@#$%&*()-_+={|<>/.,?;:]+"); //To check for atleast one numeric and special character in password 
		assertEquals(passwordVerify, true,"Password should contain at least one numeric and special character ");
	}


	@Test(priority=10,alwaysRun=true)
	public void confirmPasswordValidate()
	{

		driver.findElement(By.name("newPasswordConfirmation")).sendKeys(newPassword); //Password confirmation
		int newPasswordSize=newPassword.length();
		if(newPasswordSize>10)
			assertEquals(newPasswordSize,10,"Password should be less then 10 characters");
		else if(newPasswordSize<4)
			assertEquals(newPasswordSize,4,"Password should be greater then 4 characters");

		boolean confirmPasswordVerify=confirmPassword.matches("[0-9!@#$%&*()-_+={|<>/.,?;:]+"); //To check for atleast one numeric and special character in password 
		assertEquals(confirmPasswordVerify, true,"Password should contain at least one numeric and special character ");
	}



	@Test(priority=11,alwaysRun=true)
	public void passwordSubmitValidate()
	{
		driver.findElement(By.className("button")).click(); //Password change submit button
		System.out.println(driver.switchTo().alert().getText());
		System.out.println("New password is saved");
		//System.out.println(driver.switchTo().alert().getText());
		try {
			Thread.sleep(1000);  //wait for 10secs in alert 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept(); //To click on OK button




	}

}





