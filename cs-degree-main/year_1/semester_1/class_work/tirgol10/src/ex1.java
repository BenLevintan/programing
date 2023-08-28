import java.util.Scanner;

public class ex1 {


    public static int jumpSearch(int[] arr, int x) {

        int n = arr.length;
        int step = (int)(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n)-1] < x) {
            prev = step;
            step = step *2;
            if (prev >= n)
                return -1;
        }

        while (arr[prev] < x) {

            prev++;

            if (prev == Math.min(step, n))
                return -1;
        }

        if (arr[prev] == x)
            return prev;

        return -1;
    }

    public static void insertionSort(int[] a) {
            for (int i = 1; i < a.length; i = i + 1)
                insert(a, i);
        }
    private static void insert(int[] a, int i) {
            int value = a[i];

            while (i > 0 && a[i - 1] > value) {
                a[i] = a[i - 1];
                i = i - 1;
            }
            a[i] = value;
        }

    public static void Find(int[] arr, int num){

        int step = (int)(Math.sqrt(num));




    }

    public static int[] RandomArray (int num){

        int arr[] = new int[num];

        for(int i = 0 ; i < num ; ++i)
            arr[i] = (int)((Math.random())*num) + 1;

        return arr;
    }

    public static void LongestSub (int[] arr, int num){

        int mid = num / 2;
        int cL=0;
        int cI=-1;
        int mL=0;
        int mI=-1;

        for (int i =0 ; i <= arr.length ; ++i){

            if( i < arr.length && arr[i]<=mid){

                if(cL==0) {
                    continue;
                }else if(cL >mL){

                    mL = cL;
                    mI = cI;
                    cL = 0;

                }else{
                    cL=0;
                    continue;
                }
            }else{

                if(cL>0)
                    cL++;
                else{
                    cI = i;
                    cL = 1;
                }

            }

        }

        System.out.println(mL + " " +mI);

    }

    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();

        int arr[] = new int [length];

        arr = RandomArray(length);

        for (int i = 0; i < arr.length ; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
//
//        insertionSort(arr);
//
//        for (int i = 0; i < arr.length ; ++i)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//
//        int find = scan.nextInt();
//
//        System.out.println("number is at index: " + jumpSearch(arr,find));

        LongestSub(arr,length);


    }

}
