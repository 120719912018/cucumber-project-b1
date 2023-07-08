package com.loop.step_definitions;

import com.github.javafaker.Faker;
import com.loop.pages.DocuportLoginPage;
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

    @Given("User login as an advisor")
    public void user_login_as_an_advisor() {
        DocuportUtils.login(Driver.getDriver(),"advisor");
    }
    @When("User create a new client")
    public void user_create_a_new_client() {
        //Faker faker = new Faker();
        loginPage.client.click();
        loginPage.new_client.click();
        loginPage.personal.click();
       // Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandle());
        loginPage.newClientFirstName.sendKeys("Khoshgadam");
        loginPage.newClientLastName.sendKeys("aliyeva");
        loginPage.creatNewClientCheckBok.click();
        loginPage.newClientEmailAddress.sendKeys("khoshgadam889@gmail.com");
        loginPage.advisorCheckBok.click();
        loginPage.Group2.click();
        loginPage.phoneNumber.sendKeys("6476437777");
        loginPage.password.sendKeys("Khoshgadam888");
        loginPage.confirmPassword.sendKeys("Khoshgadam888");
        loginPage.saveButton.click();
        loginPage.dateClick.click();
        BrowerUtils.clickWithJS(loginPage.bbDate);
        loginPage.phoneNumber.sendKeys("6476437777");
        loginPage.advisor.click();
        loginPage.Group2.click();
        loginPage.service.click();
        loginPage.selectService.click();
       // loginPage.collaborator.click();
        //loginPage.collaborator.sendKeys("java");
        //loginPage.selectCollaborator.click();
        loginPage.addressLine1.sendKeys("2870 koshal");
        loginPage.addressLine2.sendKeys("62 salterton");
        loginPage.city.sendKeys("Edmonton");
        loginPage.state.click();
        loginPage.selectState.click();
        loginPage.zipcode.sendKeys("12345");
        loginPage.SaveFinish.click();


    }
    @Then("Validate that new client created")
    public void validate_that_new_client_created() {
        Assert.assertEquals("khoshgadam889@gmail.com",loginPage.emailAssert.getText());
    }
    @Then("Log out as an advisor")
    public void log_out_as_an_advisor() {
        loginPage.clickBatchButton.click();
        loginPage.logOut.click();
    }
    @Then("Log as a new client")
    public void log_as_a_new_client() {
        loginPage.loginInput.sendKeys("khoshgadam889@gmail.com");
        loginPage.passwordInput.sendKeys("Khoshgadam888");
        loginPage.loginButton.click();
    }

}
