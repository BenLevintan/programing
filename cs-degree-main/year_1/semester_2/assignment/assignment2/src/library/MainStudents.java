// Assignment: 2
// Author: Ben Levintan, ID: 318181831
package library;
import java.util.Scanner;
public class MainStudents {

    /**
     * Returns the simple name of a given publication based on its type.
     * @param publication the publication to retrieve the simple name for
     * @return the simple name of the publication
     */
    public static String getsimpleName(Publication publication){

        if (publication instanceof Book){
            return "book";
        }

        if (publication instanceof Journal && !(publication instanceof Article)){
            return "Jrnl";
        }

        if (publication instanceof Article) {
            return "Artl";
        }

        if (publication instanceof Encyclopedia) {
            return "Ency";
        }

        return "publ";
    }

    /**
     * Prints the list of students along with their details such as student ID, name, and the number of loaned publications.
     * @param list the array of students to be printed
     */
    public static void printStudents(Student[] list){

        for(int i = 0 ; list[i] != null  ; ++i)
            System.out.println("Student number:" + list[i].getSTUDENTID() + "\tname:" + list[i].getStudentName() + "  loaned-publications:" + list[i].getLoanedNum());

    }
    /**
     * Prints the details of a single student such as student ID, name, and the number of loaned publications.
     * @param stu the student to be printed
     */
    public static void printStudent(Student stu) {
        System.out.println("Student number:" + stu.getSTUDENTID() + "\tname:" + stu.getStudentName() + "  loaned-publications:" + stu.getLoanedNum());
    }
    /**
     * Prints the loan report of a given student, including their details and the list of loaned publications.
     * @param student the student to generate the loan report for
     */
    public static void loanReport(Student student){

        System.out.println("\nLoan Report:\nStudent number:" + student.STUDENTID + "\tname:" + student.studentName +
            " loaned-publications:" + student.loanedNum + "\nList of loaned publications:");

        for (int i = 0 ; i<3 && student.getLoaned()[i]!= null ; ++i) {
            System.out.println(student.getLoaned()[i].toString());
        }

        if(student.getLoaned()[0]==null)
            System.out.println("this student has no loaned publications.");

        System.out.println();
    }
    /**
     * Prints the current status of the publications in the library.
     * @param publications the array of publications to generate the report for
     */
    public static void publicationReport(Publication[] publications) {
        System.out.println("Report on library status:\n============================");
        for(int i = 0 ; publications[i]!=null ; ++i)
            System.out.println(publications[i].NUMBER + "-" + getsimpleName(publications[i]) + "\t qty:"+ publications[i].qty + " '" + publications[i].getTitle() + "'");
    }

    /**
     * Adds a publication to a student's loan list and removes it from the library list.
     * @param student the student to loan the publication to
     * @param publication the publication to be loaned
     */
    public static void addPublication(Student student, Publication publication){
        int i =0;
        while(i<3 && student.loaned[i]!=null)     //go to the next vacant publication slot
            ++i;
        publication.setQty(publication.qty-1);    //remove one copy from qty
        student.loaned[i] = publication;          //put it in student loan list
        student.loanedNum++;                      //add to the number of loans

    }

    /**
     * Counts the number of students in a given array.
     * @param students the array of students to be counted
     * @return the number of students in the array
     */
    public static int countStudents(Student[] students){
        int i = 0;
        while(students[i]!=null)
            ++i;
        return i-1;
    }
    /**
     * Counts the number of publications in a given array.
     * @param publications the array of publications to be counted
     * @return the number of publications in the array
     */
    public static int countPublications(Publication[] publications){
        int i = 0;
        while(publications[i]!=null)
            ++i;
        return i-1;
    }

    /**
     * Returns the index of a given publication in a publication array, based on its NUMBER field.
     * @param publications the array of publications to search
     * @param number the NUMBER field of the publication to search for
     * @return the index of the publication with the given NUMBER, or -1 if not found
     */
    public static int findIndex(Publication[] publications, int number){

        for(int i = 0 ; publications[i]!=null ; ++i )
            if (publications[i].NUMBER==number)
                return i;

        return -1;
    }

