// Assignment: 3
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex2 {

    public static boolean isPalindrome(int num){

        int digits=0;
        int temp = num;

        while(temp>0){                          //how many  digits does num have
            ++digits;
            temp = temp/10;
        }

        int arr[] = new int[digits];            //make a array

        for(int i=0; i< arr.length ; ++i) {     //turn num into array
            arr[digits - 1 - i] = num % 10;
            num=num/10;
        }


        for(int i = 0 ; i<digits/2 ; ++i){      //check if the 'i' cell and 'last -i' cell are the same

        if(arr[i]!=arr[digits-i-1])             //return false if not
            return false;

        }

        return true;
    }

    public static boolean isPrime(int num){

        if(num==0 || num==1)
            return false;

        for(int i=2; i<=num/2 ; ++i){

            if(num%i==0)
                return false;

        }

        return true;

    }

    public static void printPrimeAndPalindrome(int min,int max){

        for ( ; min<max ; ++min){

            if(isPrime(min) && isPalindrome(min))    //print if number is both prime and palindrome
                System.out.println(min + "  ");

        }

    }

    public static void main(String[] args){
        Scanner stringScanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number to check if it's a palindrome:");
        int number = scan.nextInt();
        System.out.println(isPalindrome(number));

        System.out.println("Enter a number to check if it's a prime number:");
        int input = stringScanner.nextInt();
        System.out.println(isPrime(input));

        System.out.println("Enter a range of numbers (min,max):");
        int min = scan.nextInt();
        int max = scan.nextInt();

        printPrimeAndPalindrome(min,max);



    }
}
