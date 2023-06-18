package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoadingPage {

    public LoopPracticeDynamicLoadingPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //div[@id='alert']
     @FindBy(xpath = "//strong[.='Done!']")
    public   WebElement doneMessage;

    @FindBy(xpath = "//img[@src='/img/a-few-moments.jpg']")
     public WebElement image;

}
