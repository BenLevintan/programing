// Assignment: 1
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter 3 line lengths:");
        float a = scan.nextFloat();
        float b = scan.nextFloat();
        float c = scan.nextFloat();

        if(a<=0 || b<=0 || c<=0)                                        //checking if values are over 0
            System.out.println("Error");
        else if( a+b<=c || b+c<=a )                                     //checking if no 2 edges are shorter than the third
            System.out.println("We cannot make a triangle from these edges.");
        else if( ((a-b==0) || (a-c==0)) || (b-c==0) )                   //checking equilateral first, because it fits isosceles as well
            System.out.println("equilateral triangle");
        else if( (a-b==0) && (a-c==0) )                                 //if a-b=0 that means a=b
            System.out.println("isosceles triangle");
        else
            System.out.println("Scalene triangle");
    }

}
