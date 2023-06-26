package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.utilities.BrowerUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Node;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver();
        BrowerUtils.myScenario = scenario;
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }
        Driver.closingDriver();
    }
}
