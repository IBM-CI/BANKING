
package com.messages;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MessageCategoryTest extends Messages {

	//WebDriver driver=new FirefoxDriver();
/*
	@Test(priority=1)
	public void login() {
		//WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8585/do/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("principal")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.className("button")).click();
	}

*/
	@Test(priority=13,alwaysRun=true)
	public void messageCategoryValidation()
	{
		driver.findElement(By.cssSelector("li[id='menu8']")).click();//click on Messages
		driver.findElement(By.cssSelector("li[id='menu8']")).click();//click on Messages
		//driver.findElement(By.cssSelector("li[id='submenu8.1']")).click();  //Click on message categories
driver.findElement(By.id("submenu8.1")).click();
		/*//To check whether the message category page opens
		String expectedUrl=driver.getCurrentUrl();
		String actualUrl="http://localhost:8585/do/admin/listMessageCategories?fromMenu=true";
		assertEquals(actualUrl,expectedUrl,"Cannot open message category page");*/
	}



	@Test(priority=14,alwaysRun=true)
	public void defaultValuesValidation()
	{
		//To check whether default values(Support,Administration,Loan) are present
		String actualString1=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[1]")).getText();
		assertEquals(actualString1, "Support", "Default value not present");
		String actualString2=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[1]")).getText();
		assertEquals(actualString2, "Administration", "Default value not present");
		String actualString3=driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td[1]")).getText();
		assertEquals(actualString3, "Loan", "Default value not present");
		/*String actualString1= driver.findElement(By.className("ClassColor1")).getText();
	  assertEquals(actualString1, "Support", "Default value not present");*/
	}


	@Test(priority=15,alwaysRun=true)
	public void insertCategory()
	{
		//To insert a new category
		driver.findElement(By.id("newButton")).click();
		String expectedTitle=driver.getCurrentUrl(); //To check whether the expected URL matches
		String actualTitle="http://localhost:8585/do/admin/editMessageCategory";
		assertEquals(actualTitle,expectedTitle,"Expected URL does not match");

		driver.findElement(By.name("messageCategory(name)")).sendKeys("career");
		String categoryName=driver.findElement(By.name("messageCategory(name)")).getAttribute("value");
		int categorySize=categoryName.length();
		if(categorySize>20)
			assertEquals(categorySize,20,"Enter the characters within 20 characters");
		else if(categorySize<4)
			assertEquals(categorySize,4,"Enter atleast 4 characters");

		driver.findElement(By.id("saveButton")).click();  //

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept(); 
		System.out.println("Insert new category is executing");
	}

	@Test(priority=16,alwaysRun=true)
	public void modifyCategory()
	{
		//To modify category name
		List<WebElement> msg_categories=driver.findElements(By.cssSelector(".edit.messageCategoryDetails"));
		msg_categories.get(4).click();
		driver.findElement(By.id("modifyButton")).click();
		driver.findElement(By.name("messageCategory(name)")).clear();
		driver.findElement(By.name("messageCategory(name)")).sendKeys("Team members");
		driver.findElement(By.id("saveButton")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		System.out.println("Modify category is successfully executed");
	}
	@Test(priority=17,alwaysRun=true)
	public void deleteCategory() throws InterruptedException
	{
		//To delete the category
		 driver.findElement(By.cssSelector(".defaultTable>tbody>tr:nth-child(5)>td>img[src='/pages/images/delete.gif']")).click();
			Thread.sleep(1000);
		driver.switchTo().alert().accept(); //To click on OK for deleting the message
		
			Thread.sleep(1000);
		
		driver.switchTo().alert().accept(); //Click on OK after the deleting
		System.out.println("Successfully deleted the category");
	
	}
}