// Assignment: 3
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;
public class ex4 {

    public static int CharToInt(char c){

        int num = (int)c-48;
        return num;

    }              //turns int char to an int value that represents his value

    public static int Validator(String ID) {

        int validator=0;
        int sum=0;
        int adder;

        for (int i=0 ; i<8 ; ++i) {                       // go throw all the ID numbers

            adder = CharToInt(ID.charAt(i)) * (i % 2 + 1);    //see how much you need to add to sum

            if(adder>9)                                   //if adder was greater ot equal to 10, sum up the digits (max value is 2*9=18)
                adder = 1 + adder%10;

            sum = sum + adder;                            //add adder to total sum

        }

        validator = 10 - sum%10;                          //calculate the validator

        return validator%10;                              //return 0 if validator is 10

    }          //calculates the value of the validator

    public static void main(String args[]){


        System.out.println("Please enter ID number");
        Scanner stringScanner = new Scanner(System.in);
        String ID = stringScanner.next();

        System.out.println(Validator(ID));
    }
}
