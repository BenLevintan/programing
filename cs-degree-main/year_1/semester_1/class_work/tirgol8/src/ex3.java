public class ex3 {

    public static int Power(int num,int power){

        if(power == 0)
            return 1;

        return num * Power(num , power -1);

    }

    public static void main (String args[]){

        int num = 7;
        int power = 4;

        System.out.println(Power(num,power));

    }

}
