package com.loop.step_definitions;

import com.github.javafaker.Faker;
import com.loop.pages.DocuportLoginPage;
import com.loop.pages.DocuportNewClient;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowerUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class DocuportCreateClient {
     DocuportLoginPage loginPage = new DocuportLoginPage();
     ///DocuportNewClient docuportNewClient= new DocuportNewClient();

    @Given("User login as an advisor")
    public void user_login_as_an_advisor() {
        DocuportUtils.login(Driver.getDriver(),"advisor");
    }
    @When("User create a new client")
    public void user_create_a_new_client()  {
       DocuportUtils.setCreatNewClient();

    }
    @Then("Validate that new client created")
    public void validate_that_new_client_created() {
        Assert.assertEquals("Khoshgadam aliyeva has been updated successfully",loginPage.successMsg.getText());
    }
    @Then("Log out as an advisor")
    public void log_out_as_an_advisor() {
        loginPage.clickBatchButton.click();
        loginPage.logOut.click();
    }
    @Then("Log as a new client")
    public void log_as_a_new_client() {
        loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("new.client.email"));
        loginPage.passwordInput.sendKeys("Khoshgadam888");
        loginPage.loginButton.click();
    }

}
