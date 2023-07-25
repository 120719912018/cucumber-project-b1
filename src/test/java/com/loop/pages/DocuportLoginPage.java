package com.loop.pages;

import com.loop.utilities.BrowerUtils;
import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportLoginPage extends DocuportBasePage
{

    @FindBy(xpath = "//label[.='Username or email']/following-sibling::input")
    public WebElement loginInput;

    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement passwordInput;

    @FindBy(xpath = "//span[contains(text(),'Clients')]")
    public WebElement client;
    @FindBy(xpath = "//span[contains(text(),'Create new client')]")
    public WebElement new_client;


    @FindBy(xpath = "//span[contains(text(),'Personal')]")
    public WebElement personal;


    @FindBy(xpath = "//label[.='First name']/following-sibling::input")
    public WebElement newClientFirstName;

    @FindBy(xpath = "//label[.='Last name']/following-sibling::input")
    public WebElement newClientLastName;
    @FindBy(xpath = "//div[@class='v-input--selection-controls__ripple']")
    public WebElement creatNewClientCheckBok;


    @FindBy(xpath = "//label[.='Email address']/following-sibling::input")
    public WebElement newClientEmailAddress;

    @FindBy(xpath = "(//input[@autocomplete='off'])[3]")
    public WebElement advisorCheckBok;

    @FindBy(xpath = "//div[contains(text(),'Group2')]")
    public WebElement Group2;

    @FindBy(xpath = "//label[.='Phone number']/following-sibling::input")
    public WebElement phoneNumber;

    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement password;
    //label[contains(text(),'Confirm password')]
    @FindBy(xpath = "//label[.='Confirm password']/following-sibling::input")
    public WebElement confirmPassword;
    @FindBy(xpath = "//span[.=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[.='Date of birth']/following-sibling::input")
    public WebElement dateClick;

    @FindBy(xpath = "//div[.='6']")
    public WebElement bbDate;

    @FindBy(xpath = "(//input[@autocomplete ='off'])[1]")
    public WebElement advisor;

    @FindBy(xpath = "(//input[@autocomplete ='off'])[2]")
    public WebElement service;


    @FindBy(xpath = "(//i[@class='v-icon notranslate mdi mdi-checkbox-blank-outline theme--light'])[1]")
    public WebElement selectService;
    @FindBy(xpath = "(//input[@autocomplete ='off'])[4]")
    public WebElement collaborator;

    @FindBy(xpath = "(//i[@class='v-icon notranslate mdi mdi-checkbox-blank-outline theme--light'])[1]")
    public WebElement selectCollaborator;



    @FindBy(xpath = "//label[.='Address line 1']/following-sibling::input")
    public WebElement addressLine1;

    @FindBy(xpath = "//label[.='Address line 1']/following-sibling::input")
    public WebElement addressLine2;

    @FindBy(xpath = "//label[.='City']/following-sibling::input")
    public WebElement city;

    @FindBy(xpath = "//div[.='California']/div/div")
    public WebElement selectState;
    @FindBy(xpath = "//label[.='Zip code']/following-sibling::input")
    public WebElement zipcode;

    @FindBy(xpath = "//span[.=' Save ']")
    public WebElement SaveFinish;
    @FindBy(xpath = "(//input[@autocomplete ='off'])[5]")
    public WebElement state;

    @FindBy(xpath = "//span[@class='subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3']")
    public WebElement clickBatchButton;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOut;




    public DocuportLoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getLeftElement(String leftIcon){
        String actual = Driver.getDriver()
                .findElement(By.xpath("//span[contains(text(), '"+leftIcon+"')]")).getText();
        return actual;

    }

    @FindBy (xpath = "//span[contains(text(),'Khoshgadam aliyeva has been updated successfully')]")
    public WebElement successMsg;



}
