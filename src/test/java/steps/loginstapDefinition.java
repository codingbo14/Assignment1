package steps;



	import org.openqa.selenium.support.PageFactory;

	import io.cucumber.java.After;
	
	
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.Loginpage;
	import pages.TestBase;
	public class loginstapDefinition extends TestBase{
	Loginpage loginpage;

	//@Before
		//public void setup() {
		//	initDriver();
		//	loginpage = PageFactory.initElements(driver, loginpage.class);
		//}

	@Given("User is on the techfios login page")
		public void user_is_on_the_techfios_login_page() {
			initDriver();
			driver.get("https://techfios.com/billing/?ng=login/");
		}

	@Then("User should land on Dashboard page")
		public void user_should_land_on_Dashboard_page() {
			String expectedTitle = "Dashboard- iBilling";
			String actualTitle = loginpage.getTitle();
			Assert.assertEquals(expectedTitle,actualTitle);
			
		}
	/// *@When("User enters the {string} in the {string} field")
	// public void user_enters_username_as(String logindata, String field) {
	// if (field.equalsIgnoreCase("username")) {
	// loginpage.enterUserName(logindata);
	// } else if (field.equalsIgnoreCase(" password")) {
	// loginpage.enterPassword(logindata);
	// } else {system.out.println("unable to find field:" + field)
	
	
		
	@When("User enters the {string} in the {string} field")
			public void user_enters_username_as(String logindata,String field){
				 
					switch(field) {
					
					case"username":
						loginpage.enterUserName(logindata);
						
						break;
						
					case"password":
						
						loginpage.enterPassword(logindata);
						break;
					default:
						
					System.out.println("unable to find field:" + field);
					Assert.fail();
					}
			 }

	@When("User clicks on {string}")
			 public void user_clicks_on(String buttontype){
			       switch (buttontype) {
			       case"login":
			       loginpage.clickSignInButton();
			       break;
			       case"bankcash":
			     	  loginpage = PageFactory.initElements(driver, Loginpage.class);
			     	  loginpage.clickonbankCash();
			     	  break;
			       case"newAccount":
			     	  loginpage.clickonnewAccount();
			     	  break;
			       case"submit":
			       Loginpage.clickonSubmitbutton();
			       default:
			    	   System.out.println("unable to click on the button:" + buttontype);
			       }
			 }

	@Then("User enters {string} in the {string} field in accounts page")
			       public void user_enters_in_the_field_in_accounts_page(String logindata, String field) {
			    	   switch(field) {
			    	   case"accountTitle":
			    	   loginpage.enteraccountTitle(logindata);
			    	   break;
			    	  
			    	   case"description":
			    	   loginpage.enterdescription(logindata);
			    	   break;
			    	   
			    	  
			    	   case"initialBalance":
			    	   loginpage.enteraccountTitle(logindata);
			    	   break;
			    	   
			    	   
			    	   case"accountNumber":
			    	   loginpage.entercontactpersonfield(logindata);
			    	   break;
			    	  
			    	   case"contactPerson":
			    	   loginpage.enteraccountNumberfield(logindata);
			    	   break;
			    	   
			    	   
			    	   
			    	   case"Phone":
			    		   loginpage.enteraccountNumberfield(logindata);
			    		   break;
			    	   case"internetBankingURL":
			    		   loginpage.enteraccountNumberfield(logindata);
			    		  default:
			    			  System.out.println("login information:"+ logindata + "not invalid in" + field);
			    	   }
	}
			       
			   @Then("user should be able to validate account created successfully")
					public void user_should_be_able_to_validate_account_created_successfully() {
				   takeScreenshot(driver);
		}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}


