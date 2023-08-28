public class MyFirstClass {
        public static void main(String[] args) {

            int high = 44;
            int low = 22;
            int divisors=0;

            for(int i = low ; i<=high ; ++i){

                if( i==1 ){
                    System.out.println("1 : total 1");
                    break;
                }
                divisors = 1;

                System.out.print(i + ": ");

                for( int j = 1 ; j<=i/2 ; ++j ){

                    if( i%j == 0){
                        System.out.print( j + ", ");
                        divisors++;
                    }

                }

                System.out.println( i + "    divs:" + divisors);

            }

        }
    }

