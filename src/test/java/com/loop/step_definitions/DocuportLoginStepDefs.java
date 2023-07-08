package com.loop.step_definitions;

import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DocuportLoginStepDefs {
     DocuportLoginPage loginPage = new DocuportLoginPage();
     String username="";
    @Given("User is on Docuport login page")
    public void user_is_on_docuport_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user enters {string} and {string} for credentials for each user")
    public void user_enters_and_for_credentials_for_each_user(String username, String password) {
        loginPage.loginInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }
    @When("user enters login button")
    public void user_enters_login_button() {
        loginPage.loginButton.click();

    }
    @When("user should see home page")
    public void user_should_see_home_page() {
        loginPage.homeIcon.isDisplayed();
    }
    @Then("validate left navigate items of docuport for each user")
    public void validate_left_navigate_items_of_docuport_for_each_user(List<Map<String,String>> leftItems) {
        for (Map<String,String>  leftItem: leftItems ) {
            switch (username){
        case "b1g2_client@gmail.com":
            System.out.println(loginPage.getLeftElement(leftItem.get("client")));
            Assert.assertEquals(loginPage.getLeftElement(leftItem.get("client")), leftItem.get("client"));
           // Assert.assertEquals("no match",loginPage.getLeftElement(leftItem.get("Client")),leftItem);
        case "b1g2_advisor@gmail.com":
            Assert.assertEquals("no match",loginPage.getLeftElement(leftItem.get("Advisor")),leftItem.get("Advisor"));
        case "b1g2_supervisor@gmail.com":
            Assert.assertEquals("no match",loginPage.getLeftElement(leftItem.get("Supervisor")),leftItem.get("Supervisor"));
        case "b1g2_employee@gmail.com":
            Assert.assertEquals("no match",loginPage.getLeftElement(leftItem.get("Employee")),leftItem.get("Employee"));

            }
           // System.out.println(loginPage.getLeftElement(leftItem.get("Client")));
           // System.out.println("=============");
           // System.out.println(leftItem.get("Client"));

        }
    }

}
