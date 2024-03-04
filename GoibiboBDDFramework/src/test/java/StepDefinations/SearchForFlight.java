package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObject.SearchForFlightPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchForFlight  
{
	WebDriver driver=null;
	SearchForFlightPageObject s;

@Given("^I go to Goibibo site$")
public void i_go_to_Goibibo_site() {
	System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("https://www.goibibo.com/");
}

@When("^I choose one way$")
public void i_choose_one_way() {
    s.enterway();
}
//
@And("^I type Mumbai and choose Mumbai,India\\(BOM\\) in the field From$")
public void i_type_Mumbai_and_choose_Mumbai_India_BOM_in_the_field_From() throws InterruptedException  {
	s=new SearchForFlightPageObject(driver);
	s.enterFrom("Mumbai");
}
//
@And("^I type Delhi and choose Delhi,India\\(DEL\\) in the field To$")
public void i_type_Delhi_and_choose_Delhi_India_DEL_in_the_field_To() throws InterruptedException {
   s.enterDest("Delhi");
}
//
@And("^I choose (\\d+)/(\\d+)/(\\d+) referring to Departure$")
public void i_choose_referring_to_Departure(int arg1, int arg2, int arg3) throws Throwable {
   s.enterDate(21, "March");
}
//
@And("^I click on Search$")
public void i_click_on_Search() throws Throwable {
   s.searchbtn();
}
//
@Then("^will be displayed Choose Flight$")
public void will_be_displayed_Choose_Flight() throws Throwable {
   String title=s.validate_nextPage();
    Assert.assertEquals(title, "Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo");
}
@Then("move to ticket summary")
public void move_to_ticket_summary() throws InterruptedException {
    s.ticket_summary();
}
@Then("close the browser")
public void close_the_browser() {
    driver.close();
}
}
