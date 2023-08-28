public class ex1 {

    public static int max (double[] arr){

        double max = 0;
        int index = 0;
        int i =0;

        for ( i =0 ; i < arr.length-1 ;++i){

            if(arr[i]>max) {
                max = arr[i];
                index = i;
            }
        }

        return index;

    }

    public static void main (String args[]){

        double[][] arr  = {{60,30,30,20,50,40,20,60,70,90} ,{100,80,70,50,90,80,80,90,70,100}};
        double[] value = new double[9];
        double w = 200;
        double total = 0;

        for(int i=0 ; i < 9; ++i){
            value[i] = (double)(arr[1][i]) / (double)(arr[0][i]);
        }

        for(int i=0 ; i < 9 ; ++i){
            System.out.println(value[i]);
        }


        while(w>=0){

            int i = max(value);

            total = total + value[i] * arr[0][i];

            if(arr[0][i]>= w){
                total = total + w * value[i];
                break;
            }

            w = w - arr[0][i];

            value[i] = 0;

        }

        System.out.println(max(value));
        System.out.println(w);
        System.out.println(total);
    }

}
