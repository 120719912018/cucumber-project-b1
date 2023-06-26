package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchFunctionality {

    @FindBy(xpath ="//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath ="//button[.='Search']" )
    public WebElement searchButton;

    @FindBy(id = "Welcome_to_Wikipedia")
    public WebElement homepage;

    @FindBy(xpath = "//div[@class=\'fn\']")
    public WebElement imageTitle;


    @FindBy(xpath = "//span[contains(text(),'Steve Jobs')]")
    public WebElement mainTitle;
    @FindBy(xpath ="//span[contains(text(),'Steve Jobs')]" )
    public WebElement titleVer;
    public WikipediaSearchFunctionality(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
