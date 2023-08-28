public class ex1 {

    public static int maxInt(int[] arr, int i){

        if(i==arr.length-1)
                return arr[arr.length-1];

        return Math.max(arr[i],maxInt(arr, i+1));
    }

    public static void reverse(String str){

        if (str.length()==1) {
            System.out.println(str.charAt(0));
            return;
        }

        System.out.print(str.charAt(str.length()-1));

        reverse(str.substring(0,str.length()-1));

    }

    public static int countLittle(String str){

        if(str.length()==0)
            return 0;

        if(str.charAt(str.length()-1)>='a' &&str.charAt(str.length()-1)<='z')
            return 1 + countLittle(str.substring(0,str.length()-1));
        else
            return countLittle(str.substring(0,str.length()-1));

    }

    public static int fib(int num){

        if (num == 0)
            return 1;
        if (num == 1)
            return  1;

        return fib(num-1)+fib(num-2);

    }

    public static boolean calcWeights(int[] weights, int i, int sum){

        if(sum == 0)
            return true;

        if(i >= weights.length)
            return false;

        return calcWeights(weights, i+1 , sum - weights[i]) || calcWeights(weights, i+1 , sum );

    }

    public static boolean printCalcWeights(int[] weights, int i, int sum){

        if(sum == 0) {
            return true;
        }

        if(i >= weights.length)
            return false;

        if(printCalcWeights(weights, i+1 , sum - weights[i])) {
            System.out.print(" " + i);
            return true;
        }
        return printCalcWeights(weights, i+1 , sum - weights[i]) || printCalcWeights(weights, i+1 , sum );


    }

    public static void main(String args[]){

        int[] arr = {6,1,2,3,4,5};

        System.out.println(maxInt(arr, 0));

        reverse("hello world");

        System.out.println(countLittle("AsAsfiiSD"));

        System.out.println(fib(7));

        System.out.println(calcWeights(arr,0,9));

    }

}
