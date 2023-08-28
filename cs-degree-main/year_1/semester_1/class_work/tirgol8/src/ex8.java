public class ex8 {

    public static void reverse(int[] arr, int length){

        System.out.print(arr[length-1]);
        if(length>1)
            reverse(arr,length-1);

    }

    public static void main (String args[]){

        int[] arr = {7,2,6,6,7,8,9,7};
        reverse(arr, arr.length);
    }
}
