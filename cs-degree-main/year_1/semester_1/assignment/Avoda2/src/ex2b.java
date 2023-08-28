// Assignment: 2
//Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex2b {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count7 = 0;
        int count0 = 0;
        int countEven = 0;

            while (true) {                                      //loop is always true because of a later break statement

                System.out.println("Enter a positive integer (or 0 to finish):");
                int input = scan.nextInt();

                if (input < 0)                                  //ignore number it is negative by re-entering the loop
                    continue;

                if (input == 0)                                 //end loop if inout is 0
                    break;

                while (input!=0) {                              //same loop as in ex2a

                    if ((input % 10)==0)
                        ++count0;

                    if ((input % 10) % 2 == 0 && input % 10!=0) {
                        ++countEven;
                    }

                    if ((input % 10) % 7 == 0 && input % 10 != 0) {
                        ++count7;
                    }
                    input = input / 10;

                }
                System.out.println("Even digits: " + countEven);
                System.out.println("7 digits: " + count7);
                System.out.println("0 digits: " + count0);

                count0=0;
                countEven=0;
                count7=0;

            }
    }
}


