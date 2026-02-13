package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.CatagoriesPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CatagoriesSteps {
	
	private String title;
	
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		
	List<Map<String, String>> credentials=	dataTable.asMaps();
	    String username=credentials.get(0).get("username");
	    String password=credentials.get(0).get("password");
	    LoginPage.doLogin(username, password);
	}

@Given("user is on dashboard page")
public void user_is_on_dashboard_page() {
	title=CatagoriesPage.getPageTitle();
}

@Then("dashboard page title should be {string}")
public void dashboard_page_title_should_be(String expectedTitle) {
    Assert.assertTrue(title.equals(expectedTitle));
}


@Then("below sub catagories should be displayed")
public void below_sub_catagories_should_be_displayed(DataTable sectionTable) {
	List<String> Expectedsectionlist=sectionTable.asList();
	System.out.println(Expectedsectionlist.get(0));
	System.out.println(Expectedsectionlist.get(1));
	System.out.println("Expected account list "+Expectedsectionlist);
	List<String> actualList=CatagoriesPage.getCatagoriesList();
	System.out.println("actual catagories are "+actualList);
	Assert.assertTrue(Expectedsectionlist.equals(actualList));
    
}

@Then("number of catagories should be {int}")
public void number_of_catagories_should_be(Integer expectedCount) {
	System.out.println("actual count ="+CatagoriesPage.getCatagoryCount());
	System.out.println("actual count ="+expectedCount);
   Assert.assertTrue(CatagoriesPage.getCatagoryCount()==expectedCount);
}


}
