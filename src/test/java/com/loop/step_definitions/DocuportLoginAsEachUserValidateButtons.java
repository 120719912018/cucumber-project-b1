package com.loop.step_definitions;

import com.loop.pages.DocuportEachUserValidation;
import com.loop.utilities.BrowerUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * task1:
 *   - login as an advisor
 *   - click on recieved documents
 *   - validate:
 *   1. search button is displayed
 *   2. download button is displayed
 *   3. Receieved docs is displayed
 *   - click on my uploads
 *   - validate
 *   1. search button is displayed
 *   2. download button is displayed
 *   3. My Uploads is displayed
 *
 *   repeat the task for client eployee and supervisor
 *   use Scenario outline
 */
public class DocuportLoginAsEachUserValidateButtons {

    DocuportEachUserValidation validationReceivedDoc = new DocuportEachUserValidation();
    @Given("User login  home page each  {string} and {string}")
    public void user_login_home_page_each_and(String username, String password) {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        validationReceivedDoc.loginInput.sendKeys(username);
        validationReceivedDoc.passwordInput.sendKeys(password);
        validationReceivedDoc.loginButton.click();


    }
    @When("User click on  recieved documents each {string}")
    public void user_click_on_recieved_documents_each(String username) {
       if(username.equals("b1g2_client@gmail.com")){
           validationReceivedDoc.continueButton.click();
           BrowerUtils.waitForVisibility(validationReceivedDoc.receivedDocs,15);
           validationReceivedDoc.receivedDocs.click();
       } else {
           validationReceivedDoc.receivedDocs.click();
       }
    }

    @Then("Validate search,download,Received  button is displayed")
    public void validate_search_download_received_button_is_displayed(List<String> element) {

        for (String each : element ) {
            if (each.equals(validationReceivedDoc.receivedDocsHeader.getText())){
               assert validationReceivedDoc.receivedDocsHeader.isDisplayed();
            } else if (each.equals(validationReceivedDoc.searchButton.getText())){
                validationReceivedDoc.searchButton.isDisplayed();
            }else if (each.equals(validationReceivedDoc.downloadButton.getText())){
                validationReceivedDoc.downloadButton.isDisplayed();
            }

        }
    }
    @When("User clicks on my upload button")
    public void user_clicks_on_my_upload_button() {
         validationReceivedDoc.uploadButton.click();
    }
    @Then("User validate search,download,MyUpload is displayed")
    public void user_validate_search_download_my_upload_is_displayed(List<String> element) {
  for (String each : element ) {
     if (each.equals(validationReceivedDoc.uploadHeader.getText())){
       assert  validationReceivedDoc.uploadHeader.isDisplayed();
     } else if (each.equals(validationReceivedDoc.searchButton.getText())){
         validationReceivedDoc.searchButton.isDisplayed();
     }else if (each.equals(validationReceivedDoc.downloadButton.getText())){
         validationReceivedDoc.downloadButton.isDisplayed();
     }

        }
    }


}
