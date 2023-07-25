package com.loop.pages;

import com.loop.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Sample3 {
    @Test
    public void test(){
        Driver.getDriver().get("https://www.sportingnews.com/ca/nba?gr=www");
        List<WebElement> listTaG= Driver.getDriver().findElements(By.tagName("a"));
        System.out.println(listTaG);
       listTaG.forEach(p->{
           System.out.println(p.getText());
       });
       Driver.closingDriver();
    }
}
