// Assignment: 2
//Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char a1 = '_', a2 = '_', a3 = '_', b1 = '_', b2 = '_', b3 = '_', c1 = '_', c2 = '_', c3 = '_';
        int winnerFlag;      //indicates we found a winner
        int i;

        System.out.println("The table result:");
        System.out.println(a1 + "" + a2 + "" + a3 );         //print matrix
        System.out.println(b1 + "" + b2 + "" + b3 );
        System.out.println(c1 + "" + c2 + "" + c3 );

        for(i = 1; i<=9 ; i++){
            winnerFlag = 0;
            if(i%2==1){
                while(winnerFlag == 0) {
                    System.out.print("Enter row and column for player x: ");    // enter coordinates
                    int x = scan.nextInt();
                    int y = scan.nextInt();

                    if ((x == 1 && y == 1) && a1 == '_') {                      //  change value to X
                        a1 = 'X';
                        winnerFlag = 1;
                    } else if ((x == 1 && y == 2) && a2 == '_') {
                        a2 = 'X';
                        winnerFlag = 1;
                    } else if ((x == 1 && y == 3) && a3 == '_') {
                        a3 = 'X';
                        winnerFlag = 1;
                    } else if ((x == 2 && y == 1) && b1 == '_') {
                        b1 = 'X';
                        winnerFlag = 1;
                    } else if ((x == 2 && y == 2) && b2 == '_') {
                        b2 = 'X';
                        winnerFlag = 1;
                    } else if ((x == 2 && y == 3) && b3 == '_') {
                        b3 = 'X';
                        winnerFlag = 1;
                    } else if ((x == 3 && y == 1) && c1 == '_') {
                        c1 = 'X';
                        winnerFlag = 1;
                    } else if ((x == 3 && y == 2) && c2 == '_') {
                        c2 = 'X';
                        winnerFlag = 1;
                    } else if ((x == 3 && y == 3) && c3 == '_') {
                        c3 = 'X';
                        winnerFlag = 1;
                    } else
                        System.out.println("enter a valid coordinate");
                }

            }else while(winnerFlag == 0) {
                System.out.print("Enter row and column for player o: ");        // enter coordinates
                int x = scan.nextInt();
                int y = scan.nextInt();

                if ((x == 1 && y == 1) && a1 == '_') {                           //  change value to O
                    a1 = 'O';
                    winnerFlag = 1;
                } else if ((x == 1 && y == 2) && a2 == '_') {
                    a2 = 'O';
                    winnerFlag = 1;
                } else if ((x == 1 && y == 3) && a3 == '_') {
                    a3 = 'O';
                    winnerFlag = 1;
                } else if ((x == 2 && y == 1) && b1 == '_') {
                    b1 = 'O';
                    winnerFlag = 1;
                } else if ((x == 2 && y == 2) && b2 == '_') {
                    b2 = 'O';
                    winnerFlag = 1;
                } else if ((x == 2 && y == 3) && b3 == '_') {
                    b3 = 'O';
                    winnerFlag = 1;
                } else if ((x == 3 && y == 1) && c1 == '_') {
                    c1 = 'O';
                    winnerFlag = 1;
                } else if ((x == 3 && y == 2) && c2 == '_') {
                    c2 = 'O';
                    winnerFlag = 1;
                } else if ((x == 3 && y == 3) && c3 == '_') {
                    c3 = 'O';
                    winnerFlag = 1;
                } else
                    System.out.println("enter a valid coordinate");
            }

            System.out.println("The table result:");
            System.out.println(a1 + "" + a2 + "" + a3 );         //print matrix
            System.out.println(b1 + "" + b2 + "" + b3 );
            System.out.println(c1 + "" + c2 + "" + c3 );

            if((a1=='X' && a2=='X' && a3=='X') || (b1=='X' && b2=='X' && b3=='X') || (c1=='X' && c2=='X' && c3=='X')               // X's win con
                    || (a1=='X' && b1=='X' && c1=='X') || (a2=='X' && b2=='X' && c2=='X') || (a3=='X' && b3=='X' && c3=='X')
                    || (a1=='X' && b2=='X' && c3=='X') || (a3=='X' && b2=='X' && c1=='X')
            ) {
                System.out.println("The winner is X !!!!!");
                break;
            }else


            if((a1=='O' && a2=='O' && a3=='O') || (b1=='O' && b2=='O' && b3=='O') || (c1=='O' && c2=='O' && c3=='O')               // O's win con
                    || (a1=='O' && b1=='O' && c1=='O') || (a2=='O' && b2=='O' && c2=='O') || (a3=='O' && b3=='O' && c3=='O')
                    || (a1=='O' && b2=='O' && c3=='O') || (a3=='O' && b2=='O' && c1=='O')
            ) {
                System.out.println("The winner is O !!!!!");
                break;
            }

        }

        if(i==10) {                                              //if the loop reached the end, display tie
            System.out.println("I'ts a tie, so no winners.");
        }
    }
}
