package stepdefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageobjects.AddCustomerpage;
import pageobjects.LoginPage;
import pageobjects.SearchCutomerpage;

public class BaseClass {

	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerpage addcust;
	public SearchCutomerpage searchcustomer;
	public Properties configprop;
	
	public static String randomstring() {
		
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring);
	}

	
}
