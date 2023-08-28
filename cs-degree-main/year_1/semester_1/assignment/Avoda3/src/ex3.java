// Assignment: 3
// Author: Ben Levintan, ID: 318181831

public class ex3 {

    public static boolean hadAppeared(int arr[][]){

        int size=arr.length;
        boolean numbers[] = new boolean[size*size];        //crates row of n^2 numbers
        int num;

        for (int i=0; i< arr.length;++i)                   //go throw all the matrix
            for (int j=0; j< arr.length;++j)
                numbers[arr[i][j]-1]=true;                 //change to true in the index of 'value in cell -1'

        for (int i =0; i< numbers.length; ++i)             //if we found a false -> that means a number between 1 and n^2 didn't appear
            if(!numbers[i])
                return false;

        return true;
    }     //checking if each number (1 to n^2) nad appeared

    public static boolean diagonalEqual(int arr[][]){

        int size=arr.length;
        int value = size*(size*size+1)/2;
        int sum=0;

        for(int i =0 ; i<arr.length ; ++i)        //sums up all cells from top left to bottom right
            sum = sum+arr[i][i];

        if(sum!=value)                            //if the sum don't add up to the value, end and return false (not magic)
            return false;

        sum =0;

        for(int i =0 ; i<arr.length ; ++i)
            sum = sum+arr[i][arr.length-i-1];    //sum up all cells from top right to bottom left

        if(sum!=value)                           //if the sum don't add up to the value, end and return false (not magic)
            return false;

        return true;                             //both sums equal to value? awesome! the diagonals are fitting for a magic matrix
    }   //checks if both diagonals equals to value

    public static boolean RowSumEqual(int arr[][]){         //checks if sum of a row equal to value

        int size=arr.length;
        int value = size*(size*size+1)/2;

        for (int i = 0 ; i< arr.length ; ++i ) {            //go throw all the rows in the array
            int sum = 0;
            for (int j = 0; j < arr.length; ++j) {          //sum up all the numbers un said array
                sum = sum + arr[i][j];
            }
            if (sum != value)                               //if sum is not value return false
                return false;
        }
        return true;

    }     //checks if all rows are equals to value

    public static void Transpose(int arr[][]){

        int tempArr[][] = new int[arr.length][arr.length];

        for (int i=0; i< arr.length;++i)
            for (int j=0; j< arr.length;++j)
                tempArr[i][j] = arr[j][i];

        for (int i=0; i< arr.length;++i)
            for (int j=0; j< arr.length;++j)
                arr[i][j] = tempArr[i][j];

    }          //transpose the matrix (row is now col and col is now row)

    public static boolean isMagic(int arr[][]){

        if(!RowSumEqual(arr))                               //checks if all rows are equals to value
            return false;

        Transpose(arr);

        if(!RowSumEqual(arr))                               //checks if all columns are equals to value
            return false;

        if(!diagonalEqual(arr))                             //checks if both diagonals equals to value
            return false;

        if(!hadAppeared(arr))                               //checks if each number between 1 and n^2 had appeared
            return false;


        return true;                                        //got here? congrats! means all conditions are met, matrix is magic
    }         //checks if all conditions for magic matrix are true

    public static void main(String arg[]){

        int arr[][] = {{5,5,5},{5,5,5},{5,5,5}};           //test arrays
//        int arr[][] = {{2,9,4},{7,5,3},{6,1,8}};

        System.out.println(isMagic(arr));

    }
}
