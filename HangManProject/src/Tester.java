/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

name: Theo
Date: Sep 21, 2021
File name: Tester.java
class: ICSI UAlbany
Professor: 
Purpose:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import java.util.Scanner;
import java.util.Random;

public class Tester {

    public static Scanner input = new Scanner(System.in); //input
    public static Random r = new Random();//random nums

    public static void main(String[] args) {
//        HangManLogic    obj = new HangManLogic("he hew hwqjel");
//        obj.turnIntoArr();
//        String r  = obj.showArr();
        System.out.println(test());

    }

    public static String test() {

        String temp = "";
        temp += " --------- \n";
        temp += " |/      | \n";
        for (int i = 0; i < 4; i++) {
            temp += " | \n";
        }
        temp += "---------";
        

        return temp;
    }
}
