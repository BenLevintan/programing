package school;
/**
 * The Employee class is an abstract class that represents an employee in a school.
 * It has three attributes: name, age, and salary.
 */
public abstract class Employee {
    /** The name of the employee */
    String name;
    /** The age of the employee */
    int age;
    /** The salary of the employee */
    double salary;
    /**
     * Returns the name of the employee.
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the employee.
     * @param name the name of the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the employee.
     * @return the age of the employee
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the employee.
     * @param age the age of the employee
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the salary of the employee.
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     * @param salary the salary of the employee
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Constructs an Employee object with the specified name, age, and salary.
     * @param name the name of the employee
     * @param age the age of the employee
     * @param salary the salary of the employee
     */
    public Employee (String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    /**
     * Constructs an Employee object with default values for name, age, and salary.
     */
    public Employee (){
        this.name = "";
        this.age = 0;
        this.salary = 0;
    }
    /**
     * An abstract method that will be overwriten in the son classes
     */
    public void work(){}

}
