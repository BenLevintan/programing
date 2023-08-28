import java.util.Scanner;
public class ex7 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean armFound = false;
        int upperB;
        int lowerB;
        int digits, og, lsd;
        int total = 0;
        int power = 1;
        int times = 0;

        System.out.println("Enter the lower and upper bound for numbers:");

        while (times<3){

            lowerB = scan.nextInt();
            upperB = scan.nextInt();

            if ((lowerB <= upperB) && lowerB >= 0){

                while (lowerB <= upperB) {

                    og = lowerB;

                    digits = 0;
                    while (lowerB > 0) {
                        lowerB = lowerB / 10;
                        digits++;
                    }

                    lowerB = og;

                    for (int i = 0; i < digits; ++i) {
                        lsd = og % 10;
                        for (int j = 0; j < digits; j++) {
                            power = power * lsd;
                        }
                        total = total + power;
                        power = 1;
                        og = og / 10;
                    }

                    if (total == lowerB) {
                        System.out.print(total+", ");
                        armFound = true;
                    }

                    total = 0;
                    lowerB++;


                }

                if (!armFound)
                    System.out.println("No Armstrong numbers in this range");

                break;
            }

            else if(times==2) {
                System.out.println("Error, too many false tries. the program will end");
            }
            else
                System.out.println("Error, please try again");

            times++;
        }

    }
}
