package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//Features/LoginOrangeHRM.feature",
		//features = {".//Features/PIM_Add_Employee.feature",".//Features/Valid_Invalid_Credetial.feature"},
		glue = "StepDefination",
		dryRun = false,
		monochrome = true,
		//tags="@Sanity",
		//tags="@Sanity or @Regression",// feature file me 2 no me se 1bbi likha ho to execute honge
		//tags="@Sanity and @Regression",// feature file me 2 no tag add kiye ho tb execute honga
		//tags="@Sanity and not @Regression",// only execute Sanity scenario and skip Regression
		//plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class Run extends AbstractTestNGCucumberTests {

}
