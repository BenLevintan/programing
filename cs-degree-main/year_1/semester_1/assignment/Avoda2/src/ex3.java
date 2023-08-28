// Assignment: 2
//Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCounter = 0;
        float maxInput=0;
        float minInput;

        System.out.println("Enter a positive integer (or 0 or negative number to finish): ");
        float input = scan.nextFloat();
        minInput = input;

        while (input>0){

            if(input>maxInput)                                 //if you got a bigger number its the new max
                maxInput = input;

            if(input<minInput)                                 //if you got a smaller number then the smallest, its the new min
                minInput = input;

            ++inputCounter;                                    //any time we enter the loop meaning input bigger than 0, add to positive num count

            System.out.println("Enter a positive integer (0 or negative number to finish): ");
            input = scan.nextFloat();

        }

        if(maxInput == 0)                                      //default value of maxInput is 0, so if we never entered the loop we didn't get any positive numbers
            System.out.println("No positive numbers were entered!");
        else{
            System.out.println("Positive numbers entered: " + inputCounter);
            System.out.println("Minimal number: " + minInput);
            System.out.println("Maximal number: " + maxInput);
        }

    }
}