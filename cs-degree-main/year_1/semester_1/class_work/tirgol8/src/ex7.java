public class ex7 {

    public static int HowManyBigger(int[] arr, int num, int length){

        if(length == 0)
            return 0;

        if(arr[length-1]>num) {
            return 1 + HowManyBigger(arr, num, length - 1);
        }
        else
            return HowManyBigger(arr,num,length -1);

    }

    public static void main (String args[]){

        int[] arr = {7,2,6,7,7,8,9,7};
        int n = 7;
        System.out.println(HowManyBigger(arr,n,arr.length));
    }
}
