public class ex1 {

        public static void main(String[] args){
    
            String str= "9@@@!!!!!~~~~~~";

    
            for (char i = '!' ; i <= '~' ; ++i){
    
                int count = 0 ;
    
                for(int j=0 ; j < str.length(); ++j){
    
                    if(str.charAt(j) == i) {
                        System.out.print(j + " ,");
                        ++count;
                    }
    
                }
                if(count!=0) {
                    System.out.print( " - '"+ i + "'" + " has appeared " + count);
                    System.out.println();
                }
            }
    
    
        }
}
