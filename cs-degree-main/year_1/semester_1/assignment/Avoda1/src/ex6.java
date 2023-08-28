// Assignment: 1
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex6 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter three colors: 'r' (red), 'g' (green), 'b' (blue):");
        char a = scan.next().charAt(0);
        char b = scan.next().charAt(0);
        char c = scan.next().charAt(0);

        if( ( a=='r' || a=='g' || a=='b') && ( b=='r' || b=='g' || b=='b') && ( c=='r' || c=='g' || c=='b') ) {

            switch (a + b + c) {                           //sum of the ascii value of char variables a b and c

                case ('r'+'r'+'r'):                        //case is ascii value of 3 'r' chars
                    System.out.println("" + a  + "+" + b  + "+" + c + " give the color red");
                    break;

                case ('g'+'g'+'g'):
                    System.out.println("" + a  + "+" + b  + "+" + c + " give the color green");
                    break;

                case ('b'+'b'+'b'):
                    System.out.println("" + a  + "+" + b  + "+" + c + " give the color blue");
                    break;

                case ('r'+'r'+'g'),('r'+'g'+'g'):
                    System.out.println("" + a  + "+" + b  + "+" + c + " give the color brown");
                    break;

                case ('r'+'r'+'b'),('r'+'b'+'b'):
                    System.out.println("" + a  + "+" + b  + "+" + c + " give the color magenta");
                    break;

                case ('b'+'b'+'g'),('b'+'g'+'g'):
                    System.out.println("" + a  + "+" + b  + "+" + c + " give the color cyan");
                    break;

                default:                                          //since all colors are accounted for, white is the default
                    System.out.println("" + a  + "+" + b  + "+" + c + " give the color white");
                    break;

            }
        }else
            System.out.println("Error in input");
    }

}
