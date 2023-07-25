package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientPage {
    //List<String> list =new ArrayList<>(Arrays.asList("Nadir","Feyruz"));


    private final String CHOOSEACCOUNT ="//h3[.='Choose account']";
     @FindBy(xpath = CHOOSEACCOUNT)
      public  WebElement chooseAccountText;

    @FindBy(xpath = "//span[contains(normalize-space(),'Continue')]")
    public  WebElement continueButton;


    public ClientPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
