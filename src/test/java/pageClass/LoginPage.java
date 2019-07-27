package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;

	
	@FindBy (id="user_login")
	public WebElement userNameTextBox;
	
	@FindBy (id="user_password")
	public WebElement passwordTextBox;
	
	@FindBy (name="submit")
	public WebElement submitBtn;

	//use one method
	public void doLogin(String myUsername, String myPassword) {
		userNameTextBox.sendKeys(myUsername);
		passwordTextBox.sendKeys(myPassword);
		submitBtn.click();
	}

}
