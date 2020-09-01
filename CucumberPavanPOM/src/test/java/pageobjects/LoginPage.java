package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(id = "Email")
		@CacheLookup
		WebElement txtemial;
		
		@FindBy(id = "Password")
		@CacheLookup
		WebElement txtpwd;
	
		@FindBy(xpath = "//input[contains(@type,'submit')]")
		@CacheLookup
		WebElement btnlogin;
		
		@FindBy(xpath = "//a[contains(text(),'Logout')]")
		@CacheLookup
		WebElement linkLogout;
		
		public void setusername(String username)
		{
			txtemial.clear();
			txtemial.sendKeys(username);
		}
		
		public void setpassword(String password)
		{
			txtpwd.clear();
			txtpwd.sendKeys(password);
		}
		
		public void clicklogin()
		{
			btnlogin.click();
			
		}
		
		public void clicklogout()
		{
			linkLogout.click();
			
		}
}
