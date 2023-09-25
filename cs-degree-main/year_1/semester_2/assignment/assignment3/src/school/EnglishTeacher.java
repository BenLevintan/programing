package school;
import java.util.Scanner;
/**
 * Represents an English teacher in a school.
 * An English teacher is a teacher who teaches the English language and literature.
 */
public class EnglishTeacher extends Teacher{
    /**
     * Constructs a new EnglishTeacher object with the specified name, age, and salary.
     * Sets the subject taught by the English teacher to "English".
     *
     * @param name   the name of the English teacher
     * @param age    the age of the English teacher
     * @param salary the salary of the English teacher
     */
    public EnglishTeacher (String name, int age, double salary){
        super(name,age,salary,"English");
    }
    /**
     * Prints a message indicating that the English teacher is working.
     */
    public void work(){
        System.out.println("The english teacher is working.");
    }
    /**
     * Prints a message indicating that the English teacher is teaching English.
     */
    public void teach(){
        System.out.println("The english teacher is teaching english. ");
    }
    /**
     * Generates a question related to the English language and prompts the user to answer it.
     * Overrides the generateQuestion() method in the Teacher class.
     */
    @Override
    public void generateQuestion(){

        Scanner scanner = new Scanner(System.in);

        String word[] = {"cat", "dog", "tree", "book", "cup", "sun", "moon", "star", "car", "house"};
        String task[] = {"Spell", "Define", "Use in a sentence", "Rhyme with", "Antonym of", "Synonym of"};

        int wordIndex = (int)(10 * Math.random());
        int taskIndex = (int)(7 * Math.random());

        System.out.println( task[taskIndex] + " the word '" + word[wordIndex] + "'.\n" + "Please enter your answer :");

        String answer = scanner.nextLine();

        System.out.println("Your answer is: " + answer);

    }

}
