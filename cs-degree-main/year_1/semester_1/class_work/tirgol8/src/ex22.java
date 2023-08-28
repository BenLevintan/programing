public class ex22 {

    public static int Factorial (int num){

        if(num == 0 ||num ==1)
            return 1;

        return Factorial(num-1)*num;

    }

    public static void main(String args[]){

        int num=7;
        System.out.println(Factorial(num));

    }
}
