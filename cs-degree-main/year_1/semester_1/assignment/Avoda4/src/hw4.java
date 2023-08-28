//Assignment: 4
//Author: Ben Levintan, ID: 318181831

public class hw4 {

    public static int count2(int num){

        if(num == 0)                            //basic result of number with 0 integers
            return 0;

        if(num%10==2)                           //if the lsd divisible by 2
            return 1 + count2(num/10);     //add 1, and use the function for the number without it's lsd
        else
            return count2(num/10);         //if not, don't add 1 to the count
    }

    public static boolean isPalindrome(String str){

        if(str.length()==0 || str.length()==1)   //if string is empty or contains just one letter, its palindrome
            return true;

        if(str.charAt(0)==str.charAt(str.length()-1))
             return isPalindrome(str.substring(1,str.length()-1 ));
        else
            return false;


    }

    public static int sumOfDigits(int num){

        if(num%10 == 0)
            return  num;

        return num%10 + sumOfDigits(num/10);

    }

    public static int SumOfArray(int[] arr,int n){    //return the sum of all array

        if (n==0)                                     //if we got the smallest array, return the int value
            return arr[0];

        return arr[n] + SumOfArray(arr, n-1 );     //add up the last number in array decreasing in length

    }

    public static boolean sumIsEven(int[] arr){      //return statement t/f for is sum even

            if((SumOfArray(arr,arr.length-1)%2)==0)
                return true;
            else
                return false;


    }

    public static int power(int num){

        if(num == 0)                       //base: 2^0=1
            return 1;

        return 2 * power(num-1);      //multiply by 2

    }

    public static int sumOfOddNumbers(int[] arr,int length){

        if(length==0)                    //if 'array length' is 0, return 0
            return  0;

        if(arr[length-1]%2!=0)           //if the last digit is even, and the value of it, and call the function for the next digit
            return arr[length-1] + sumOfOddNumbers(arr,length-1);
        else                             //if uneven, don't add the value, and just call next
            return sumOfOddNumbers(arr,length-1);
    }
    public static int sumOfOddNumbers(int[] arr) {

        int sum = sumOfOddNumbers(arr, arr.length);

        return sum;
    }

    public static boolean subsetSum(int[] arr, int i, int sum){

        if(sum == 0)         //the sum is subtracted as we choose a number, so sum = 0 means we found a combination
            return true;

        if(i >= arr.length)
            return false;   //if we went through all the array

        return subsetSum(arr, i+1 , sum - arr[i]) || subsetSum(arr, i+1 , sum );

    }
    public static boolean subsetSum(int [] arr, int sum){

            return subsetSum(arr,0,sum);
    }

    public static int tribonacciElement(int num){

        if(num == 1 || num == 0)
            return 0;
        if(num == 2)
            return 1;

        return tribonacciElement(num-1) + tribonacciElement(num-2) + tribonacciElement(num-3);

    }

    public static int tribonacci(int[] table,int num){

        if(num == 1 || num == 0)
            return 0;
        if(num == 2)
            return 1;
        else if(table[num] == -1)                 //if cell is empty (-1), register a new value
            table[num] = tribonacci(table,num-1)+tribonacci(table,num-2)+tribonacci(table,num-3);

        return table[num];
    }
    public static int tribonacci(int num){

        int[] table = new int[num+2];             //make a look-up table

        for (int i=0 ; i< table.length ; ++i)     // -1 = cell is empty
            table[i] = -1;

        return tribonacci(table,num);
    }  //this time with a look-up table

    public static void main(String[] args) {
//Q1
        System.out.println("2 appears " + count2(125421) + " times."); //2 appears 2 times.
//Q2
        if (isPalindrome("yt7ty")) // true
            System.out.println("yt7ty is palindrome");
        else
            System.out.println("yt7ty is not palindrome");
//Q3
        System.out.println("The sum of digits in 1287 is : " + sumOfDigits(1287)); // The sum of digits in 1287 is : 18
//Q4
        if (sumIsEven(new int[]{1, 2, 3, 4})) // true
            System.out.println("sum of elements in {1,2,3,4} is even");
        else
            System.out.println("sum of elements in {1,2,3,4} is odd");
//Q5
        System.out.println("2^4= " + power(4));//2^4=16
//Q6
        System.out.println("The sum of odd numbers in {1,3,2,4} is " + sumOfOddNumbers(new int[]
                {1, 3, 2, 4})); // The sum of odd numbers in {1,3,2,4} is 4.
//Q7
        int sum = 9;
        if (subsetSum(new int[]{3, 8, 15, 97, 6}, sum)) // 5 is the size of array, the sum is 9. -> true.
            System.out.println("There is a subset in {3,8,15,97,6} with sum 9.");
        else
            System.out.println("There is no subset in {3,8,15,97,6} that adds up to 9.");
//Q8
        System.out.print("The 10 first Tribonacci Numbers: ");
        for (int i = 0; i < 10; i++)
            System.out.print(tribonacciElement(i) + " ");
        System.out.println();
//Q9
        int n = 10;
        System.out.print("The 10 first Tribonacci Numbers: ");
        for (int i = 0; i < n; i++)
            System.out.print(tribonacci(i) + " ");
    }
}
