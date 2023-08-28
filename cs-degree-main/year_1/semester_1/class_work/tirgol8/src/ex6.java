public class ex6 {

    public static int appearances (int[] arr, int num, int length){

        if(length == 0)
            return 0;

        if(arr[length-1]==num) {
            return 1 + appearances(arr, num, length - 1);
        }
        else
            return appearances(arr,num,length -1);

    }

    public static void main (String args[]){

        int[] arr = {7,2,6,7,7,8,9,7};
        int n = 7;
        System.out.println(appearances(arr,n,arr.length));
    }
}

