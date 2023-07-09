package com.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    @Given("User login  home page each  {string} and {string}")
    public void user_login_home_page_each_and(String username, String password) {

    }
    @When("User click on  recieved documents")
    public void user_click_on_recieved_documents() {

    }
    @Then("Validate search,download,Received  button is displayed")
    public void validate_search_download_received_button_is_displayed() {

    }
    @When("User clicks on my upload button")
    public void user_clicks_on_my_upload_button() {

    }
    @Then("User validate search,download,MyUpload is displayed")
    public void user_validate_search_download_my_upload_is_displayed(io.cucumber.datatable.DataTable dataTable) {

    }

}
