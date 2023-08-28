import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counter;
        int arr[] = new int [10];

        for (int i=0; i<10 ; ++i ){
            arr[i]= scan.nextInt();
        }

        for(int i=0 ; i<10 ; ++i){
            counter = 0;
            for(int j=0 ; j<10 ; ++j)
                if(arr[i]==arr[j])
                    ++counter;

            if(counter > 1)
                System.out.println("the number " + arr[i] + " was entered " + counter + " times");

        }

    }
}
