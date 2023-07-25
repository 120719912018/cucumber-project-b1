package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DocuportEachUserValidation  extends DocuportBasePage{

    @FindBy(xpath = "//label[.='Username or email']/following-sibling::input")
    public WebElement loginInput;

    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement passwordInput;

    @FindBy(xpath = "//span[.='Received docs']")
    public WebElement receivedDocs;

    @FindBy(xpath = "//h1[.='Received docs']")
    public WebElement receivedDocsHeader;

    @FindBy(xpath = "//span[contains(normalize-space(),'Continue')]")
    public  WebElement continueButton;
    @FindBy(xpath = "//h3[.='Choose account']")
    public WebElement chooseAccount;
    @FindBy(xpath = "(//span[.='Download'])[1]")
    public WebElement downloadButton;

    @FindBy(xpath = "//button[@class='mr-3 mb-1 mb-sm-0 v-btn v-btn--has-bg theme--light v-size--large']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[.='My uploads']")
    public WebElement uploadButton;

    @FindBy(xpath = "//h1[.='My uploads']")
    public WebElement uploadHeader;

     public  void validateButtons(){
        receivedDocsHeader.isDisplayed();
     }


    public   DocuportEachUserValidation(){
      PageFactory.initElements(Driver.getDriver(),this);
  }


}
