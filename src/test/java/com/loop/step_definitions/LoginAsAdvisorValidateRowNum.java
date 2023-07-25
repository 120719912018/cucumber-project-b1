package com.loop.step_definitions;

import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.BrowerUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.*;

import java.util.Map;

public class LoginAsAdvisorValidateRowNum {

    private static final Logger LOG = LogManager.getLogger();
    DocuportLoginPage loginPage = new DocuportLoginPage();

    @Given("User is Docuport login page")
    public void user_is_docuport_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("User enter credential as advisor")
    public void user_enter_credential_as_advisor(Map<String,String> credentials) {
        BrowerUtils.waitForVisibility(loginPage.passwordInput,10);
        loginPage.loginInput.sendKeys(credentials.get("username"));
        loginPage.passwordInput.sendKeys(credentials.get("password"));
        loginPage.loginButton.click();
        LOG.info("User login successfully");
    }
    @When("User click {string} button")
    public void user_click_button(String item) {
        loginPage.UserAndLead(item);
        LOG.info("User click " +item+ " button");
    }


    @Then("Validate that Rows Per Page shows by default {int}")
    public void validate_that_rows_per_page_shows_by_default(Integer defaultNum) {
        assertEquals(defaultNum.toString(),loginPage.ten.getText());
        LOG.info("Validated that rows per page shows by default "+defaultNum);
    }
    @Then("Change Rows Per Page to {int}")
    public void change_rows_per_page_to(Integer num) {
       loginPage.ten.click();
        BrowerUtils.waitForClickable(loginPage.five,10);
       loginPage.selectRowNum(num);
        LOG.info("User change row number to "+num);
    }
    @Then("Validate that after changing it is showing {int}")
    public void validate_that_after_changing_it_is_showing(Integer num2) {
        assertEquals(num2.toString(),loginPage.afterFive.getText());
        LOG.info("Validate that after changing it is showing "+num2);
    }
  //=================================================================================//
  @When("User click {string} button for {string}")
  public void user_click_button_for(String item, String username) {
      if (username.equals("b1g2_employee@gmail.com")){
          loginPage.UserAndLead("Users");
      } else {
          loginPage.UserAndLead(item);
      }

      LOG.info("User click " +item+ " button  " + username);

  }


    @Then("Validate that Rows Per Page shows by default {int} for {string}")
    public void validate_that_rows_per_page_shows_by_default_for(Integer defaultNum, String username) {
        if(username.equals("b1g2_supervisor@gmail.com")  || username.equals("b1g2_advisor@gmail.com")){
            assertEquals(defaultNum.toString(),loginPage.ten.getText());
            LOG.info("Validated that rows per page shows by default "+defaultNum);
        }

    }
    @Then("Change Rows Per Page to {int} for {string}")
    public void change_rows_per_page_to_for(Integer num, String username) {
        if(username.equals("b1g2_supervisor@gmail.com")  || username.equals("b1g2_advisor@gmail.com")) {
            loginPage.ten.click();
            BrowerUtils.waitForClickable(loginPage.five, 10);
            loginPage.selectRowNum(num);
            LOG.info("User change row number to " + num);
        }
    }

    @Then("Validate that after changing it is showing {int} for {string}")
    public void validate_that_after_changing_it_is_showing_for(Integer num2, String username) {
        if(username.equals("b1g2_supervisor@gmail.com")  || username.equals("b1g2_advisor@gmail.com")) {
            assertEquals(num2.toString(), loginPage.afterFive.getText());
            LOG.info("Validate that after changing it is showing " + num2);
        }
    }


}
