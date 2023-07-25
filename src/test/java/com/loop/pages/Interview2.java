package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.*;

public class Interview2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("nadir","apple","sdasd"));
        System.out.println(sort(list));

       // Driver.getDriver().get("https://nba.com");
        //List<WebElement> list1 = Driver.getDriver().findElements(By.xpath("//span[@class='NavItem_text__JoCLX']"));
//        for (WebElement each : list1  ) {
//            System.out.println(each.getText());
//
//        }
      // list1.forEach((p)-> {
         //  System.out.println(p.getText());
       //});
        //WebDriver driver= new SafariDriver();
       // driver.get("https://nba.com/");


        System.out.println("===========================");
        System.out.println(endOther("Hiabc", "abc"));
        System.out.println(endOther("AbC", "HiaBc"));
        System.out.println(endOther("abc", "abXabc"));

        String c="AbC";
        String d="HiaBc";
       // c=c.substring(1);
        if(c.toLowerCase().contains(d.toLowerCase())

        ||d.toLowerCase().contains(c.toLowerCase() )){
            System.out.println("yes");
        }
        System.out.println(c);
    }

    public static boolean endOther(String a, String b) {
        boolean result=false;
        if(a.toLowerCase().contains(b.toLowerCase()) ||
                b.toLowerCase().contains(a.toLowerCase())){
            return true;
        }
        return result;
    }


    public static List<String> sort(List<String> list){
//        list.add("Nadir");
//        list.add("feyruz");
//        list.add("afcsd");
//        list.add("wefs");

        Collections.sort(list);
        return list;

    }


}
