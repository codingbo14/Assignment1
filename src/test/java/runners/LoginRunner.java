package runners;



	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	//features = "src\\test\\resources\\features",
			features ="classpath:features",

			glue = "steps", 
			tags = {"@Bankcashscenario1"},
			monochrome = true,
			dryRun=false,
			plugin = { 

	                    "pretty",
	                  "html:target/reports/Cucumber.html",
	                  "json:target/reports/Cucumber.json"
	              }
	              )
	public class LoginRunner {

}
