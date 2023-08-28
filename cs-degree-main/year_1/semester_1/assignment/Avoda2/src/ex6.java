// Assignment: 2
//Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex6 {

    public static void main(String[] args) {

        boolean isPrime = true;
        boolean isRowPrime = true;

        int arr[][] = new int[4][4];
        int div;

        System.out.println("Enter 16 integers:");

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arr.length; ++i){               //scanning user input into the array
            for (int j = 0; j < arr.length; ++j)
                arr[i][j] = scan.nextInt();
        }

          for(int i =0 ; i < arr.length ; ++i){             //print array
            for (int j = 0; j < arr.length; ++j) {
                System.out.print(arr[i][j] + "\t ");
            }
                 System.out.println();
          }

        isPrime = true;

        for(int i =0 ; i < arr.length ; ++i){                            //go throw all array

            for (int j = 0; j < arr.length; ++j) {

                if(i*j==0 || (i*j)%3==0) {                               //if i and j belong to the frame

                    if(arr[i][j]<2) {                                    //in case number is 1 which is non-prime
                        isPrime = false;
                        break;
                    }

                    for (div = 2; div <= arr[i][j] / 2; ++div) {

                        if (arr[i][j] % div == 0) {                     //breaks inner loop if we found a non-prime number
                            isPrime = false;
                            break;
                        }
                    }

                    if (!isPrime)                                       //breaks main loop if we found a non-prime number
                        break;
                }
            }
            if (!isPrime)                                                //breaks main loop if we found a non-prime number
                break;

        }

        System.out.println(isPrime);                                     //prints if array frame is constructed from only prime numbers

    }
}
