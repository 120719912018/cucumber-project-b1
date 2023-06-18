package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopcampPracticeTask1 {

     @FindBy (id="draggable")
    public WebElement smallCircle;

    @FindBy (id="droptarget")
    public WebElement bigCircle;
    public LoopcampPracticeTask1 (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
