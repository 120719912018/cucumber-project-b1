package com.loop.step_definitions;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowerUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Background;

import java.util.Map;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }
    @When("user enters username for client")
    public void user_enters_username_for_client() throws InterruptedException {

        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }
    @When("user users password for client")
    public void user_users_password_for_client() {
       loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_CLIENT);
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }
    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {

        loginPage.homeIcon.isDisplayed();
        //Driver.closingDriver();
    }
    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
    }
    @When("user users password for employee")
    public void user_users_password_for_employee() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }
    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        loginPage.homeIcon.isDisplayed();
    }
    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
       loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
    }
    @When("user users password for advisor")
    public void user_users_password_for_advisor() {
       loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_ADVISER);
    }
    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        loginPage.homeIcon.isDisplayed();
        Driver.closingDriver();
    }
    @When("user enters username for admin")
    public void user_enters_username_for_admin() {
       loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }
    @When("user users password for admin")
    public void user_users_password_for_admin() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }
    @Then("user should see the home page for admin")
    public void user_should_see_the_home_page_for_admin() {
        loginPage.homeIcon.isDisplayed();
    }



    @When("user enters credentials")
    public void user_enters_credentials(Map<String ,String> credentials) {

//        for (Map.Entry <String,String> each: credentials.entrySet() ) {
//            System.out.println(each.getKey());
//           System.out.println(each.getValue());
//        }
        loginPage.loginDocuport(credentials.get("username"),credentials.get("password"));

    }





}




