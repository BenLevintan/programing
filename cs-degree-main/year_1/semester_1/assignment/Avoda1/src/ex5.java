// Assignment: 1
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex5 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int row =0,col=0;
        System.out.println("Enter square size:");
        int size = scan.nextInt();
        System.out.println("Enter symbol for diagonals:");
        char c = scan.next().charAt(0);

        while(row < size) {
            col = 0;
            while (col < size) {
                if (col == row || col == (size - row -1))
                    System.out.print(c);                    //printing the input char twice in a line
                else
                    System.out.print("*");
                col++;
            }
            System.out.println();                           //going down after a line is finished

            row++;
        }
    }

}
