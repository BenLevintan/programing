import java.util.Scanner;

    public class ex1 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int arr[] = new int [10];

            for (int i=0; i<10 ; ++i ){
                arr[i]= scan.nextInt();
            }

            for (int i=0; i<10 ; ++i ){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            for (int i=0; i<10 ; ++i ){
                System.out.print(arr[9-i] + " ");
            }
        }
    }


