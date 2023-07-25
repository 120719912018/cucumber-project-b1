package com.loop.pages;

import com.loop.utilities.BrowerUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DocuportNewClient extends DocuportLoginPage{
    //public   String  email="khoshgadam112@gmail.com";

    public DocuportNewClient(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void setCreatNewClient()  {
        client.click();
        new_client.click();
        personal.click();
        newClientFirstName.sendKeys("Khoshgadam");
        newClientLastName.sendKeys("aliyeva");
        creatNewClientCheckBok.click();
        newClientEmailAddress.sendKeys(ConfigurationReader.getProperty("new.client.email"));
        advisorCheckBok.click();
        Group2.click();
        phoneNumber.sendKeys("6476437777");
        password.sendKeys("Khoshgadam888");
        confirmPassword.sendKeys("Khoshgadam888");
        saveButton.click();
        dateClick.click();
        BrowerUtils.clickWithJS(bbDate);
        phoneNumber.sendKeys("6476437777");
        advisor.click();
        Group2.click();
        service.click();
        selectService.click();
        addressLine1.sendKeys("2870 koshal");
        addressLine2.sendKeys("62 salterton");
        city.sendKeys("Edmonton");
        state.click();
        selectState.click();
        zipcode.sendKeys("12345");
        SaveFinish.click();
        BrowerUtils.waitForVisibility(successMsg,10);
    }



}
