import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arr[][] = new int [3][3];
        int arrNew[][] = new int [3][3];

        for (int i=0; i<3 ; ++i ){
            for(int j = 0; j<3 ; ++j )
                arr[i][j] = (int)(100*Math.random())+1;
        }

        for (int i=0; i<3 ; ++i ){
            for(int j = 0; j<3 ; ++j )
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
        System.out.println();

        char input = scan.next().charAt(0);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j)
                arrNew[i][j]=arr[j][2-i];
        }

    /*
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j)
                    arrNew[j][i]=arr[i][j];
            }
 */

        for (int i=0; i<3 ; ++i ){
            for(int j = 0; j<3 ; ++j )
                System.out.print(arrNew[i][j] + "\t");
            System.out.println();
        }

    }
}
