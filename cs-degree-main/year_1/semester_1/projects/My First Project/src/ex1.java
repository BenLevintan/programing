import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int input=0;
        int sum=0;
        int num,min=9999999;

        do {
            input = scan.nextInt();

            if(input==-1)
                break;

            num = input;

            while(num!=0) {

                sum = sum + num % 10;
                num = num / 10;

            }

            if (sum<=min) {
                min = sum;
                System.out.println(sum);
            }

            sum = 0 ;

        }while (input != -1);
    }
}
