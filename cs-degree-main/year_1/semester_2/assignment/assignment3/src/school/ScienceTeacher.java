// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package school;
import java.util.Scanner;

/**
 * A ScienceTeacher is a type of Teacher who teaches Science.
 */
public class ScienceTeacher extends Teacher {

    /**
     * Constructs a ScienceTeacher object with the specified name, age, and salary.
     *
     * @param name   the name of the ScienceTeacher
     * @param age    the age of the ScienceTeacher
     * @param salary the salary of the ScienceTeacher
     */
    public ScienceTeacher(String name, int age, double salary){
        super(name, age, salary, "Science");
    }

    /**
     * Prints a message indicating that the science teacher is working.
     */
    public void work(){
        System.out.println("The science teacher is working.");
    }

    /**
     * Prints a message indicating that the science teacher is teaching science.
     */
    public void teach(){
        System.out.println("The science teacher is teaching science");
    }

    /**
     * Generates a physics question and prompts the user to enter an answer.
     * If the answer is correct, prints a message indicating so; otherwise, prints
     * a message indicating the correct answer.
     */
    @Override
    public void generateQuestion(){
        Scanner scanner = new Scanner(System.in);

        double mass = 101 * Math.random();
        double a = 11 * Math.random();

        System.out.println("A " + mass + " gram object is accelerating at " + a + " m/s^2.\nWhat is the resulting force in Newtons?");

        System.out.print("Please enter your answer : ");
        double answer = scanner.nextDouble();

        if (answer == mass*a)
            System.out.println("Well done your answer is correct");
        else
            System.out.println("Your answer is incorrect. The correct answer is: " + mass*a);

    }
}
