package TestNG;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LocalSettings1_Test {
	int i,j=0;
	public WebDriver d;

	@Test(priority=1)

	public void f() throws InterruptedException {

		d.findElement(By.id("menu9")).click();

		//local settings

		d.findElement(By.id("submenu9.0")).click();
		//insert assert here
		try {
			String head1="Local settings";
			String headcompare1=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[1]/td[1]")).getText();
			assertEquals(headcompare1,head1);

		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Thread.sleep(1000);
		d.findElement(By.id("modifyButton")).click();
		Thread.sleep(1000);
		try {
			String head="Internationalization";
			String headCompare=d.findElement(By.cssSelector(".tdContentTableForms.innerBorder>fieldset:nth-child(2)>legend")).getText();
			assertEquals(headCompare, head);
		} catch (Exception e) {
			e.printStackTrace();
		}


		//edit ---------

		System.out.println(d.findElement(By.name("setting(language)")).isEnabled());
		System.out.println(d.findElement(By.name("setting(numberLocale)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(precision)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(highPrecision)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(decimalInputMethod)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(timeZone)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(datePattern)")).isEnabled()); 
		System.out.println(d.findElement(By.name("setting(timePattern)")).isEnabled());

		boolean a1=	d.findElement(By.name("setting(language)")).isEnabled();
		assertEquals(a1, true);
		boolean a2	=d.findElement(By.name("setting(numberLocale)")).isEnabled(); 
		assertEquals(a2, true);
		boolean a3=	d.findElement(By.name("setting(precision)")).isEnabled(); 
		assertEquals(a3, true);
		boolean a4=	d.findElement(By.name("setting(highPrecision)")).isEnabled();
		assertEquals(a4, true);
		boolean a5=	d.findElement(By.name("setting(decimalInputMethod)")).isEnabled(); 
		assertEquals(a5, true);
		boolean a6=d.findElement(By.name("setting(timeZone)")).isEnabled(); 
		assertEquals(a6, true);
		boolean a7=	d.findElement(By.name("setting(datePattern)")).isEnabled(); 
		assertEquals(a7, true);
		boolean a8=	d.findElement(By.name("setting(timePattern)")).isEnabled(); 
		assertEquals(a8, true);	

	}

	//for date format values display


	@Test( alwaysRun=true,priority=2)

	public void f1() throws InterruptedException{

		String verifylag="Language";
		String verifylag2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[1]/td[1]")).getText();
		assertEquals(verifylag2,verifylag);
		d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[1]/td[2]/select")).click();
		//d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(language)']")).click();
		WebElement laguage=d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(language)']"));
		Select lagname=new Select(laguage);
		List<WebElement> lagdetails=lagname.getOptions();
		d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(language)']")).click();
		//lagdetails.get(0).click();
		//String a1=lagdetails.get(0).getText();
		//System.out.println("changed r selected value"+a1);
		System.out.println("total no of languages"+lagdetails.size());
		String display[]=new String[lagdetails.size()];
		try {
			String display1[]={"English","Spanish","Czech","German","Greek","Dutch","Portuguese (Brazil)","Chinese (Simplified)","French","Japanese","Italian","Russian"};
			for(int i=0;i<lagdetails.size();i++)
			{
				display[i]=lagdetails.get(i).getText();
				System.out.println("laguage name is::"+lagdetails.get(i).getText());
				assertEquals(display[i],display1[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		//lagdetails.get(4).click();

	}

	//for number format values display

	@Test(alwaysRun=true,priority=3)

	public void f2(){

		String verifynumber="Number format";
		String verifynumber2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[2]/td[1]")).getText();
		assertEquals(verifynumber2,verifynumber);
		d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[2]/td[2]/select")).click();
		WebElement number=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[2]/td[2]/select"));
		Select numname=new Select(number);
		List<WebElement> numdetails=numname.getOptions();
		d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(numberLocale)']")).click();
		System.out.println("total number formats"+numdetails.size());
		String display4[]=new String[numdetails.size()];
		try {
			String display3[]={"1.234,56","1.234.56"};
			for(int i=0;i<numdetails.size();i++)
			{
				display4[i]=numdetails.get(i).getText();
				assertEquals(display4[i],display3[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}



	}



	//for numbers precision field values display

	@Test( alwaysRun=true,priority=4)

	public void f3(){

		String verifyprecision="Number precision";
		String verifypre2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[3]/td[1]")).getText();
		assertEquals(verifypre2,verifyprecision);
		d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[3]/td[2]/select")).click();
		WebElement number1=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[3]/td[2]/select"));
		Select prenum=new Select(number1);
		List<WebElement> predetails=prenum.getOptions();
		d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(precision)']")).click();
		predetails.get(3).click();
		//prenum.selectByIndex(2);
		String a8=predetails.get(2).getText();
		System.out.println("changed r selected value"+a8);
		System.out.println("total precision numbers :8");
		String display6[]=new String[predetails.size()];
		try {
			String display5[]={"0","1","2","3","4","5","6","7","8"};
			for(int i=0;i<predetails.size();i++)
			{
				display6[i]=predetails.get(i).getText();
				System.out.println("precision num format  is::"+predetails.get(i).getText());
				assertEquals(display6[i],display5[i]);
			}
			assertEquals(null,display5[7]);
			assertEquals(null,display5[8]);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}	

	}

	// high precision field

	@Test( alwaysRun=true,priority=5)

	public void f8() {


		String verifyhighpre="High precision";
		String verifyhighpre2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[4]/td[1]")).getText();
		assertEquals(verifyhighpre2,verifyhighpre);
		d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[4]/td[2]/select")).click();
		WebElement number2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[4]/td[2]/select"));
		Select prehigh=new Select(number2);
		List<WebElement> prehighdetails=prehigh.getOptions();
		d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(highPrecision)']")).click();
		prehighdetails.get(3).click();
		//prehigh.selectByIndex(2);
		//System.out.println("changed r selected value"+a3);
		System.out.println("total high precision numbers: 8");
		String display7[]=new String[prehighdetails.size()];
		try {
			String display8[]={"0","1","2","3","4","5","6","7","8"};
			for(int i=0;i<prehighdetails.size();i++)
			{
				display7[i]=prehighdetails.get(i).getText();
				System.out.println("high precision num format  is::"+prehighdetails.get(i).getText());
				assertEquals(display7[i],display8[i]);
			}
			assertEquals(null,display8[7]);
			assertEquals(null,display8[8]);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}	


	}


	// display decimal num input field

	@Test( alwaysRun=true,priority=6)

	public void f4(){
		String verifydec="Decimal numbers input method";
		String verifydec2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[5]/td[1]")).getText();
		assertEquals(verifydec2,verifydec);
		d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[5]/td[2]/select")).click();
		WebElement number3=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[5]/td[2]/select"));
		Select decnum=new Select(number3);
		List<WebElement> decdetails=decnum.getOptions();
		d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(decimalInputMethod)']")).click();
		decdetails.get(1).click();
		//decnum.selectByIndex(2);
		String a4=decdetails.get(1).getText();
		System.out.println("changed r selected value"+a4);
		System.out.println("total decimal numbers"+decdetails.size());
		String dis[]=new String[decdetails.size()];
		try {
			String dis1[]={"Right to left","Left to right"};
			for(int i=0;i<decdetails.size();i++)
			{
				dis[i]=decdetails.get(i).getText();
				System.out.println("decimal format  is::"+decdetails.get(i).getText());
				assertEquals(dis[i],dis1[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}	
	}

	//time zone field

	@Test( alwaysRun=true,priority=7)

	public void f5() throws InterruptedException{
		String tmzone="Time zone";
		String tmzone2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[6]/td[1]")).getText();
		assertEquals(tmzone2,tmzone);
		d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[6]/td[2]/select")).click();
		WebElement number4=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[6]/td[2]/select"));	
		Select tmnumco=new Select(number4);
		//tmnumco.selectByIndex(3);
		List<WebElement> tmdetails=tmnumco.getOptions();
		d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(timeZone)']")).click();
		tmdetails.get(3).click();
		String a5=tmdetails.get(3).getText();
		System.out.println("changed r selected value"+a5);

		//String hj=tmdetails.get(3).getText();
		//assertEquals(hj,str7);
		System.out.println("total time zone places"+tmdetails.size());
		for(int i=0;i<tmdetails.size();i++)
		{
			//tmdetails.get(i).click();
			//tmdetails.get(i).getText();

		}	
		//tmdetails.get(2).click();
		//String a5=tmdetails.get(2).getText();
	}


	//date format display
	@Test( alwaysRun=true,priority=8)

	public void f6(){

		String datezone="Date format";
		String datezone2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[7]/td[1]")).getText();
		assertEquals(datezone2,datezone);
		d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[7]/td[2]/select")).click();
		WebElement number5=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[7]/td[2]/select"));	
		Select datenumco=new Select(number5);
		List<WebElement> datedetails=datenumco.getOptions();
		d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(datePattern)']")).click();
		datedetails.get(2).click();
		//datenumco.selectByIndex(2);
		String a6=datedetails.get(3).getText();
		System.out.println("changed r selected value"+a6);
		System.out.println("total date formats:"+datedetails.size());
		String dis5[]=new String[datedetails.size()];
		try {
			String dis6[]={"YYYY/MM/DD","YYYY.MM.DD","YYYY-MM-DD","MM/DD/YYYY"};
			for(int i=0;i<datedetails.size();i++)
			{
				dis5[i]=datedetails.get(i).getText();
				System.out.println("date format  is::"+datedetails.get(i).getText());
				assertEquals(dis5[i],dis6[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}	


	}

	// display time format

	@Test( alwaysRun=true,priority=9)

	public void f7() throws InterruptedException{
		String timeformat="Time format";
		String timeformat2=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[8]/td[1]")).getText();
		assertEquals(timeformat2,timeformat);
		d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[8]/td[2]/select")).click();
		WebElement number6=d.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/fieldset[2]/table/tbody/tr[8]/td[2]/select"));	
		Select timefor=new Select(number6);
		List<WebElement> formatdetails=timefor.getOptions();
		d.findElement(By.cssSelector(".InputBoxEnabled[name='setting(timePattern)']")).click();
		formatdetails.get(2).click();
		//timefor.selectByIndex(2);
		String a7=formatdetails.get(3).getText();
		System.out.println("changed r selected value"+a7);
		System.out.println("total time format numbers are:"+formatdetails.size());
		String dis8[]=new String[formatdetails.size()];
		try {
			String dis7[]={"HH(24):MM:SS","HH(24):MM","HH(12):MM:SS AM/PM","HH(12):MM AM/PM"};
			for(int i=0;i<formatdetails.size();i++)
			{
				dis8[i]=formatdetails.get(i).getText();
				System.out.println("time format  is::"+formatdetails.get(i).getText());
				assertEquals(dis8[i],dis7[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}	
		
	}
	
	@Test( alwaysRun=true,priority=10)
		public void f9() throws InterruptedException {

			d.findElement(By.name("setting(language)")).click();
			WebElement language=d.findElement(By.name("setting(language)"));

			Select languagename = new Select(language);
			d.findElement(By.name("setting(language)")).click();
			languagename.selectByVisibleText("English");
			String s1=	d.findElement(By.name("setting(language)")).getAttribute("value");
			
			System.out.println("changed values are:");
			System.out.println(s1);


			d.findElement(By.name("setting(numberLocale)")).click();
			WebElement numberformat = d.findElement(By.name("setting(numberLocale)"));
			Select number=new Select(numberformat);



			d.findElement(By.name("setting(numberLocale)")).click();
			number.selectByIndex(1);
			String s2=	d.findElement(By.name("setting(numberLocale)")).getAttribute("value");
			System.out.println(s2);
			d.findElement(By.name("setting(precision)")).click();
			WebElement precision=d.findElement(By.name("setting(precision)"));
			Select precisionnumber=new Select(precision);
			d.findElement(By.name("setting(precision)")).click();
			precisionnumber.selectByIndex(5);
			String s3=	d.findElement(By.name("setting(precision)")).getAttribute("value");
			System.out.println(s3);


			d.findElement(By.name("setting(highPrecision)")).click();
			WebElement highprecision=	d.findElement(By.name("setting(highPrecision)"));
			Select precisionhigh= new Select(highprecision);
			d.findElement(By.name("setting(highPrecision)")).click();
			precisionhigh.selectByIndex(5);
			String s4=	d.findElement(By.name("setting(highPrecision)")).getAttribute("value");
			System.out.println(s4);

			d.findElement(By.name("setting(decimalInputMethod)")).click();
			WebElement decimal= d.findElement(By.name("setting(decimalInputMethod)"));
			Select decimalInput=new Select(decimal);
			d.findElement(By.name("setting(decimalInputMethod)")).click();
			decimalInput.selectByIndex(1);
			String s5= d.findElement(By.name("setting(decimalInputMethod)")).getAttribute("value");
			System.out.println(s5);

			d.findElement(By.name("setting(timeZone)")).click();
			WebElement timezone=d.findElement(By.name("setting(timeZone)"));
			Select zone=new Select(timezone);
			d.findElement(By.name("setting(timeZone)")).click();
			zone.selectByIndex(5);
			String s6= d.findElement(By.name("setting(timeZone)")).getAttribute("value");
			System.out.println(s6);

			d.findElement(By.name("setting(datePattern)")).click();
			WebElement date=d.findElement(By.name("setting(datePattern)"));
			Select pattern=new Select(date);
			d.findElement(By.name("setting(datePattern)")).click();
			pattern.selectByIndex(3);
			String s7= d.findElement(By.name("setting(datePattern)")).getAttribute("value");
			System.out.println(s7);

			d.findElement(By.name("setting(timePattern)")).click();
			WebElement time=d.findElement(By.name("setting(timePattern)"));
			Select patternTime=new Select(time);
			d.findElement(By.name("setting(timePattern)")).click();
			patternTime.selectByIndex(3);
			String s8=	 d.findElement(By.name("setting(timePattern)")).getAttribute("value");
			System.out.println(s8);


			d.findElement(By.id("saveButton")).click();
			d.switchTo().alert().accept();
			
			System.out.println("updated values are:");

			String s11=	d.findElement(By.name("setting(language)")).getAttribute("value");
			System.out.println(s11);
			assertEquals(s1, s11);

			String s22=	d.findElement(By.name("setting(numberLocale)")).getAttribute("value");
			System.out.println(s22);
			assertEquals(s2, s22);

			String s33=	d.findElement(By.name("setting(precision)")).getAttribute("value");
			System.out.println(s33);
			assertEquals(s3, s33);

			String s44=	d.findElement(By.name("setting(highPrecision)")).getAttribute("value");
			System.out.println(s44);
			assertEquals(s4, s44);
			String s55= d.findElement(By.name("setting(decimalInputMethod)")).getAttribute("value");
			System.out.println(s55);
			assertEquals(s5, s55);
			String s66= d.findElement(By.name("setting(timeZone)")).getAttribute("value");
			System.out.println(s66);
			assertEquals(s6, s66);
			String s77= d.findElement(By.name("setting(datePattern)")).getAttribute("value");
			System.out.println(s77);
			assertEquals(s7, s77);
			String s88=	 d.findElement(By.name("setting(timePattern)")).getAttribute("value");
			System.out.println(s88);
			assertEquals(s8, s88);

			System.out.println("values are updated successfully");
			d.findElement(By.id("modifyButton")).click();

Thread.sleep(1000);
	}


	@BeforeTest
	public void beforeTest() {


		//login
		d=new FirefoxDriver();
		d.get("http://localhost:8585/do/login");
		d.manage().window().maximize();

		//login
		d.findElement(By.id("cyclosUsername")).sendKeys("admin");
		d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
	    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click();
	    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click();
	    d.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();
	    
		d.findElement(By.xpath("//*[@type='submit']")).click();
	}

	

}

