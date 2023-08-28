public class ex4 {

    public static int StrToInt(String str){

        int sum=0,p=1;
        boolean isNegative=false;
        int i = 0 ;

        if(str.charAt(0) == '-') {
            isNegative = true;
            i = 1;
        }

        for ( ; i < str.length() ; ++i){

            if( str.charAt(i)<='9' && str.charAt(i)>='0'){
                sum = sum * 10 +  (str.charAt(i)-48) ;
            }else {
                System.out.println("error");
                break;
            }

        }

        if(isNegative)
            sum = sum *(-1);

        return sum;
    }

    public static String IntToString(int num){

        String str = "123";

        for(int i =0 ; i < str.length() ; ++i){


        }

        return str;

    }

    public static void main (String[] args){

        String st1 = "524";
        String st2 = "41";

        int sum;

        sum = StrToInt(st1) + StrToInt(st2);

        System.out.println(sum);



    }
}
