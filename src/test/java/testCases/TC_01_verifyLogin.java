package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageClass.LoginPage;
import pageClass.WelcomePage;

public class TC_01_verifyLogin {
	
	public WebDriver driver;
	public WelcomePage wp;//declare at class level so it can be reused throughout class
	public LoginPage lp;
	
	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Steve\\eclipse-workspace\\zerobanking\\src\\test\\resources\\browser_drivers\\chromedriver.exe");
		driver = new ChromeDriver();// create chromedriver object
		driver.get("http://zero.webappsecurity.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wp=PageFactory.initElements(driver, WelcomePage.class);
		lp=PageFactory.initElements(driver, LoginPage.class);//added a comment to try GIT
	}
	
	@Test
	public void verifyLogin() throws InterruptedException {
		//create a welcome page object
		//wp = new WelcomePage();//DON'T create new object here. Use page factory instead
		//lp=new LoginPage();//DON'T create object of loginPage.java. USE page factory instead
		wp.clickSignInBtn();//use click method from WelcomePage.java
		Thread.sleep(3000);
		lp.doLogin("username", "password");//passing these values into method on loginPage
		Thread.sleep(5000);


		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}

}
