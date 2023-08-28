// Assignment: 3
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;
public class ex5 {

    public static int[] countChars(String str){

        int arr[] = new int [4];

        for ( int i = 0 ; i < str.length() ; ++i){

            if (str.charAt(i)>=65 && str.charAt(i)<=90)             //if ascii value belongs to big letters
                ++arr[0];

            else if (str.charAt(i)>=97 && str.charAt(i)<=122)       //if ascii value belongs to small letters
                ++arr[1];

            else if (str.charAt(i)>=48 && str.charAt(i)<=57)        //if ascii value belongs to digits
                ++arr[2];
            else                                                    //if ascii value does not belong
                ++arr[3];

        }

        return arr;
    }

    public static void main(String arg[]){

        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Please enter a string: ");

        String str = stringScanner.next();

        int arr[] = new int[4];

        arr = countChars(str);             //get the array location from the method

        for(int i=0 ; i<countChars(str).length ; ++i)
            System.out.println(arr[i]);

    }


}
