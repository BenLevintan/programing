// Assignment: 2
//Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        long input = 1;
        int count7, max7 = 0;
        long temp;

        while (true) {

            System.out.println("Enter positive integer (enter 0 to finish):");

            input = scan.nextLong();

            if(input<0) {
                System.out.println("please enter a POSITIVE number!");
                continue;
            }

            temp = input;
            count7 = 0;                            //resetting the count for the next input

            while (temp > 0) {
                if (temp % 7 == 0)                 //checking if the LSD is 7
                    ++count7;
                temp = temp / 10;                  //getting rid of the last digit
            }

            if (count7 > max7)                     //if we found a number with more 7's, the number of 7's is the new max
                max7 = count7;

            if(input == 0)
                break;
        }


        System.out.println("The maximum number of times \"7\" appeared is: " + max7);

    }


}
