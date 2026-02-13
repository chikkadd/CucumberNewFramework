package stepDefinitions;

import org.testng.Assert;

import com.pages.BaseActions;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private static String title;
@Given("user is on login page")
public void user_is_on_login_page() {
  //DriverFactory.getDriver().get("https://automationexercise.com/");
}

@When("user gets title of the page")
public void user_gets_title_of_the_page() {
	title=LoginPage.getLoginPageTitle();
	System.out.println("login page title is "+title);
}

@Given("I click on login link")
public void clickOnLoginLink() {
	LoginPage.clickSignInLink();
}


@Then("page title should be {string}")
public void page_title_should_be(String expectedTitle) {
	Assert.assertTrue(title.contains(expectedTitle));
    
}

@Then("verify that signUp button displayed")
public void verify_that_sign_up_button_displayed() {
	Assert.assertTrue(LoginPage.isForgotPasswordLinkDisplayed());
   
}

@When("user clicks on Login button")
public void user_clicks_on_login_button() {
	LoginPage.clickSignInButton();
}

@When("user enters username {string}")
public void user_enters_username(String username) {
	LoginPage.EnterUserName(username);
   
}

@When("user enters password {string}")
public void user_enters_password(String password) { 
	LoginPage.EnterPassword(password);
}


@Then("verify that Delete Account button is visible")
public void verify_that_delete_account_button_is_visible() {
	
	Assert.assertTrue(LoginPage.isDeleteAccountDisplayed());

}

@Then("verify that {string} displayed")
public void verify_that_displayed(String mesasge) {
	
	LoginPage.validateInValideLoginErrorMessage(mesasge);
	
}

}
