package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDragDropPage {
    @FindBy(id="draggable")
    public WebElement smallCircle;

    @FindBy(id="droptarget")
    public WebElement bigCircle;

   // WebElement element = Driver.getDriver().findElement(By.id());
    public LoopPracticeDragDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
