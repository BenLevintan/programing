import java.util.Scanner;

public class ex1 {

    public static int factorial (int n){

        int result=1;

        for (int i = 1 ; i <= n ; ++i)
            result = result * i;

        return result;

    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        if(n<0 || k<0) {
            System.out.println("error");
        }
        if(k>n)
            System.out.println('0');
        else{

            System.out.println( factorial(n)/(factorial(k)*factorial(n-k))  );


        }

    }
}