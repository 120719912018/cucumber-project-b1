package com.loop.utilities;

import com.loop.pages.DocuportLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportUtils {
    public static void login(WebDriver driver, String role){
        Driver.getDriver().get((ConfigurationReader.getProperty("env")));
       // driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//label[.='Password']//following-sibling::input"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        switch (role.toLowerCase()){
            case "client":
                username.sendKeys(ConfigurationReader.getProperty("client"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case "supervisor":
                username.sendKeys(ConfigurationReader.getProperty("supervisor"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case "advisor":
                username.sendKeys(ConfigurationReader.getProperty("advisor"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case "employee":
                username.sendKeys(ConfigurationReader.getProperty("employee"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            default: throw new InputMismatchException("There is not suc a role: " + role);
        }
        loginButton.click();
    }
    public static void logOut(WebDriver driver){
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
    }


   //public static String  email="khoshgadam112@gmail.com";
    public static void setCreatNewClient()  {

        DocuportLoginPage docuportLoginPage= new DocuportLoginPage();
        docuportLoginPage.client.click();
        docuportLoginPage. new_client.click();
        docuportLoginPage. personal.click();
        docuportLoginPage.  newClientFirstName.sendKeys("Khoshgadam");
        docuportLoginPage. newClientLastName.sendKeys("aliyeva");
        docuportLoginPage. creatNewClientCheckBok.click();
        docuportLoginPage. newClientEmailAddress.sendKeys( ConfigurationReader.getProperty("new.client.email"));
        docuportLoginPage. advisorCheckBok.click();
        docuportLoginPage. Group2.click();
        docuportLoginPage. phoneNumber.sendKeys("6476437777");
        docuportLoginPage. password.sendKeys("Khoshgadam888");
        docuportLoginPage. confirmPassword.sendKeys("Khoshgadam888");
        docuportLoginPage. saveButton.click();
        docuportLoginPage. dateClick.click();
        BrowerUtils.clickWithJS( docuportLoginPage.bbDate);
        docuportLoginPage. phoneNumber.sendKeys("6476437777");
        docuportLoginPage.advisor.click();
        docuportLoginPage.Group2.click();
        docuportLoginPage.service.click();
        docuportLoginPage. selectService.click();
        docuportLoginPage. addressLine1.sendKeys("2870 koshal");
        docuportLoginPage. addressLine2.sendKeys("62 salterton");
        docuportLoginPage. city.sendKeys("Edmonton");
        docuportLoginPage. state.click();
        docuportLoginPage. selectState.click();
        docuportLoginPage. zipcode.sendKeys("12345");
        docuportLoginPage. SaveFinish.click();
        BrowerUtils.waitForVisibility( docuportLoginPage.successMsg,10);
    }




}
