package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageClass.AccountSummaryPage;
import pageClass.LoginPage;
import pageClass.PayBills;
import pageClass.WelcomePage;

public class TC_2_verifyAddPayee {
	
	public WebDriver driver;
	public WelcomePage wp;//declare at class level so it can be reused throughout class
	public LoginPage lp;
	public AccountSummaryPage asp;
	public PayBills pbp;
	
	
	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Steve\\eclipse-workspace\\zerobanking\\src\\test\\resources\\browser_drivers\\chromedriver.exe");
		driver = new ChromeDriver();// create chromedriver object
		driver.get("http://zero.webappsecurity.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wp=PageFactory.initElements(driver, WelcomePage.class);
		lp=PageFactory.initElements(driver, LoginPage.class);
		asp=PageFactory.initElements(driver, AccountSummaryPage.class);
		pbp=PageFactory.initElements(driver, PayBills.class);
	}
	
	@Test
	public void verifyLogin() {
		wp.clickSignInBtn();
		lp.doLogin("username", "password");
		asp.clickPayBillsTab();
		pbp.clickAddNewPayeeTab();
		pbp.enterPayeeInformation("Steve Clelland", "200 Robert Speck Parkway\nMississauga\nON L6R1K9", "123234434", "Natural Gas Utility");
		
	}
	
	

}
