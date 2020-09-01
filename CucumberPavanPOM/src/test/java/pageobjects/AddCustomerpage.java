package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerpage {

	public WebDriver driver;

	public AddCustomerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By linkcustomers_menu = By.xpath("//a[@href='#']//span[contains(.,'Customers')]");
	By linkcustomers_menuitem = By.xpath("(//span[@class='menu-item-title'][contains(.,'Customers')])[1]");
	By btnaddnew = By.xpath("//a[@class='btn bg-blue'][contains(.,'Add new')]");

	By txtemail = By.xpath("//input[contains(@type,'email')]");
	By txtpassword = By.xpath("//input[contains(@id,'Password')]");

	By txtcustomerrole = By.xpath("(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]");

	By listitemadministrator = By.xpath("//span[@unselectable='on'][contains(.,'Administrators')]");
	By listitemregistered = By.xpath("//span[@unselectable='on'][contains(.,'Registered')]");
	By listitemGuests = By.xpath("//span[@unselectable='on'][contains(.,'Guests')]");
	By listitemVendors = By.xpath("//span[@unselectable='on'][contains(.,'Vendors')]");
	By listitemModerators  = By.xpath("//span[@unselectable='on'][contains(.,'Forum Moderators')]");

	By mgrOfVendor = By.xpath("//label[contains(.,'Manager of vendor')]");
	By maleGender = By.xpath("//input[contains(@id,'Gender_Male')]");
	By femaleGender = By.xpath("//label[contains(.,'Female')]");

	By fristname = By.xpath("//input[@id='FirstName']");
	By lastname = By.xpath("//input[@id='LastName']");

	By dob = By.xpath("//input[contains(@id,'DateOfBirth')]");

	By cmpname = By.xpath("//input[contains(@id,'Company')]");

	By admincomment = By.xpath("//textarea[contains(@id,'AdminComment')]");

	By btnsave = By.xpath("//button[@name='save']");

	//Action methods

	public void clickOnCustomermenu() {
		driver.findElement(linkcustomers_menu).click();
	}

	public void clickOnCustomerMenuItem() {
		driver.findElement(linkcustomers_menuitem).click();

	}

	public void clickOnAddNew() {
		driver.findElement(btnaddnew).click();
	}

	public void setemail(String email) {
		driver.findElement(txtemail).sendKeys(email);;
	}

	public void sendpassword(String password) {
		driver.findElement(txtpassword).sendKeys(password);;
	}

	public void setcustomerroles(String role) {

		WebElement Listitem;
		if(role.equals("Vendors")) {
			Listitem =driver.findElement(listitemVendors);
		}
		else if(role.equals("Registered")) {
			Listitem = driver.findElement(listitemregistered);
		}

		else if(role.equals("Administrators")) {
			Listitem = driver.findElement(listitemadministrator);
		}
		else  {
			Listitem = driver.findElement(listitemGuests);
		}
		Listitem.click();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Listitem);

	}

	public void setmanagerofVendor(String Value) {
		Select drp = new Select(driver.findElement(mgrOfVendor));
		drp.deselectByVisibleText(Value);

	}

	public void setgender(String gender)
	{
		if(gender.equals("Male"))
		{
			driver.findElement(maleGender).click();
		}
		else if(gender.equals("Female"))
		{
			driver.findElement(femaleGender).click();
		}
		else
			driver.findElement(maleGender).click();

	}

	public void setfirstname(String fname){
		driver.findElement(fristname).sendKeys(fname);
	}

	public void setlastname(String lname){
		driver.findElement(lastname).sendKeys(lname);
	}

	public void setDOB(String txtdob){
		driver.findElement(dob).sendKeys(txtdob);
	}


	public void setcompanyname(String comname){
		driver.findElement(cmpname).sendKeys(comname);
	}

	public void setAdmincontent(String content){
		driver.findElement(admincomment).sendKeys(content);
	}

	public void clickonsave(){
		driver.findElement(btnsave).click();
	}

	public String getPageTitle() {
		
		return driver.getTitle();
	}

}
