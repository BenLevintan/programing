// Assignment: 3
// Author: Ben Levintan, ID: 318181831

import java.util.Scanner;

public class ex6 {

    public static char[][] MatrixDiagonal(char[][] arr){

        int size = arr.length;
        char[][] diagonals = new char[2][size];

        for (int i =0 ; i < size ; ++i){

            diagonals[0][i] = arr[i][i];                        //main diagonal
            diagonals[1][i] = arr[i][size -1 -i];               //2nd diagonal
        }

        return diagonals;

    }   //put the 2 diagonals of a matrix in an array
    public static void ResetArr(int coordinates[][]){

        coordinates[0][0] = 0;
        coordinates[0][1] = 0;
        coordinates[1][0] = 0;
        coordinates[1][1] = 0;

    }   //put 0 in all arrays values
    public static void Transpose(char arr[][]){

        char tempArr[][] = new char[arr.length][arr.length];

        for (int i=0; i< arr.length;++i)
            for (int j=0; j< arr.length;++j)
                tempArr[i][j] = arr[j][i];

        for (int i=0; i< arr.length;++i)
            for (int j=0; j< arr.length;++j)
                arr[i][j] = tempArr[i][j];

    }          //transpose the matrix (row is now col and col is now row)
    public static int[] FindInRow(char[] arr, String str){

        int[] coor = {0,0};
        char line[] = new char[str.length()];
        int i,j,countChars=0;
        line = str.toCharArray();

        for ( i = 0 ; i< arr.length - line.length + 1; i++){

            countChars = 0;

            for ( j = 0 ; j < line.length ; ++j){

                if(arr[i]==line[j]) {                      //if we found the same char,
                    countChars++;                          //counts how many consecutive chars we found
                    i++;
                }
                else
                    break;
            }

            if(countChars == line.length) {               //if we found the string in the array, change value of coor to start and end
                coor[0] = i - line.length +1;
                coor[1] = i;
                break;
            }
        }

        return coor;
    }  //returns first and last coordinates if string is found, if not (0,0)
    public static char[][] RandoMatrix(){

        int row = (int)(3*Math.random());
        char arr[][] = new char[row+5][row+5];

        for (int i = 0 ; i < arr.length ; ++i )
            for (int j = 0 ; j < arr[0].length ; ++j){
                arr[i][j] = (char)(97 + (int)(22 * Math.random()));
            }

        for (int i = 0 ; i < arr.length ; ++i ) {
            for (int j = 0; j < arr[0].length; ++j) {
                System.out.print("|"+ arr[i][j]);
            }
            System.out.println();
        }

        return arr;

    };     //generates random matrix for testing

    public static boolean isSame(char[] arr, String str){

        boolean isSame=false;
        char line[] = new char[str.length()];
        int i;
        line = str.toCharArray();

            for ( i = 0 ; i< str.length(); i++)
                if (arr[i]!=line[i])
                    break;

            if(i == str.length())
                isSame = true;

       return isSame;
    }

    public static void findString(char arr[][], String str){

        int[][] coordinates = new int[2][2];
        char[][] diagonals = new char[arr.length][2];
        boolean isFound = false;
        int row=0,col=0;
        int count = 0;
        String compare;

        for ( row = 0 ; row < arr.length ; ++row) {       //go throw all the rows

            coordinates[0]=FindInRow(arr[row],str);       //returns coordinates if method found a number, if not. array stays 0
            if(coordinates[0][0]!=0)
                break;

        }

        if(coordinates[0][0]!=0) {
            System.out.print("(" + (row + 1) + "," + coordinates[0][0] + "),");
            System.out.println("(" + (row + 1) + "," + coordinates[0][1] + ")");
        }

        Transpose(arr);                                  //transpose the matrix so we can find the string from top to bottom

        ResetArr(coordinates);

        for ( row = 0 ; row < arr.length ; ++row) {      //go throw all the rows

            coordinates[0]=FindInRow(arr[row],str);      //returns coordinates if method found a number, if not. array stays 0
            if(coordinates[0][0]!=0)
                break;

        }

        if(coordinates[0][0]!=0) {
            System.out.print("(" + coordinates[0][0] + "," + (row + 1) + "),");
            System.out.println("(" +  coordinates[0][1] + "," + (row + 1) + ")");
        }

        ResetArr(coordinates);                          //return matrix to original form

        diagonals = MatrixDiagonal(arr);                //getting an array that contains the diagonals as two rows

        ResetArr(coordinates);                          //return matrix to original form

        coordinates[0]=FindInRow(diagonals[0],str);
        if(coordinates[0][0]!=0) {
            System.out.print("(" + coordinates[0][0] + "," + coordinates[0][0] + "),");
            System.out.println("(" + coordinates[0][1] + "," + coordinates[0][1] + ")");
        }

        ResetArr(coordinates);                     //return matrix to original form

        if(coordinates[0][0]!=0) {
            System.out.print("(" + (arr.length - coordinates[0][0] + 1) + "," + ( coordinates[0][0]) + "),");
            System.out.println("(" + (arr.length - coordinates[0][1] + 1) + "," + (coordinates[0][1] ) + ")");
        }

    }



    public static void main (String arg[]){

        Scanner stringScanner = new Scanner(System.in);

        char arr[][];
        int coor[][];

        arr = RandoMatrix();                                // Used to generate a random matrix and inputs a string
        System.out.println("Please enter a string: ");
        String str = stringScanner.next();

        findString(arr,str);

    }

}
