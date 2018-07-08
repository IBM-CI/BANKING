package Banking_alerts;
import static org.testng.Assert.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class TestAlerts_History extends Member_alerts {

	@Test(priority=10,alwaysRun=true)
	public void alerts_history() 
	{
	//driver.findElement(By.xpath("//*[@id='menu2']/span[2]")).click();
		driver.findElement(By.xpath("//*[@id='submenu2.2']/span[2]")).click();

	}
	@Test(priority=11,alwaysRun=true)
	public void System_0r_member(){
		WebElement alertType=driver.findElement(By.id("typeSelect"));
		Select alertTypeSelected=new Select(alertType);
		List<WebElement> choose=alertTypeSelected.getOptions();
		WebElement systemOption=choose.get(0);
		boolean b=systemOption.isDisplayed();
		assertEquals(b, true,"member is not displayed");
		alertTypeSelected.selectByIndex(1);
		WebElement systemOption1=choose.get(1);
		boolean c=systemOption1.isDisplayed();
		assertEquals(c, true,"system is not displayed");

	}

	@Test(priority=12,alwaysRun=true)
	public void accept_From_Number(){
		driver.findElement(By.name("query(period).begin")).sendKeys("10022018");
		String fetchFromDate1=driver.findElement(By.cssSelector("input.date.small[name*=begin]")).getAttribute("value");
		System.out.println(fetchFromDate1);
		assertEquals(fetchFromDate1, "10/02/2018");
		driver.findElement(By.cssSelector("input.date.small[name*=begin]")).clear();
		driver.findElement(By.name("query(period).begin")).sendKeys("kaviyarasu");
		String fetchFromDate3=driver.findElement(By.cssSelector("input.date.small[name*=begin]")).getAttribute("value");
		System.out.println(fetchFromDate3);
		assertEquals(fetchFromDate3, "");
		
	}

	@Test(priority=13,alwaysRun=true)
	public void accept_From_Date(){
		driver.findElement(By.name("query(period).begin")).sendKeys("10/02/2018");
		String fetchFromDate2=driver.findElement(By.cssSelector("input.date.small[name*=begin]")).getAttribute("value");
		System.out.println(fetchFromDate2);
		assertEquals(fetchFromDate2, "10/02/2018");
		driver.findElement(By.cssSelector("input.date.small[name*=begin]")).clear();
	}
	@Test(priority=14,alwaysRun=true)
	public void date_From_check() throws ParseException{
		driver.findElement(By.name("query(period).begin")).sendKeys("10/02/2018");
		String date_From=driver.findElement(By.cssSelector("input.date.small[name*=begin]")).getAttribute("value");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyy");
		Date actual_From_Date=sdf.parse(date_From);
		Date current_Date=new Date();
		if(current_Date.compareTo(actual_From_Date)<0)
			assertEquals(actual_From_Date,"10/02/2018");
	}
//**************************************************************************************************
	@Test(priority=15,alwaysRun=true)
	public void accept_To_Number(){
		driver.findElement(By.name("query(period).end")).sendKeys("10022018");
		String fetchToDate1=driver.findElement(By.cssSelector("input.date.small[name*=end]")).getAttribute("value");
		System.out.println(fetchToDate1);
		assertEquals(fetchToDate1, "10/02/2018");
		driver.findElement(By.cssSelector("input.date.small[name*=end]")).clear();

		driver.findElement(By.name("query(period).end")).sendKeys("kaviyarasu");
		String fetchToDate3=driver.findElement(By.cssSelector("input.date.small[name*=end]")).getAttribute("value");
		System.out.println(fetchToDate3);
		assertEquals(fetchToDate3, "");
	}

	@Test(priority=16,alwaysRun=true)
	public void accept_To_Date(){

		driver.findElement(By.name("query(period).end")).sendKeys("10/02/2018");
		String fetchToDate2=driver.findElement(By.cssSelector("input.date.small[name*=end]")).getAttribute("value");
		System.out.println(fetchToDate2);
		assertEquals(fetchToDate2, "10/02/2018");
	}
	//*************************************
	@Test(priority=17,alwaysRun=true)
	public void date_To_check() throws ParseException{
		driver.findElement(By.name("query(period).end")).sendKeys("10/02/2018");
		String date_From=driver.findElement(By.cssSelector("input.date.small[name*=end]")).getAttribute("value");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyy");
		Date actual_From_Date=sdf.parse(date_From);
		Date current_Date=new Date();
		if(current_Date.compareTo(actual_From_Date)<0)
			assertEquals(actual_From_Date,"10/02/2018");
	}
	//********************************************************
	
	@Test(priority=18,alwaysRun=true)
	public void input_Using_Calender() {
driver.findElement(By.name("query(period).begin")).clear();		
driver.findElement(By.name("query(period).end")).clear();
driver.findElement(By.name("query(period).begin")).sendKeys("10/02/2017");
String fetchFromDate2=driver.findElement(By.cssSelector("input.date.small[name*=begin]")).getAttribute("value");
System.out.println(fetchFromDate2);
assertEquals(fetchFromDate2, "10/02/2017");
driver.findElement(By.name("query(period).end")).sendKeys("10/07/2018");
String fetchToDate2=driver.findElement(By.cssSelector("input.date.small[name*=end]")).getAttribute("value");
System.out.println(fetchToDate2);
assertEquals(fetchToDate2, "10/07/2018");
	}
	
	@Test(priority=19,alwaysRun=true)
	public void all_System_Alerts_Are_Displayed() {
		WebElement e1=driver.findElement(By.xpath(".//*[@id='typeSelect']"));
		Select s1=new Select(e1);
		s1.selectByIndex(0);
	driver.findElement(By.xpath(".//*[@id='tdContents']/table/tbody/tr[2]/td/form/table/tbody/tr[4]/td/input")).click();
	List <WebElement> list=driver.findElements(By.xpath(".//*[@id='tdContents']/table[2]/tbody/tr[2]/td/table"));
	for (WebElement row : list) {
		String s=row.getText();

	if(driver.findElement(By.xpath(".//*[@id='tdContents']/table[2]/tbody/tr[2]/td/table")).isDisplayed())
	{
		System.out.println("The page displays all the system alert in that date");
	}
	}
	}	
	
	
	@Test(priority=20,alwaysRun=true)
		public void all_Member_Alerts_Are_Displayed() {
			WebElement e1=driver.findElement(By.xpath(".//*[@id='typeSelect']"));
			Select s1=new Select(e1);
			s1.selectByIndex(1);
		   driver.findElement(By.xpath(".//*[@id='tdContents']/table/tbody/tr[2]/td/form/table/tbody/tr[4]/td/input")).click();

		   List <WebElement> list=driver.findElements(By.xpath(".//*[@id='tdContents']/table[2]/tbody/tr[2]/td/table"));
			for (WebElement row : list) {
		String		s=row.getText();

			if(driver.findElement(By.xpath(".//*[@id='tdContents']/table[2]/tbody/tr[2]/td/table")).isDisplayed())
			{
				System.out.println("The page displays all the member alerts in that date");
			}
		}
}


}




