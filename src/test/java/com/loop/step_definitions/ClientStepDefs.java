package com.loop.step_definitions;

import com.loop.pages.ClientPage;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import static org.junit.Assert.*;

public class ClientStepDefs {
    private Logger LOG = LogManager.getLogger();
    ClientPage clientPage = new ClientPage();

    private SoftAssertions softAssertions = new SoftAssertions();
    @When("user validates choose accdount pop up is visible")
    public void user_validates_choose_account_pop_up_is_visible() {
        //BrowserUtils.waitForVisibility(clientPage.chooseAccountText, 5);
//        assertTrue(clientPage.chooseAccountText.isDisplayed());
//        assertTrue(clientPage.chooseAccountText.getText().equals("Choose Account"));
//        assert (clientPage.chooseAccountText.getText().equals("Choose account"));
        softAssertions.assertThat(clientPage.chooseAccountText.getText())
                .isEqualTo("Loop Academy");
        LOG.info("Account text is visible");
    }

    @When("user chooses acount from drop down")
    public void user_chooses_account_from_drop_down() {
        // assertTrue(clientPage.continueButton.isDisplayed());
        softAssertions.assertThat(clientPage.continueButton.isDisplayed()).isTrue();
        softAssertions.assertThat(clientPage.continueButton.getText())
                .isEqualTo("Loop Academy");
        clientPage.continueButton.click();
        softAssertions.assertAll();
    }

}
