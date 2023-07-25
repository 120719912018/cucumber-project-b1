package com.loop.pages;

import com.loop.utilities.BrowerUtils;
import com.loop.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Interview {

    public static void main(String[] args) {
        String [] arr ={"apple","banana","grape"};
        String str1 ="khoshgadam";
        String str2;
        String str3;
        str1=arr[0];
        str2=arr[1];
        str3=arr[2];
       String reverse="";
        for (String each:arr) {
            for (int j = each.length()-1; j >=0; j--) {
               // reverse+= each.charAt(j)+" ";
                System.out.print(each.charAt(j)+" ");
            }
            System.out.println();
        }


           // System.out.println(reverse);

       // System.out.println(reverse);

//        for (int i = str1.length()-1; i >=0; i--) {
//
//            reverse+= str1.charAt(i);
//
//        }
//
//        System.out.println(reverse);

//        Driver.getDriver().get("https://www.sportingnews.com/ca/nba?gr=www");
//
//        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[contains(text(),'CONN')]"));
//
//
//
//        for (WebElement each: elements) {
//
//            System.out.println(each.getText());
//
//        }
//
//



    }
}
