    public static int StringToInt (String str){

        int sum=0,p=1;
        boolean isNegative=false;
        boolean isError=false;
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
                isError = true;
                break;
            }

        }

        if(isNegative)
            sum = sum *(-1);

        if(!isError)
            return sum;

        return -1;
    }
