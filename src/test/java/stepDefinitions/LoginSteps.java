package stepDefinitions;

import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("user navigates to login page")
    public void user_navigates_to_login_page() {
       // loginPage.clickSignInLink();
    }

    @When("user enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        //loginPage.enterEmail(email);
        //loginPage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
      // loginPage.clickLoginButton();
    }

    @Then("user should see error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
       // String actualMessage = loginPage.getErrorMessage();
        //Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
    }
}
