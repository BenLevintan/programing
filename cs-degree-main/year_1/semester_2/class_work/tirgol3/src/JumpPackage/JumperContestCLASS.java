package JumpPackage;

import java.util.Scanner;

/**
 * jumper contest
 */
public class JumperContestCLASS
{
    public static final double EPSILON=0.01;

    public static void main(String[] args)
    {/**
     * @param Athlete[] athletes;
     * @param jumpHeight   double>0 height jumped
     *
     */

        Athlete[] athletes;
        Jumper[] jumpers;

        //enter the athletes to the competition
        athletes=getAthletes();
        System.out.println("Table of athletes in the competition:");
        printAthletes(athletes);

        //update the athletes that will jump
        jumpers=listJumpers(athletes);
        System.out.println("Table of athletes that will jump");
        printJumpers(jumpers);

        //update heights for each jumper
        jumpers=updateHeights(jumpers);
        System.out.println("Table of heights each jumper jumped");
        printJumpers(jumpers);

        //print all the pairs of jumpers which have the same score
        printDoubles(jumpers);
    } // main


    /**
     * creates an array of Athlete
     * @return Athlete[]
     */
    public static Athlete[] getAthletes(){
        Athlete[] athletes;
        int athletesNum;
        String athleteName;
        String athleteId;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of athletes that will participate in the event: ");
        athletesNum = in.nextInt();
        athletes = new Athlete[athletesNum];
        for (int i = 0; i < athletesNum; i++) {
            System.out.print("Enter Athlete Name: ");
            athleteName = in.next();
            System.out.print("Enter Athlete Id: ");
            athleteId = in.next();

            //FIX PART I: create a constructor in Athlete for the next line
            // athletes[i] = new Athlete(athleteName, athleteId);
        }
        return athletes;
    }//getAthlete method
    public static void printAthletes(Athlete[] athletes){
        // FIX PART II
        // write a code that will print all the athletes in array Athletes
        // (the order of the Athletes is not important)
    }
    public static void printJumpers(Jumper[] jumpers){
        for (int i = 0; i <jumpers.length ; i++) {
            System.out.println(jumpers[i].toString());
        }// for i
    }
    public static Jumper[] listJumpers(Athlete[] athletes){
        boolean[] athletesJumping = new boolean[athletes.length];//used for tracking which athletes were saved in jumpers array
        Jumper[] jumpers;
        int jumperNum;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of athletes that want to jump: ");
        jumperNum = in.nextInt();
        jumpers = new Jumper[jumperNum];
        int jumperCount=0;
        while (jumperCount<jumpers.length)
         {
            System.out.print("Enter Athlete-Number: ");
            jumperNum = in.nextInt();
//
// FIX THIS PART III
// jumperNum is a number the user inserted:
// 1. check that it is a valid "athlete-number" (hint: larger or equal to 100, and less or equal to....)
// 2. check in array "athletes" which cell points to Athlete with jumperNum.
// 3. check that this athlete was not saved already in "jumpers" array (hint: use the boolean array athletesJumping)
// 4. if jumperNum is a "athlete-number" of an Athlete that is NOT in jumpers array add it to jumpers array
// do not forget to update the boolean array    athletesJumping.
//
        }//while
        return jumpers;
    }//method listJumpers

    /**getIndexOfAthlete is a method that helps with "FIX PART III" (you may write your code with or without this function)
     * returns the index in "athletes" array of the "athlete-number" if it is in the array of athletes
     * @param athletes
     * @param jumperNum
     * @return index of athlete or -1 if is not found
     */
    public static int getIndexOfAthlete(Athlete[] athletes,boolean[] athletesJumping,int jumperNum){

        return -1;
    }// method getIndexOfAthlete
    public static Jumper[] updateHeights(Jumper[] jumpers){
        Scanner in = new Scanner(System.in);
        System.out.println("\nFor each of the next jumpers please enter the jumped height:" +
                "\n============================================================");
        for (int i = 0; i < jumpers.length; i++) {
            System.out.println(jumpers[i]+"\nPlease enter height:");
            //FIX PART IV:
            // 1. get input from use of the height the Athlete jumped.
            // 2. update the "height" the jumper jumped in the correct Jumper object
            //
            //

        }//for i
        return jumpers;
    }//updateHeights method
    public static void printDoubles(Jumper[] jumpers){
        for (int i = 0; i < jumpers.length-1; i++)
        {
            for (int j = i+1; j < jumpers.length; j++)
            {
             // FIX PART V:
             // for each two Jumper objects:
             // if they jumped the same height
             // then print the two jumpers
             //  and print also the height they jumped

            } // for j
        } // for i
    }// printDoubles method
} // class JumperContest

