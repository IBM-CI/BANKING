package Banking_alerts2;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import login.Login;

public class Member_alerts extends Login{
	//*******************************member alerts******************************//
	
	@Test(priority=3,alwaysRun=true)
	public void mem_alerts() throws InterruptedException 
	{	



		//***********************� It displays all the temporarily blocked members� information as shown in the above image***************
		driver.findElement(By.xpath("//*[@id='menu2']/span[2]")).click();
		driver.findElement(By.xpath("//*[@id='submenu2.1']/span[2]")).click();
		System.out.println(driver.findElement(By.id("tdContents")).getText());
		Thread.sleep(1000);
	}
		//***********************� It displays all the temporarily blocked members� information as shown in the above image***************

	@Test(priority=4,alwaysRun=true)
	public void select_All_Checkbox(){

		//*******************All the member events are selected when clicking on the select all button**************
		driver.findElement(By.id("selectAllButton")).click();
		List<WebElement> checkboxSelectedList=driver.findElements(By.cssSelector("input.checkbox[name=alertIds]"));
		boolean selected;
		for(int i=0;i<checkboxSelectedList.size();i++)
		{
			selected=checkboxSelectedList.get(i).isSelected();
			
				assertEquals(selected, true);
				//System.out.println("all check box is selected");
			
			}}

		//*******************All the member events are selected when clicking on the select all button**************



@Test(priority=5,alwaysRun=true)
public void deselect_all_checkbox(){
		//**********************Deselects all the member events when pressing select none button*******************
		driver.findElement(By.id("selectNoneButton")).click();
		List<WebElement> checkboxUnselectedList=driver.findElements(By.cssSelector("input.checkbox[name=alertIds]"));
		boolean unselected;
		for(int i=0;i<checkboxUnselectedList.size();i++)
		{
			unselected=checkboxUnselectedList.get(i).isSelected();
		
				assertEquals(unselected,false);
				//System.out.println("No check box is selected");
				
			}}
		
		//**********************Deselects all the member events when pressing select none button*******************

		@Test(priority=6,alwaysRun=true)
		public void delete_mem_Alerts(){
		//******************************to verify if the Selected Member event is deleted from the alerts page when pressing Remove selected button ****
        driver.findElement(By.cssSelector("input.checkbox")).click();
		driver.findElement(By.cssSelector("input[value='Remove selected']")).click();
		System.out.println(driver.switchTo().alert().getText());//for getting the testmessage from the alert..
		driver.switchTo().alert().accept();
		String DeleteMemberAlert=driver.switchTo().alert().getText();
		assertEquals(DeleteMemberAlert, "The selected alert(s) have been removed");//assertEquals for delete confirmation
		System.out.println("The selected alert(s) have been removed");
		driver.switchTo().alert().accept();
		}
		//******************************to verify if the Selected Member event is deleted from the alerts page when pressing Remove selected button ****


		@Test(priority=7,alwaysRun=true)
		public void mem_Profile(){

		//*******************To verify if Members profile page opens when clicking on the member name****************************
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/a")).click();
		String name=driver.findElement(By.cssSelector("input.large.InputBoxDisabled.required")).getAttribute("value");
		String actualValue=driver.findElement(By.cssSelector("td.tdHeaderTable")).getText();
		String expectedValue="Profile of "+name;
		assertEquals(actualValue, expectedValue);
		System.out.println(expectedValue);

		//*******************To verify if Members profile page opens when clicking on the member name****************************




	}}
