package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import busyqa.util.MonitoringMail;
import busyqa.util.TestConfig;
import busyqa.util.Xls_Reader;


public class BaseClass {

	/*
	 * Initialise Webdriver, properties, xls ,creating db connection, generating
	 * logs
	 */

	public static Properties config = new Properties();// declare properties file
	public static Xls_Reader excel = null;
	public static WebDriver driver = null;// intialize as null instead of chrome driver, firefox driver etc.
	public static Logger app_logs = Logger.getLogger("BaseClass");

	
	@BeforeSuite()//
	public static void init() throws IOException {  //can also be called set up.
		if (driver == null) {
			FileInputStream fis = new FileInputStream( //loads the config file in memory
			System.getProperty("user.dir") + "\\resources\\config.properties");//'user dir" is to allow for flexibility in where file is stored.
			config.load(fis);
			app_logs.debug("loading the config property file");

			// load excel file
			excel = new Xls_Reader(
			System.getProperty("user.dir") + "\\resources\\testdata.xlsx");
			app_logs.debug("loading the excel file");

			if (config.getProperty("browser").equals("chrome")) { //determines which browser to use based on what is in config.properties file
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naresh\\oxygen-workspace\\FrameworkDemo2\\executables\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "executables\\chromedriver.exe");

				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Naresh\\oxygen-workspace\\FrameworkDemo2\\executables\\geckodriver.exe");//C:\\Users\\Naresh\\oxygen-workspace\\FrameworkDemo2 can be replaced with user.dir + the rest of the path \\executables
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\Users\\Naresh\\oxygen-workspace\\FrameworkDemo2\\executables\\IEDriverServer.exe");
				driver = new EdgeDriver();
			}

			driver.get(config.getProperty("testsiteURL"));//gets URL from config.properties file
			driver.manage().window().maximize();

			// Global implicit Wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}
	}

	@AfterSuite()
	public static void tearDown() throws AddressException, MessagingException, IOException {
		MonitoringMail mail = new MonitoringMail();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Naresh\\oxygen-workspace\\busyqa\\test-output\\Logintest.html"));
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
				TestConfig.attachmentPath, TestConfig.attachmentName);
		driver.quit();
	}
}
