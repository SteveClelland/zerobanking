package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {
	
	public WebDriver driver;
	
	@FindBy(id="signin_button") //locates the sign in button element by id.
	public WebElement signInBtn;// creates signInBtm object
	
	//create a method to click on sign in button
	public void clickSignInBtn(){
		
		signInBtn.click();
	}

		
	}