    /**
     Allows students to loan publications from the library.
     @param student an array of Student objects containing student information
     @param publications an array of Publication objects containing publication information
     */
    public static void loanPublication(Student[] student,Publication[] publications){

        Scanner scan = new Scanner(System.in);
        int studentNumber;
        int publicationNumber;
        int publicationIndex;
        boolean bookFound = false;

        System.out.println("\nWelcome to the library. Start loan:");

        do {
            //get the number of the student
            System.out.println("\nInsert student number [0,3]:");
            studentNumber = scan.nextInt();

            //break if user entered -1
            if (studentNumber == -1)
                break;
            //get the number of the publication
            System.out.println("Insert publication number [10," + publications.length + "]:");
            publicationNumber = scan.nextInt();
            publicationIndex = findIndex(publications, publicationNumber);

            //checks input
            if (studentNumber > countStudents(student) || publicationNumber < 10 || publicationNumber - 10 > countPublications(publications) + 10) {
                System.out.println("error, input not right");
                continue;
            }

                //if student has 3 loans, end loop
                if (student[studentNumber].loanedNum >= 3) {
                    System.out.print("Load report: Loan failed - student has already loaned 3 publications");
                    loanReport(student[studentNumber]);
                    continue;
                }

                //if publication is available and student has less the 3 book, give book
                if (publications[publicationIndex].qty > 0) {
                    addPublication(student[studentNumber], publications[publicationIndex]);
                    loanReport(student[studentNumber]);
                    System.out.println("Successful loan of: \n" + publications[publicationIndex].NUMBER + "-" + getsimpleName(publications[publicationIndex]) + "\t\tqty:" + publications[publicationIndex].qty +" "+publications[publicationIndex].title);
                    continue;
                }

                if (publications[publicationIndex].qty == 0) {
                    System.out.println("Load report: Loan failed - out of stock. " + publications[publicationIndex].NUMBER + "-" + getsimpleName(publications[publicationIndex]) + "\t\tqty:" + publications[publicationIndex].qty +" "+publications[publicationIndex].title);
                }

            }
            while (true) ;

            publicationReport(publications);
    }

    public static void main(String[] args) {
        Student[] students = new Student[100];
        students[0]=new Student("Albert Einstein");
        students[1]= new Student("Marie Curie");
        students[2]= new Student("Rosalind Franklin");
        students[3]= new Student("Stephen Hawking");

        Publication[] publications = new Publication[100];
        Author[] authors = new Author[100];
        authors[0] = new Author("Harper Lee","harper@somwhere.com");
        authors[1] = new Author("F. Scott Fitzgerald","scott@somwhere.com");
        authors[2] = new Author("Amos Oz","oz@somwhere.com");
        authors[3] = new Author("Giora Alexandron","giora@somwhere.com");
        authors[4] = new Author("Avraham Aizenbud","avi@somwhere.com");
        authors[5] = new Author("Ezra Hadad","ezra@somwhere.com");

        publications[0]= new Book("To Kill a Mockingbird", "J. B. Lippincott & Co.",
                2, authors[0],"Tay Hohoff", 1960);
        publications[1]=new Article("Teva Hadvarim","Hahevra le-Heker Haadam ve-Hasovev ltd",0,297,2020,
                "Yanshuf Aezim", authors[5],
                "http://www.tevahadvarim.co.il/wp-content/uploads/2020/11/297_farticle_pdf_9.pdf");
        publications[2]=new Journal("Scientific American", "Springer Nature", 5, 135, 2021);
        publications[3]=new Encyclopedia("Encyclopedia Britannica", "Encyclopedia Britannica, Inc.", 1, "",1);
        publications[4]=new Article("Masa Hakesem Hamadaii","Weizmann IOS",0,102,2021,
                "Alufot Eropa le-Mathematica", authors[4],
                "https://heb.wis-wander.weizmann.ac.il/computer-science-math/n-11335");
        publications[5]=new Encyclopedia("Encyclopedia Britannica", "Encyclopedia Britannica, Inc.", 1, "",3);
        publications[6]=new Book("The Great Gatsby", "Charles Scribner's Sons",
                1, authors[1],"Maxwell Perkins", 1925);
        publications[7]=new Journal("Teva Hadvarim","Hahevra le-Heker Haadam ve-Hasovev ltd",5,297,2020);
        publications[8]=new Encyclopedia("Encyclopedia Americana", "Scholastic Corporation", 1, "", 30);
        publications[9]=new Book("Sippur Al Ahava VeChoshech", "Houghton Mifflin Harcourt",
                1, authors[2],"", 2002);
        publications[10]=new Article("Masa Hakesem Hamadaii","Weizmann IOS",0,106,2022,
                "AI (artificial intelligence) is upgrading", authors[3],
                "https://heb.wis-wander.weizmann.ac.il/science-teaching/n-11735");
        publications[11]=new Encyclopedia("Encyclopedia Britannica", "Encyclopedia Britannica, Inc.", 1, "",2);
        publications[12]=new Journal("Nature","Springer Nature",
                5,  590,2021 );


        Publication.sort(publications);

        loanPublication(students,publications);

    }

}
