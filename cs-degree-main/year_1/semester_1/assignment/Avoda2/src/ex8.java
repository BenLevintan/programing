import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arr[][]=new int[9][9];
        int check3[] = new int [9];
        boolean wasFound=false;
        int i,j,num;

        System.out.println("Enter sudoku table");

        for ( i = 0; i < arr.length; ++i){              //scanning user input into the array
            for ( j = 0; j < arr.length; ++j)
                    arr[i][j] = scan.nextInt();
        }

        for( i =0 ; i < arr.length ; ++i){              //print array
            for ( j = 0; j < arr.length; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for ( i = 0; i < arr.length; ++i){              //checking all columns have numbers 1 to 9

            for (num = 1 ; num < 10 ; num++){           //running numbers from 1 to 9
                wasFound = false;

                for (j = 0; j < arr.length ; ++j){      //checking if we found said number
                    if(num == arr[i][j]) {
                        wasFound = true;
                        break;
                    }
                }

                if(!wasFound)                         //missing number from the row? break the inner loop
                    break;
            }
            if(!wasFound)                             //break outer loop
                break;
        }


        for ( i = 0; i < arr.length; ++i){                //checking all rows have numbers 1 to 9

            for (num = 1; num < 10; num++){               //running numbers from 1 to 9
                wasFound = false;

                for( j=0; j < arr.length ; ++j){          //checking if we found said number
                    if(num==arr[j][i]) {
                        wasFound = true;
                        break;
                    }
                }

                if(!wasFound)                          //missing number from the row? break the inner loop
                    break;
            }
            if(!wasFound)                              //break outer loop
                break;
        }

        for (i = 0; i < 7 ; ++i){                      //go through the array till 6x6
            for (int a = 0; a < 7; ++a) {

                if(i % 3 == 0 && a % 3 == 0){                //checking if the cell belongs to the top left of 3x3 square
                num = 0;

                    for ( int x = 0; x < 3; ++x){

                        for( int y = 0; y < 3 ; ++y){        //turn a 3X3 array to a vector (array[8])

                            check3[num] = arr[x+i][a+y];
                            ++num;
                        }
                    }

                    int check3_len = check3.length;
                    for ( int check = 0; check < check3.length; ++check){            //checking all rows have numbers 1 to 9

                        for(num=1 ; num<10 ; num++){                                 //running numbers from 1 to 9
                            wasFound = false;

                            for( j=0; j < check3.length ; ++j){                      //checking if we found said number
                                if(num==check3[j]) {
                                    wasFound = true;
                                    break;
                                }
                            }

                            if(!wasFound)                         //missing number from the row? break the inner loop
                                break;
                        }
                        if(!wasFound)                             //break outer loop
                            break;
                    }

                    if(!wasFound)                                 //break mid loop
                        break;
                }

                if(!wasFound)                                     //break outer loop
                    break;

            }
            if(!wasFound)
                break;
        }

        if(wasFound)
            System.out.println("The sudoku table is OK");
        else
            System.out.println("The sudoku table is WRONG");

    }
}