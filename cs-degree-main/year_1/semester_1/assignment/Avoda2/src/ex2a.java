// Assignment: 2
//Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex2a {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count7 = 0;
        int count0 = 0;
        int countEven = 0;


            System.out.println("Enter a positive integer (or 0 to finish):");
            int input = scan.nextInt();

            while (input!=0) {

                if ((input % 10)==0)                                //add 1 to the 0's counter if the lsd is 0
                    ++count0;

                if ((input % 10) % 2 == 0 && input % 10!=0) {       //add 1 to the Even's counter the lsd is 2
                    ++countEven;
                }

                if ((input % 10) % 7 == 0 && input % 10 != 0) {     //add 1 to the 7's counter the lsd is 7
                    ++count7;
                }
                input = input / 10;

            }
            System.out.println("Even digits: " + countEven);        //print out the results
            System.out.println("7 digits: " + count7);
            System.out.println("0 digits: " + count0);

            count0=0;                                               //reset the counters for the next input
            countEven=0;
            count7=0;

        }

}
