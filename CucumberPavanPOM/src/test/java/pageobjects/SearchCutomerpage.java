package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCutomerpage {

	public WebDriver driver;
	WaitHelper waithelper;

	public SearchCutomerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		
	}
	
	@FindBy(how=How.ID, using = "SearchEmail")
	@CacheLookup
	public WebElement txtemail;
	
	@FindBy(how=How.ID, using = "SearchFirstName")
	@CacheLookup
	public WebElement txtFirstname;
	
	@FindBy(how=How.ID, using = "SearchLastName")
	@CacheLookup
	public WebElement txtLastname;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'search-customers')]")
	@CacheLookup
	public WebElement btnsearch;
	
	@FindBy(how=How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	public WebElement searchresults;
	
	@FindBy(how=How.XPATH, using = "//table[@id='customers-grid']")
	@CacheLookup
	public WebElement table;
	
	@FindBy(how=How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	public List<WebElement> tablerows;
	
	@FindBy(how=How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	public List<WebElement> tablecolumns;
	
	public void setemail(String email)
	{
		waithelper.waitforelement(txtemail, 40);
		txtemail.clear();
		txtemail.sendKeys(email);
		
	}
	
	public void setfirstname(String firstname)
	{
		waithelper.waitforelement(txtFirstname, 40);
		txtFirstname.clear();
		txtFirstname.sendKeys(firstname);
	}
	
	public void setlastname(String lastname)
	{
		waithelper.waitforelement(txtLastname, 40);
		txtLastname.clear();
		txtLastname.sendKeys(lastname);
	}
	
	public void clicksearch() {
		btnsearch.click();
		waithelper.waitforelement(btnsearch, 40);
	}
	
	public int getnoofrows() {
		
		return (tablerows.size());
	}
	
	public int getnoofcol() {
		
		return (tablecolumns.size());
		}
	
	public boolean searchcustomerbyemail(String email)
	{
		boolean flag = false;
		for(int i=1; i<=getnoofrows(); i++)
		{
			String emaild = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emaild);
			if(emaild.equalsIgnoreCase(email)) {
				flag = true;
			}
		}
		
		return flag;
		
	}
	
	public boolean searchcustomerbyname(String Name)
	{
		boolean flag = false;
		for(int i=1; i<=getnoofrows(); i++)
		{
			String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			String names[] = name.split(" ");
			if(names[0].equalsIgnoreCase("Victoria") && names[1].equalsIgnoreCase("Terces")) {
				flag = true;
			}
		}
		
		return flag;
		
	}
	
	
}
