package com.loop.step_definitions;

import com.loop.pages.DocuportEachUserValidation;
import com.loop.utilities.BrowerUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocuportLeftNavigationItemsStepDefs {

    DocuportEachUserValidation validationReceivedDoc = new DocuportEachUserValidation();
    @Given("User login  home page on Docuport")
    public void user_login_home_page_on_docuport() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));


    }
    @When("User enters credential each  {string} and {string}")
    public void user_enters_credential_each_and(String username, String password) throws InterruptedException {
        BrowerUtils.waitForVisibility(validationReceivedDoc.loginInput,15);
        validationReceivedDoc.loginInput.sendKeys(username);
        BrowerUtils.waitForVisibility(validationReceivedDoc.passwordInput,15);
        validationReceivedDoc.passwordInput.sendKeys(password);
        validationReceivedDoc.loginButton.click();

        if (username.equals("b1g2_client@gmail.com")){
              //validationReceivedDoc.continueButton.click();
              validationReceivedDoc.clickButton("continue");
            BrowerUtils.waitForVisibility(validationReceivedDoc.receivedDocs,20);
        }
    }
    @When("User click on  {string} item")
    public void user_click_on_item(String item) throws InterruptedException {
        //BrowerUtils.waitForVisibility(validationReceivedDoc.receivedDocs,10);
        validationReceivedDoc.clickButton(item);
    }
    @Then("Validate {string} button is displayed")
    public void validate_button_is_displayed(String button) throws InterruptedException {
        BrowerUtils.justWait(7);
       validationReceivedDoc.validateButton(button);
    }
    @Then("Validate {string} header is displayed")
    public void validate_header_is_displayed(String header) throws InterruptedException {
        BrowerUtils.justWait(7);
     validationReceivedDoc.validateHeader(header);
    }

    @When("User clicks on {string} item")
    public void user_clicks_on_item(String item) throws InterruptedException {

        validationReceivedDoc.clickButton(item);
        BrowerUtils.justWait(7);
    }



}
