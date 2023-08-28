// Assignment: 3
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex1 {
    public static void stars(int rows){

        int first,last;

        first = rows/2 + 1;
        last = rows/2 + 1;

        for(int i = 0 ; i<=rows/2+1 ; ++i){      //prints the top triangle

            for (int j=1 ; j<=rows ; ++j){

                if( j > first && j < last )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
            --first;
            ++last;
        }

        ++first;
        --last;

        for(int i = 0 ; i<=rows/2 ; ++i){      //prints the bottom triangle

            for (int j=1 ; j<=rows ; ++j){

                if(i==0)                       //don't print the first row of the bottom triangle
                    break;

                if( j > first && j < last )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
                if(i!=0)                       //don't go down a row for the first time
                    System.out.println();

            ++first;
            --last;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("please enter a positive uneven number");

        int rows = scan.nextInt();

        stars(rows);

    }
}
