package StepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;

import PageObject.LoginPage;
import Utilities.ReadConfig;

//Parent Class
public class BaseClassT {
	public String OrangeUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;
	public LoginPage obj;
	public static Logger log;
	public ReadConfig readConfig;
	
	// used for Generate random String as password/userName/alphabet inside text box
	// text pass me koi b random value pass karne ke liye used below method
    public String generateRandomValue()
    {
    	return RandomStringUtils.randomAlphabetic(5);
    }
}
