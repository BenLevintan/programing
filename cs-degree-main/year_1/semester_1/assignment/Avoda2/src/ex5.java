// Assignment: 2
//Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex5 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        int countDivisors;
        int maxDiv = 0;
        int i;

        System.out.println("Enter low integer:");
        int low = scan.nextInt();
        System.out.println("Enter high integer:");
        int high = scan.nextInt();

        int arr[][] = new int[high - low + 2][2];                                     //first row is numbers (low to high), second is the number of divisors

        for ( i = 0; i < high - low + 1 ; ++i) {                                      //main loop start

            arr[i][0] = low + i;                                                      // entering the value of each int within the range the user gave us in arr[i][0]
            countDivisors = 0;


                for (int divCheck = 1; divCheck <= arr[i][0]; ++divCheck) {           //this loop counts the number of divisors

                    if (arr[i][0] % divCheck == 0)
                        countDivisors++;

                }

                arr[i][1] = countDivisors;                                            //enters the num of divisors the number in a[i][1] has

                if (countDivisors > maxDiv)                                           //if we found a number with more divisors, that's the new max
                    maxDiv = countDivisors;

        }                                                                             //main loop end

        System.out.println("Maximal number of divisors is: " + maxDiv);

        for(i=0; i< arr.length-1; ++i)
            if(arr[i][1]==maxDiv)
                System.out.println(arr[i][0] + " has " + maxDiv + " divisors");

    }
}
