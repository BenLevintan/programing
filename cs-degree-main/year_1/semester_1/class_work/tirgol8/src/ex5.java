public class ex5 {

    public static boolean ascend(int num){

        int last,almostlast;

        last = num%10;
        almostlast = (num/10)%10;

        if(num==0)
            return true;

        if(last > almostlast)
            return ascend(num/10);
        else
            return false;

    }

    public static void main (String args[]){

        int num = 1356;
        System.out.println(ascend(num));
    }
}

