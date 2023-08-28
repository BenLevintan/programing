// Assignment: 2
//Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arr[] = new int[10];
        int temp;

        System.out.println("Enter 10 integers (0 is not allowed):");

        for(int i =0 ; i < arr.length ; ++i)                  //scanning 10 values from user to use in  the array
            arr[i] = scan.nextInt();

        for(int i=0 ;i < arr.length ; i=i+2) {

            if (arr[i] % arr[i + 1] == 0) {                   //if a[i] is divisible by a[i+1], swap them

                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

            }
        }

            for(int i =0 ; i < arr.length ; ++i)             //print new array
                System.out.print(arr[i] + " ");

    }
}
