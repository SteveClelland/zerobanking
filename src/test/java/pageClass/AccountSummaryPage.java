package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage {
	
	WebDriver driver;
	
	@FindBy(id="pay_bills_tab")
	public WebElement payBillsTab;
	
	public void clickPayBillsTab() {
		payBillsTab.click();
	}
	
	

}
