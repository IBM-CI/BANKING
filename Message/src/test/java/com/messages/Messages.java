//To go to messages link 
package com.messages;
import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Messages {//To click messages link aside
	public WebDriver driver;
	Select options_category_type,options_inbox_type,member_category_send,grp_items,member_category_sendTo;

	@Test(priority=1,alwaysRun=true) //To login
	public void login() throws InterruptedException {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8585/do/login");
		//credentials
		driver.findElement(By.name("principal")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("1234");	  
		driver.findElement(By.className("button")).click();
	    Thread.sleep(1000);
	}

	@Test(priority=2,alwaysRun=true)
	public void msg_start(){ //Entering into message module
		//To click messages
		driver.findElement(By.cssSelector("li[id='menu8']")).click();
		//To click on message link module-1
		driver.findElement(By.cssSelector("li[id='submenu8.0']")).click();
	}
	
	@Test(priority=12,alwaysRun=true)//message box elements UI1
	public void validation(){
		String categories[]=new String[]{"Inbox","Sent items","Trash"};
		//Getting categories values
		//To select and hold value which is selected
		Select msg_category_type=new Select(driver.findElement(By.id("messageBoxSelect")));
		//Adding assert to view all categories from the list		
		List<WebElement> msg_category=msg_category_type.getOptions();
		int i,size;
		size=msg_category.size();
		System.out.println("---elements of size-----"+size);
		//Assert for multiple values present in dropdown
		for(i=0;i<size;i++){
			String actual=msg_category.get(i).getText();
			System.out.println(actual);
			assertEquals(categories[i],actual,"Unable to view dropdown elements");
		}	
		System.out.println("----------------------------------");

	}
	//DISPLAY MESSAGE DETAILS
	@Test(priority=4,alwaysRun=true)
	public void sub_msg_display(){
		driver.findElement(By.cssSelector("a.linkList.messageDetails")).click();	
		//assert
		String expt="Message details";
		String actual=driver.findElement(By.className("tdHeaderTable")).getText();
		assertEquals(expt,actual,"click reply button");
		if(expt.equals(actual)){
			System.out.println("message details displayed");
		}
	}
	
	@Test(priority=5,alwaysRun=true)
	//SR4...reply button
	public void reply_btn() throws InterruptedException{
		driver.findElement(By.id("replyButton")).click();
		Thread.sleep(500);
		//Assert
		String expt="Send message";
		String actual=driver.findElement(By.cssSelector(".tdHeaderTable")).getText();
		assertEquals(expt,actual,"click reply button");
		if(expt.equals(actual)){
			System.out.println("send message page loaded");
		}
		//Going back to main messages page	
		driver.findElement(By.id("backButton")).click();
		driver.findElement(By.id("backButton")).click();
		String expected="Message list";
		String actual_out=driver.findElement(By.cssSelector(".tdHeaderTable")).getText();
		assertEquals(expected,actual_out,"click reply button");
		if(expt.equals(actual)){
			System.out.println("Messages:Home page displayed");
		}
	}
	
	@Test(priority=6,alwaysRun=true) //selecting a value from categories 
	public void appropriate_cat_msg(){
		//To select and hold value which is selected
		Select options_category_type=new Select(driver.findElement(By.id("categoriesSelect")));
		//Adding assert to view all categories from the list		
		String categories[]=new String[]{"All categories","Support","Administration","Loan"};
		//Getting categories values
		List<WebElement> category_details=options_category_type.getOptions();
		int i,size;
		size=category_details.size();
		System.out.println("--elements of size ---"+size);
		//Assert for multiple values present in dropdown
		for(i=0;i<size;i++){
			String actual=category_details.get(i).getText();
			System.out.println(actual);
			assertEquals(categories[i],actual,"Unable to view dropdown elements");
		}
		System.out.println("-------------------------------------");
		options_category_type.selectByValue("1");
	}

	@Test(priority=7,alwaysRun=true)
	public void select_all_btn(){
		//to check all messages
		driver.findElement(By.cssSelector("input[value='Select all']")).click();
		/*String expt="Select all";
		String actual=driver.findElement(By.cssSelector("input[value='Select all']")).getText();
		if(expt.equals(actual)){
			System.out.println("all are checked");
		}*/
		if(driver.findElement(By.name("messageId")).isSelected())
			System.out.println("Checked all messages");
		else 
		System.out.println("None selected");
	}
	
	@Test(priority=8,alwaysRun=true)//sr7
	public void select_none_btn(){
		//To de_select all check boxes
		driver.findElement(By.id("selectNoneButton")).click();
		if(driver.findElement(By.name("messageId")).isSelected())
			System.out.println("Checked all messages");
		else 
		System.out.println("None selected");
		/*String expt="Select none";
		String actual=driver.findElement(By.id("selectNoneButton")).getText();
		if(expt.equals(actual)){
			System.out.println("all are Unchecked");
		}*/
	}

	/*@Test(priority=9,alwaysRun=true)//sr8
	public void indox_to_trash(){
	//To send message from inbox  to trash
		driver.findElement(By.xpath("//img[@messageId='32']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expt="The messages were moved to trash";
		String actual=driver.switchTo().alert().getText();
		if(expt.equals(actual)){
			System.out.println("message deleted");
		}
		driver.switchTo().alert().accept();

	}*/

	@Test(priority=3,alwaysRun=true)
	public void search_inbox(){
		//Message box list click
		//To hold value which is selected
		options_inbox_type=new Select(driver.findElement(By.name("query(messageBox)")));
		options_inbox_type.selectByValue("INBOX");
		//search results display assert for inbox
		String search_expected="From";
		String actual=driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[4]")).getText();
		if(search_expected.equals(actual)){
			System.out.println("inbox results visible");
		}
	}

	//To view sent items sr9
	@Test(priority=9,alwaysRun=true)
	public void sent_select(){
		options_inbox_type=new Select(driver.findElement(By.id("messageBoxSelect")));
		options_inbox_type.selectByValue("SENT");
		//search results display assert for sent items
		String search_expected="To";
		String actual=driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[4]")).getText();
		if(search_expected.equals(actual)){
			System.out.println("sent results visible");
		}

	}

	//To view trash --sr10
	@Test(priority=10,alwaysRun=true)
	public void trash_select(){
		options_inbox_type=new Select(driver.findElement(By.id("messageBoxSelect")));
		options_inbox_type.selectByValue("TRASH");
		String search_expected="From/To";
		String actual=driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[4]")).getText();
		if(search_expected.equals(actual)){
			System.out.println("trash results visible");
		}

	}

	//Submit btn  page SEND  A NEW MESSAGE
	//To create new message
	@Test(priority=11,alwaysRun=true)
	public void new_msg() throws InterruptedException{

		String subject_text="Hi sanam"; //To compare entered login and name is same 
		int length=subject_text.length();
		boolean subject;
		driver.findElement(By.id("newButton")).click();
		//Assert
		String send_SubmitBtn="Send message";
		String actual_SubmitBtn=driver.findElement(By.className("tdHeaderTable")).getText();
		assertEquals(send_SubmitBtn,actual_SubmitBtn,"click on submit button");
		if(send_SubmitBtn.equals(actual_SubmitBtn)){
			System.out.println("send message page loaded");
		}
		member_category_sendTo=new Select(driver.findElement(By.id("sendToSelect")));
		member_category_sendTo.selectByValue("MEMBER");//selecting group
		//To insert values to send message 
		driver.findElement(By.id("memberUsername")).sendKeys("saa");
		Thread.sleep(1000);
		//Assertion need to be added comparing users with entered one
		String actual_memberName=driver.findElement(By.id("memberName")).getAttribute("value");
		String expected_memberName=driver.findElement(By.id("memberUsername")).getAttribute("value");
		assertEquals(actual_memberName,expected_memberName,"User login differ from member name");
		System.out.println(""+actual_memberName);
		if(length>1 | length<25){
			subject=true;}
		else{
			subject=false;}

		driver.findElement(By.id("subjectText")).sendKeys(subject_text);
		assertEquals(subject,true,"Subject should not exceed more than 25 charecters or subject not be empty");

		driver.findElement(By.cssSelector("#cke_contents_bodyText>iframe")).sendKeys("hi how r u");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		String expected="The message was successfully sent";
		String actual=driver.switchTo().alert().getText();
		assertEquals(expected,actual,"Message not delivered");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		//assert

	}

	//Module-1 submodule //Ui4
	@Test(priority=12,alwaysRun=true)
	public void grp_check() throws InterruptedException{

		driver.findElement(By.id("newButton")).click();
		member_category_sendTo=new Select(driver.findElement(By.id("sendToSelect")));
		member_category_sendTo.selectByValue("GROUP");//selecting group
		//To select and hold value which is selected
		Select options_category_type=new Select(driver.findElement(By.id("sendToSelect")));
		//Getting categories values
		List<WebElement> category_details=options_category_type.getOptions();
		int i,size;
		size=category_details.size();
		System.out.println("---elements of size-----"+size);
		//Assert for multiple values present in drop-down
		String categories[]=new String[]{"Member","Group(s)"};
		for(i=0;i<size;i++){
			String actual=category_details.get(i).getText();
			System.out.println(actual);
			assertEquals(categories[i],actual,"Unable to view dropdown elements");
		}

		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".multiDropDownText.multiDropDownLabel")).click();//click on group(s) drop drown
		driver.findElement(By.cssSelector(".multiDropDownText.multiDropDown>div>div>input[value='5']")).click();//to select value from dropdown
		driver.findElement(By.id("subjectText")).sendKeys("Message for groups");
		driver.findElement(By.cssSelector(".multiDropDownText.multiDropDownLabel")).click();//click to close the dropdown
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#cke_contents_bodyText>iframe")).sendKeys("hi how r u");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		String expected="The message was successfully sent";
		String actual=driver.switchTo().alert().getText();
		assertEquals(expected,actual,"Message not delivered");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

	}

}
/*

inbox results visible
message details displayed
send message page loaded
Messages:Home page displayed
--elements of size ---4
All categories
Support
Administration
Loan
-------------------------------------
Checked all messages
None selected
sent results visible
send message page loaded
saanvi
---elements of size-----2
Member
Group(s)
---elements of size-----3
Inbox
Sent items
Trash
----------------------------------
PASSED: login
PASSED: msg_start
PASSED: search_inbox
PASSED: sub_msg_display
PASSED: reply_btn
PASSED: appropriate_cat_msg
PASSED: select_all_btn
PASSED: select_none_btn
PASSED: sent_select
PASSED: trash_select
PASSED: new_msg
PASSED: grp_check
PASSED: validation*/

