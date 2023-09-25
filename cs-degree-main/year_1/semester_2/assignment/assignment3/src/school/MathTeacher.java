// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package school;

import java.util.Scanner;

/**
 * A MathTeacher is a type of Teacher who teaches math and generates math questions for students to solve.
 */
public class MathTeacher extends Teacher {

    /**
     * Creates a new MathTeacher object with the specified name, age, and salary.
     *
     * @param name   the name of the MathTeacher
     * @param age    the age of the MathTeacher
     * @param salary the salary of the MathTeacher
     */
    public MathTeacher(String name, int age, double salary){
        super(name,age,salary,"Math");
    }

    /**
     * Displays a message indicating that the math teacher is working.
     */
    public void work(){
        System.out.println("The math teacher is working.");
    }

    /**
     * Displays a message indicating that the math teacher is teaching math.
     */
    public void teach(){
        System.out.println("The math teacher is teaching math. ");
    }

    /**
     * Generates a multiplication question for students to solve and checks their answer.
     * Uses a Scanner object to read the student's answer from the console.
     * If the student's answer is correct, displays a message indicating so. Otherwise, displays the correct answer.
     */
    @Override
    public void generateQuestion(){

        Scanner scanner = new Scanner(System.in);

        int a = (int)(11 * Math.random());
        int b = (int)(11 * Math.random());

        System.out.println("calculate the following: " + a + " x " + b + " = ");

        System.out.print("Please enter your answer : ");
        int answer = scanner.nextInt();

        if (answer == a*b)
            System.out.println("Well done your answer is correct");
        else
            System.out.println("Your answer is incorrect. The correct answer is: " + b*a);

    }

}
