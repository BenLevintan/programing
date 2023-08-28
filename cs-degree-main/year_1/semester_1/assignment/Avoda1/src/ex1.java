// Assignment: 1
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an exchange rate:");
        double rate = scan.nextDouble();
        System.out.println("Please enter the sum in USD:");
        double sum = scan.nextDouble();
        System.out.println("Up-to-date USD-NIS equivalency: " + sum + "USD = " + sum * rate + " NIS");  //returns input in dollars and NIS
    }
}

/*  why people with glasses use Java?
    because they cant ' C Sharp '
 */