package com.loop.pages;

import com.loop.utilities.BrowerUtils;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//label[.='Username or email']/following-sibling::input")
    public WebElement loginInput;

    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement passwordInput;

    @FindBy(className = "v-btn__content")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Home']")
    public WebElement homeIcon;

    public void loginDocuport(String username, String password){
        BrowerUtils.waitForVisibility(loginInput, 5);
        loginInput.clear();
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        BrowerUtils.waitForClickable(loginButton,5);
        BrowerUtils.clickWithJS(loginButton);

    }

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
