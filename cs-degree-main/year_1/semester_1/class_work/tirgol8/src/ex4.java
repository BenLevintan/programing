public class ex4 {

    public static int SumOfDigits(int num){

        if(num%10 == 0)
            return  num;

        return num%10 + SumOfDigits(num/10);

    }

    public static void main (String args[]){

        int num = 9834;
        System.out.println(SumOfDigits(num));
    }
}
