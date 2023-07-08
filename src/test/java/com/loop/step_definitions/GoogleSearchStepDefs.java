package com.loop.step_definitions;

import com.loop.pages.GoogleSearchPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.pkix.jcajce.JcaPKIXIdentity;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoogleSearchStepDefs {

      GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    private static final Logger LOG = LogManager.getLogger();

    @Given("user is on Google search page")
    public void user_is_is_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        LOG.info("User is on Google page");
    }
    @When("user types Loop Academy in the google search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() {
          googleSearchPage.searchBox.sendKeys("Loop Academy" + Keys.ENTER);
        LOG.info("User types on Google page");
    }
    @Then("user should see Loop Academy - Google Search in the google title")
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
        Assert.assertEquals(Driver.getDriver().getTitle(),"Loop Academy - Google Search","expected  does not match actual title");
        LOG.info("User see the result ");
    }

    @When("user types {string} in the google search box and click enter")
    public void user_types_in_the_google_search_box_and_click_enter(String input) {
         googleSearchPage.searchBox.sendKeys(input+Keys.ENTER);
    }
    @Then("User should see {string} is in the google title")
    public void user_should_see_search_is_in_the_google_title(String title) {
        Assert.assertEquals("Expected does not match actual", title, Driver.getDriver().getTitle());
    }

    @Then("user search the following item")
    public void user_search_the_following_item(List<Map<String,String>> items) {

//     items.forEach(p->{
//         googleSearchPage.searchBox.clear();
//         googleSearchPage.searchBox.sendKeys(p+ Keys.ENTER);
//     Assert.assertEquals(p + " - Google Search", Driver.getDriver().getTitle());
//     });

//        for (String s : items){
//            googleSearchPage.searchBox.clear();
//            googleSearchPage.searchBox.sendKeys(s + Keys.ENTER);
//            Assert.assertEquals(s + " - Google Search", Driver.getDriver().getTitle());
//        }

        for (Map <String,String> item: items) {
            System.out.println();
        }
    }

    @When("user searches for the {string}")
    public void user_searches_for_the(String country) {
       googleSearchPage.searchBox.sendKeys("What is the capital of " + country+Keys.ENTER);
        LOG.info("User search for " + country);
    }
    @Then("user should see the {string} in the result")
    public void user_should_see_the_in_the_result(String capital) {
        LOG.info("User should see  for " + capital);
       Assert.assertEquals(googleSearchPage.capital.getText(), capital);
    }





}
