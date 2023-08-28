import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ex2 {

    public static void randomArr(int[] arr){

        for (int i = 0 ; i < arr.length ; ++i)
            arr[i] = (int)(100 * Math.random()) +1;

    }

    public static void copyArr(int [] copyFrom, int [] copyTo){

        for(int i =0 ; i< copyTo.length ; ++i){

            copyTo[i] = copyFrom[i];

        }

    }

    public static void swapArr(int[] arr1, int[] arr2){

        int temp[] = new int[arr1.length];

        copyArr(arr1,temp);

        copyArr(arr2,arr1);

        copyArr(temp,arr2);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arr1[] = new int[5];
        int arr2[] = new int[5];

        randomArr(arr1);
        randomArr(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        swapArr(arr1,arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));



    }
}
