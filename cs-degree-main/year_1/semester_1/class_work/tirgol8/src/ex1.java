public class ex1 {

    public static int Count(int number){

        int count=0;

        if(number/10==0)
            return 1;

        number = number/10;

        return Count(number) + 1;


    }

    public static void main(String args[]){

        int num = 57866657;
        System.out.println(Count(num));

    }


}
