package com.loop.pages;

import com.loop.utilities.BrowerUtils;
import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportBasePage {
    @FindBy(xpath = "//label[.='Username or email']/following-sibling::input")
    public WebElement loginInput;

    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement passwordInput;


    @FindBy(className = "v-btn__content")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Home']")
    public WebElement homeIcon;

    @FindBy(xpath = "//span[.='Received docs']")
    public WebElement receivedDocs;

    @FindBy(xpath = "//h1[.='Received docs']")
    public WebElement receivedDocsHeader;

    @FindBy(xpath = "//span[contains(normalize-space(),'Continue')]")
    public  WebElement continueButton;
    @FindBy(xpath = "//h3[.='Choose account']")
    public WebElement chooseAccount;
    @FindBy(xpath = "//span[contains(text(),'Download')]")
    public WebElement downloadButton;

    @FindBy(xpath = "//span[contains(text(),'Search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[.='My uploads']")
    public WebElement uploadButton;

    @FindBy(xpath = "//h1[.='My uploads']")
    public WebElement uploadHeader;



    @FindBy(xpath = "//span[text()='Users']")
    public WebElement userForEmployee;


    public DocuportBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public void leftItem(String item){

        Driver.getDriver().findElement(By.xpath("//span[.='"+item+"']")).click();
    }
    @FindBy(xpath = "//div[text()='10']")
    public WebElement ten;

    @FindBy(xpath = "(//div[.='5'])[3]")
    public WebElement five;

    @FindBy(xpath = "(//div[text()='5'])[1]")
    public WebElement afterFive;


    public void selectRowNum(Integer number){
        Driver.getDriver().findElement(By.xpath("//div[text()='"+number+"']"))
                .click();
    }

     public void UserAndLead(String item){
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+item+"')]"))
                .click();
     }

    public void validateButton(String button){
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).isDisplayed();
    }
    public void validateHeader(String header){
        Driver.getDriver().findElement(By.xpath("//h1[contains(text(),'"+header+"')]")).isDisplayed();
    }
    public void clickButton(String button) throws InterruptedException {
        switch (button.toLowerCase()){
            case "received docs":
               leftItem(button);
               break;
            case "my uploads":
                leftItem(button);
                break;
            case "1099 form":
                leftItem(button);
                break;
            case "reconciliations":
                leftItem(button);
                break;
            case "continue":
                Thread.sleep(3000);
               continueButton.click();
                BrowerUtils.waitForVisibility(receivedDocs,20);
                break;

        }

    }

}
