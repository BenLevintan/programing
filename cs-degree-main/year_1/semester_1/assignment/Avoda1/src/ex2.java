// Assignment: 1
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the distance:");
        float l = scan.nextFloat();                                                           //getting the length value of the line

        System.out.println("Pipes we need for the line");
        System.out.println("Pipes of length 10 meters: " + (int) l / 10 + " units");          //printing how many times 10m fits in length
        l = l % 10;                                                                           //getting rid of how many times a 10m pipe fits in the line
        System.out.println("Pipes of length 5 meters: " + (int) l / 5 + " units");
        l = l % 5;                                                                            //same for 5m...
        System.out.println("Pipes of length 1 meters: " + (int) l + " units");
        l = l % 1;
        System.out.println("Pipes of length 25 cm: " + (int) (l / 0.25) + " units");
        l = (4 * l % 1) / 4;                                                                  //multiplying by 1/(pipe length) so we can use %, then dividing by pipe length
        System.out.println("Pipes of length 5 cm: " + (int) (l / 0.05) + " units");
        l = (20 * l % 1) / 20;
        System.out.println("Pipes of length 1 cm: " + (int) (l / 0.01) + " units");
    }

}
