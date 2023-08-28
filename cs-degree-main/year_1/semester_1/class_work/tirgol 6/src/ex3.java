import java.util.Scanner;

public class ex3 {

    public static void endGame(int turns){
        System.out.println("WOW you won, and it only took you " + turns + " turns!");
    }

    public static int randomMax(){

        return  (int)(500*Math.random()+1);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int MAXRANGE = 20 ;

        int input = -1;
        int number;
        int tries = 0;

        number = randomMax();

        System.out.println("start guessing!  ");

        while (input!=randomMax()){
            input = scan.nextInt();
            ++tries;

            if(input>number)
                System.out.println("number too big");
            else if (input<number) {
                System.out.println("number is too small");
            } else {
                endGame(tries);
                break;
            }
        }



    }
}
