package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class LoginHRMOrange extends BaseClassT {
//	public String OrangeUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//	public WebDriver driver;
//	LoginPage obj;

	@Before()
	public void setupAllTest() {


		// read properties file
		readConfig = new ReadConfig();
		
		// initialise logger
		log = LogManager.getLogger("LoginHRMOrange");
		System.out.println("Setup-Sanity method executed..");


		// used to read multiple browser
		String browser = readConfig.getBrowser();
		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Setup2 executed...");

	}

	@Given("Launch the Chrome Browser and login Orange HRM")
	public void launch_the_chrome_browser_and_login_orange_hrm() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj = new LoginPage(driver);
		log.info("Setup2 executed...");
	}

	@When("Open the URL_Orange HRM")
	public void open_the_url_orange_hrm() {
		driver.get(OrangeUrl);
		log.info("Launch Chrome Browser...");
	}

	@And("Enter the Username")
	public void enter_the_username() {
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		log.info("Enter UserName Details...");

	}

	@And("Enter the Password")
	public void enter_the_password() {
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		log.info("Enter Password Details...");
	}

	@And("Enter the Username as {string}")
	public void enter_the_username_as(String UserID) {
		obj.setUserName(UserID);
		log.info("Enter User Details...");

	}

	@And("Enter the Password as {string}")
	public void enter_the_password_as(String passId) {
		obj.SetPassword(passId);
		log.info("Enter User Details...");
	}

	@And("Clock on Login")
	public void clock_on_login() {
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
		log.info("Click login Details...");
	}

	@Then("Verify the PageTitle")
	public void verify_the_page_title() {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals("OrangeHRM", PageTitle);
		log.info("Verify Details...");
	}

	@And("Navigate to Home Page")
	public void navigate_to_home_page() {
		obj.clickLogoutdropdown();
		log.info("Enter Home page Details...");
	}

	@And("Click on Logout")
	public void click_on_logout() {
		obj.clickOnLogoutBtn();
		log.info("Logout Details...");
	}

	@Then("click on PIM Module")
	public void click_on_pim_module() {
		obj.clickOnPIMmodule();
		log.info("Click PIM Module Details...");

	}

	@And("click on Add Employee")
	public void click_on_add_employee() {
		obj.clickOnAddEmployee();
		log.info("Click Employee Details...");
	}

	@And("Enter First Name")
	public void enter_first_name() {
		// obj.SetFirstName("Rahul");
		obj.SetFirstName(generateRandomValue() + "@gmail.com");
		// obj.SetFirstName(generateRandomValue());
		log.info("Enter User FirstName Details...");

	}

	@And("Enter Middle Name")
	public void enter_middle_name() {
		// obj.SetMiddleName("Laxman");
		// obj.SetFirstName(generateRandomValue() +"ICICI Bank");
		obj.SetMiddleName(generateRandomValue());
		log.info("Enter User MiddleName Details...");
	}

	@And("Enter Last Name")
	public void enter_last_name() {
		obj.SetLastName("Harinkhede");
		log.info("Enter User LastName Details...");
	}

	@And("click on Save Btn")
	public void click_on_save_btn() {
		obj.clickOnSaveBtn();
		System.out.println("Details Saved Succcessfully");
		log.info("Click on Save Button ");
	}

	@And("click on Employee Employee List")
	public void click_on_employee_employee_list() {
		obj.clickOnEmployeeList();
		log.info("Click on Employee List..");
	}

	@Then("Enter Employee Name")
	public void enter_employee_name() {
		obj.SetSearchEmployeeName("Rahul");
		log.info("Enter User Search FirstName Details...");
	}

	@Then("click on Search Btn")
	public void click_on_search_btn() {
		obj.clickOnSearchBtn();
		log.info("Click on Search button...");
	}

	@And("Enter the Valid Username")
	public void enter_the_valid_username() {
		obj.setUserName("Admin");
		log.info("Enter Valid Username Details...");
	}

	@And("Enter the Valid Password")
	public void enter_the_valid_password() {
		obj.SetPassword("admin123");
		log.info("Enter Valid Password Details...");
	}

	@And("Enter the InValid Username")
	public void enter_the_in_valid_username() {
		obj.setUserName("Test123");
		log.info("Enter InValid  UserName Details...");
	}

	@And("Enter the InvalidPassword")
	public void enter_the_invalid_password() {
		obj.SetPassword("admin432");
		log.info("Enter InValid Passwod Details...");
	}

	@Then("Velidate the Invalid Credential message")
	public void velidate_the_invalid_credential_message() {
		String message_expected = "Invalid credentials";
		String message_actual = driver
				.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();

		Assert.assertEquals(message_expected, message_actual);
		log.info(" Validate the Valid and Invalid Details...");

	}

	@And("Enter the Username {string}")
	public void enter_the_username(String username) {
		obj.setUserName(username);
		log.info("Enter Valid Details...");

	}

	@And("Enter the Password {string}")
	public void enter_the_password(String password) {
		obj.SetPassword(password);
		log.info("Enter Valid Details...");
	}

	@And("Close Browser")
	public void close_browser() {
		driver.close();
		log.info("Enter Close Button...");
	}

//	@Before
//	public void BeforeStartExecute() {
//		// driver.close();
//		System.out.println("Excecute Before start test Scenario");
//	}
//
//	@AfterStep
//	public void AfterExecute() {
//		// driver.close();
//		System.out.println("Excecute after complete all test Scenario");
//	}
//
//	@After("@Sanity")
//	public void Allwindowteardown1() {
//		driver.quit();
//	}
//
//	@After("@Regression")
//	public void Allwindowteardown2() {
//		driver.quit();
//	}

	/*
	@After
	public void Teardown1(Scenario screenshot) {
		// driver.close();
		System.out.println("Excecute Scenario: Teardown1 order maintain After Hook reverse order as 3,2,1");
		if (screenshot.isFailed() == true) {

			String SCfilePath = "C:\\Users\\rahul\\git\\repository\\RestAssuredTesting\\ScreenShot\\login.png";
			TakesScreenshot tk = (TakesScreenshot) driver;
			File source = tk.getScreenshotAs(OutputType.FILE);
			File Dest = new File(SCfilePath);
			log.info("Capture the Screenshot ...");
			try {
				FileUtils.copyFile(source, Dest);

			} catch (IOException e) {

				e.printStackTrace();
			}  
		}
	} */
	
	
	 // used to all pass as well as fail test screenshot capture in extend report-IMP All pass & fail SC Capture
	  @AfterStep
	public void addScreenshot(Scenario scenario) {
		
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			//attach image file report (data,media type, name of attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
	} 
	/*
	  @AfterStep // used only capture failed test cases
		public void addScreenshot(Scenario scenario) {
		  // used to capture only failed test cases
			if(scenario.isFailed()) {
				
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				//attach image file report (data,media type, name of attachment)
				scenario.attach(screenshot, "image/png", scenario.getName());
		}
	  }
	*/
}
