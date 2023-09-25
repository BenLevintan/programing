// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package school;

/**
 * The Teacher class is an abstract class that extends the Employee class. It represents a teacher in a school.
 */
public abstract class Teacher extends Employee {

    /** The subject that the teacher teaches. */
    final String subject;

    /**
     * Constructs a new Teacher object with the specified name, age, salary, and subject.
     *
     * @param name the name of the teacher
     * @param age the age of the teacher
     * @param salary the salary of the teacher
     * @param subject the subject that the teacher teaches
     */
    public Teacher(String name, int age, double salary, String subject){
        super(name, age, salary);
        this.subject = subject;
    }

    /**
     * Returns the subject that the teacher teaches.
     *
     * @return the subject that the teacher teaches
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Abstract method that represents the teacher teaching a class.
     */
    public abstract void teach();

    /**
     * Abstract method that represents the teacher generating a question.
     */
    public abstract void generateQuestion();
}