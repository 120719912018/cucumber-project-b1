package com.loop.pages;

import java.util.HashMap;
import java.util.Map;

public  class Interview {



    public Map<String, String> pairs(String[] strings) {

        Map<String, String> map = new HashMap<>();

        for (String each : strings){
            map.put(each.charAt(1)+"",each.substring(each.length()-1));

        }

        return map;
    }


    public static void main(String[] args) {



        String [] arr= {"one","two","three","four","five"};
        String reverse="";

        for (String each : arr ) {
            for (int i = each.length()-1; i >=0 ; i--) {
               // reverse+=arr[i].charAt(i)+" ";
                System.out.print(each.charAt(i)+" ");
            }
            System.out.println();
        }
       // System.out.println(reverse);

    }
}
