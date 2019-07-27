package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBills {


	WebDriver driver;
	
	@FindBy(id="pay_bills_tab")
	public WebElement payBillsTab;
	
	@FindBy (xpath="//a[contains(text(),'Add New Payee')]")
	public WebElement addPayeeTab;
	
	@FindBy (id="np_new_payee_name")
	public WebElement payeeName;
	
	@FindBy (id="np_new_payee_address")
	public WebElement payeeAddress;
	
	@FindBy (id="np_new_payee_account")
	public WebElement payeeAccount;
	
	@FindBy (id="np_new_payee_details")
	public WebElement payeeDetails;
	
	@FindBy (id="add_new_payee")
	public WebElement newPayeeBtn;
	
	
	public void clickPayBillsTab(){
		payBillsTab.click();
	}
	
	public void clickAddNewPayeeTab() {
		addPayeeTab.click();
		
	}
	public void clickAddBtn() {
		newPayeeBtn.click();
	}
	
	public void enterPayeeInformation(String Name,String Address, String Type, String Details) {
		
		payeeName.sendKeys(Name);
		payeeAddress.sendKeys(Address);
		payeeAccount.sendKeys(Type);
		payeeDetails.sendKeys(Details);
		newPayeeBtn.click();
	}
	

}
