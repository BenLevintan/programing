public class ex1 {


    public static boolean DoesHave2(int num){    //checks if int had the digit '2'

        for(int i = 1 ; i<num ; i=i*10){

            if ((num/i)%10==2)
                return true;

        }
        return false;
    }

    public static boolean DoesHave2(String str){

        for(int i = 0 ; i<str.length(); i++){

            if (str.charAt(i) == '2')
                return true;

        }
        return false;
    }

    public static boolean DoesHave2a(String str){

        if(str.indexOf('2')==-1)
            return false;

        return true;

    }

    public static void main (String[] args){

        String str1 = new String ("Hello");
        String str2 = "World";

        System.out.println(DoesHave2(1332314));
        System.out.println(DoesHave2("mew2n3jnd004"));
        System.out.println(DoesHave2a("mewn3jn22d004"));

    }

}
