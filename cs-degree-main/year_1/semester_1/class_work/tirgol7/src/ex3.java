public class ex3 {

    public static void f(int[] arr, int length){

    if(length == 1)
        return;

    arr[length-1] = arr[length-1] * arr[length-1];

    f(arr,length-1);
}

    public static void main(String[] args) {

        int[] arr = {0,-2,5,3,-1,1,-5,7,14};

        f(arr,arr.length);

        for (int i =0 ; i < arr.length ; i++)
            System.out.println(arr[i]);

    }
}
