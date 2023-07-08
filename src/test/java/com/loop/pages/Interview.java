package com.loop.pages;

public class Interview {


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
