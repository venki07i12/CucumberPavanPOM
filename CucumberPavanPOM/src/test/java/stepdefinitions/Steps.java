package stepdefinitions;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.AddCustomerpage;
import pageobjects.LoginPage;
import pageobjects.SearchCutomerpage;


public class Steps extends BaseClass {

	@Before
	public void setup() throws Exception
	{
		configprop = new Properties();
		FileInputStream configpropfile = new FileInputStream("Config.properties");
		configprop.load(configpropfile);
		
		String br = configprop.getProperty("browser");
		if(br.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		
		else if(br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		else if(br.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", configprop.getProperty("iedriver"));
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
	}
	
	
	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    lp = new LoginPage(driver);
	  }

	@When("User open URL \"(.*)\"")
	public void user_open_url(String url) {
	   driver.get(url);
	}

	@And("User enters email as \"(.*)\" and password as \"(.*)\"")
	public void user_enters_email_as_and_password_as(String email, String password) {
	   lp.setusername(email);
	   lp.setpassword(password);
	}


	@When("Click on login")
	public void click_on_login() throws Exception {
		lp.clicklogin();
		Thread.sleep(3000);
	}


	@Then("Page Title should be \"(.*)\"")
	public void page_title_should_be(String title) {
	   if(driver.getPageSource().contains("Login was unsuccessful"))   {
		   driver.close();
		   Assert.assertTrue(false);
	   }else {
		   Assert.assertEquals(title, driver.getTitle());
	   }
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws Exception {
		 lp.clicklogout();
		 Thread.sleep(3000);
	}



	@And("Close browser")
	public void close_browser() {
	   driver.close();
	}

	//Customer feature Step definition.............
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addcust = new AddCustomerpage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());
		
	}

	@When("User Click on customers Menu")
	public void user_click_on_customers_menu() throws Exception {
		Thread.sleep(3000);
	   addcust.clickOnCustomermenu();
	}

	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() throws Exception {
		Thread.sleep(3000);
	   addcust.clickOnCustomerMenuItem();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws Exception {
		addcust.clickOnAddNew();
		Thread.sleep(3000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	   String email = randomstring()+"@gmail.com";
	   addcust.setemail(email);
	   addcust.sendpassword("test123");
	   addcust.setfirstname("venkatesh");
	   addcust.setlastname("ippa");
	   addcust.setgender("Male");
	   addcust.setcompanyname("Legato");
	  
		/*
		 * addcust.setcustomerroles("Guests"); 
		 * addcust.setmanagerofVendor("Vendor 2");
		 *  addcust.setDOB("25/08/2020");
		 */
	   addcust.setAdmincontent("welcome to testing");
	   
	}

	@When("Click on save button")
	public void click_on_save_button() throws Exception {
		addcust.clickonsave();
		Thread.sleep(3000);
	}

	@Then("User can view confirmation message \"(.*)\"")
	public void user_can_view_confirmation_message(String string) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
	    		.contains("The new customer has been added successfully"));
	    
	}
	
	//Steps for searching a customer using email ID.............
	
	@When("Enter customer email")
	public void enter_customer_email() {
	    
		searchcustomer = new SearchCutomerpage(driver);
		searchcustomer.setemail("victoria_victoria@nopCommerce.com");
		
	}

	@When("Click on search button")
	public void click_on_search_button() throws Exception {
	    searchcustomer.clicksearch();
	    Thread.sleep(5000);
	}

	@Then("user should found email in the search button")
	public void user_should_found_email_in_the_search_button() {
	   boolean status = searchcustomer.searchcustomerbyemail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	
	//Steps for searching a customer using Firstname and Lastname.............
	
	@When("Enter customer Firstname")
	public void enter_customer_firstname() {
		searchcustomer = new SearchCutomerpage(driver);
		searchcustomer.setfirstname("Victoria");
	}

	@When("Enter customer Lastname")
	public void enter_customer_lastname() {
	    searchcustomer.setlastname("Terces");
	}

	@Then("user should found name in the search button")
	public void user_should_found_name_in_the_search_button() {
	    boolean status =  searchcustomer.searchcustomerbyname("Victoria Terces");
		Assert.assertEquals(true, status);
	}

	
}
