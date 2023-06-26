package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearOrderPage extends SmartBearBasePage{
    public SmartBearOrderPage (){
        PageFactory.initElements(Driver.getDriver(),this);
        }


    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement product;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;
    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement submitButton;
    @FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;
    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;
    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;
    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;
    @FindBy (xpath = "//input[@type='radio']")
    public List<WebElement> card;
    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;
    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expiryDate;

    @FindBy (xpath = "//a[.='Process']")
    public WebElement processButton;
    @FindBy (xpath = "//strong['New order has been successfully added.']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[.='Order']")
    public WebElement orderHeading;


}
