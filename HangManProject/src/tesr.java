/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

name: Theo
Date: Jan 19, 2022
File name: tesr.java
class: ICSI UAlbany
Professor: 
Purpose:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import java.util.Scanner;
import java.util.Random;

public class tesr {

    public static Scanner input = new Scanner(System.in); //input
    public static Random r = new Random();//random nums

    public static void main(String[] args) {
        HangManLogic obj = new HangManLogic("test this now rn pls wirjk");
        // attempts = (attempts + word.length()) + 3;
        obj.turnIntoArr();
        String t = obj.showArr();
        System.out.println(t);

    }

}
