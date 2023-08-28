// Assignment: 1
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex4 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int i =0,sum=0,lsd,weight=1,og;
        System.out.println("Enter a non-negative binary number with up to ten digits:");
        int in = scan.nextInt();
        og =in;                                         //og is original value of user input

        while( i < 10){
            lsd = in%10;                                //getting the lsd (the least significant digit)
            sum = sum + lsd*(weight);                   //sum is the value of all digits thus far in base 10
            in = in/10;                                 //removes the lsd we already accounted for
            i++;
            weight  = weight *2;                        //represents the value that a digit adds to the sum (digit index^2)
        }

        System.out.println( og + " (in base 2) = " + sum + " (in base 10)");

    }

}
