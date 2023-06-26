package com.loop.step_definitions;
      /* use cucumber framework
use page object model design
if possible apple scenario outline

task1: Wikipedia Search Functionality Title Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the wiki title

task2: Wikipedia Search Functionality Header Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the main header

task3: Wikipedia Search Functionality Image Header Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the image header
      * */

import com.loop.pages.WikipediaSearchFunctionality;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Wikipedia_search_functionality {
      WikipediaSearchFunctionality wikipediaSearchFunctionality = new WikipediaSearchFunctionality();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wiki.page"));
        wikipediaSearchFunctionality.homepage.isDisplayed();
    }
    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String input) {
        wikipediaSearchFunctionality.searchBox.sendKeys(input);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
       wikipediaSearchFunctionality.searchButton.click();
    }
    @Then("User sees {string} is in the {string}")
    public void user_sees_is_in_the(String name, String titleVer) {

        Assert.assertEquals("expected doesn't match to actual"
                ,"Steve Jobs - Wikipedia",Driver.getDriver().getTitle());
        Assert.assertEquals("expected doesn't match to actual"
                ,name,wikipediaSearchFunctionality.mainTitle.getText());
        Assert.assertEquals("expected doesn't match to actual"
                ,name,wikipediaSearchFunctionality.imageTitle.getText());
    }



}
