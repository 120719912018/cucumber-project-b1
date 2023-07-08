package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.utilities.BrowerUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Node;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private static final Logger LOG = LogManager.getLogger();


    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver();
        BrowerUtils.myScenario = scenario;
        LOG.info("...........START AUTOMATION.......LOOP ACADEMY......");
    }


    @After
    public void tearDown(Scenario scenario){
        // only takes a screenshot when scenario is failed
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closingDriver();
        LOG.info("...........END AUTOMATION.......LOOP ACADEMY.....");
    }
}