package com.mercury.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class MR {
	WebDriver driver;
	
	// Application launch method//
	public void browserMercuryAppLaunch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(3000);
		
	}
	
	// Application close method//
	public void browserClose()
	{
		driver.close();
	}	
	
	// login method Dynamically//
		public void loginDynamic(String uname, String passwrd) throws InterruptedException  
		{
			
			//WebElement uName = driver.findElement(By.name("userName"));
			WebElement uName = driver.findElement(By.xpath("//input[@name='userName']"));
			uName.sendKeys(uname);
				
			WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
			pass.sendKeys(passwrd);
			
			Thread.sleep(3000);
			WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
			login.click();
			Thread.sleep(3000);
			
			}
	
	// login method with Sikuli//
	public void loginSikuli() throws FindFailed 
	{
		Screen s = new Screen();	
		s.type("./Sikuli/uname.PNG", "dasd");
		s.type("./Sikuli/passwrd.PNG", "dasd");
		//Pattern btnSignin = new Pattern("./Sikuli/signin.PNG"); 		
		//s.click(btnSignin);
		s.click("./Sikuli/signin.PNG");
		}
	
	//login with robot
	
	public void loginRobot() throws AWTException, InterruptedException 
	{
		Robot r1 = new Robot();
		int count = 1;
		while(count<=12)
		{

			r1.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			count++;
		}
		
		r1.keyPress(KeyEvent.VK_D);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyPress(KeyEvent.VK_S);
		r1.keyPress(KeyEvent.VK_D);
		
		r1.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(1000);
		
		r1.keyPress(KeyEvent.VK_D);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyPress(KeyEvent.VK_S);
		r1.keyPress(KeyEvent.VK_D);
		

		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		r1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
	}		
		
	
	// login verification//
	
		public void loginverify()
		{
			String actTitle = "Welcome: Mercury Tours";
			String expTitle = driver.getTitle();
			
			System.out.println(expTitle);
			
			if(actTitle.equals(expTitle))
			{
			 System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
		}
	
		// login with returntype Boolean		
		public boolean login()  
		{
			String actTitle = "Welcome: Mercury Tours";
			String expTitle = driver.getTitle();
			
			if(actTitle.equals(expTitle))
			{
			    return true;
			}
			else
			{
				return false;
			}
		}
			
	
	// register click method//
	public void RegisterClick() throws InterruptedException
	{
		WebElement regclk = driver.findElement(By.xpath("//a[@href='mercuryregister.php']"));
		regclk.click();
		Thread.sleep(3000);
	}
	
	//Registration form fill up//
	public void Register() throws InterruptedException
	{
		WebElement fname = driver.findElement(By.xpath("//input[@name='firstName']"));
		fname.sendKeys("Suchandra");
		
		WebElement lname = driver.findElement(By.xpath("//input[@name='lastName']"));
		lname.sendKeys("Saha");
		
		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("98312345677");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='userName']"));
		email.sendKeys("saha.suchandra@gmail.com");
		
		WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
		address.sendKeys("patuli");
		
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("kolkata");  
		
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		state.sendKeys("West Bengal"); 
		
		WebElement pcode = driver.findElement(By.xpath("//input[@name='postalCode']"));
		pcode.sendKeys("700094");
		
		/*Select drpcountry = new Select(driver.findElement(By.xpath("//input[@name='country']")));
		drpcountry.selectByVisibleText("INDIA");*/
		
		WebElement uemail = driver.findElement(By.xpath("//input[@name='email']"));
		uemail.sendKeys("sahas");
		
		WebElement upass = driver.findElement(By.xpath("//input[@name='password']"));
		upass.sendKeys("password");
		
		WebElement ucpass = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		ucpass.sendKeys("password");
		
		Thread.sleep(2000);
		
		}
	
	//Registration Submit click//
	public void submitclick() throws InterruptedException
	{
		WebElement subclick = driver.findElement(By.xpath("//input[@name='register']"));
		subclick.click();
		Thread.sleep(2000);
	
	}
	
	public void autoid() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://imgbb.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement up = driver.findElement(By.xpath("//a[@class='btn btn-big blue']"));
		up.click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("./autoid/auto_img_open.exe");
		Thread.sleep(3000);		
		
	}
	public void loginwithproperty() throws IOException, InterruptedException
	{
		File file = new File("./testdata/data.properties");
		FileInputStream fileinput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileinput);
		 Thread.sleep(2000);
		 
		 WebElement user = driver.findElement(By.xpath("//input[@name='userName']"));
		user.sendKeys(prop.getProperty("username"));
				
			WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
			pass.sendKeys(prop.getProperty("password"));
			
			Thread.sleep(3000);
			
			WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
			login.click();
			Thread.sleep(3000);
		 
		 
	}
	 
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		