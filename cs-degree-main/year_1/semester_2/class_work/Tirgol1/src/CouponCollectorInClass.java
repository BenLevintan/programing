public class CouponCollectorInClass {

    public static void main(String[] args) {
        int n=100; //number of coupons
        int iterations=100; //number of times we will repeat the experiment
        int [] simulationResults = new int[iterations];// simulation results
        for (int i = 0; i < iterations; i++) {
            int [] missingCoupons = new int[n];// accounts for missing/not-missing coupons
            //you need to write the method : couponCollecting
            simulationResults[i]=couponCollecting(missingCoupons,n);
        }
        //you need to write the method : averageArray
        double sampleMean= averageArray(simulationResults);
        double theory=n*(Math.log(n)+0.577);
        System.out.println("Coupon collecting n="+n);
        System.out.println("Simulation average: "+sampleMean);
        System.out.println(" theoretical average= n (log n+gamma)="+theory);
    }
    //method couponCollecting: performs the coupon collecting process (until we get n types).
    public static int couponCollecting(int[] missingCoupons, int n){
        int couponDrawings=0;//number of total collected coupon units
        int receivedTypes=0;//number of collected coupon types

        while(receivedTypes<n){

            couponDrawings++;

            if(updateMissing(missingCoupons,drawCoupon(n)));
            receivedTypes++;

        }

        System.out.println("coupons collected: " + couponDrawings );

        return couponDrawings;
    }

    //method drawCoupon: draws randomly a coupon type
    public static int drawCoupon(int n) {
        int couponType=0;

        couponType = (int)(n*Math.random());

        return couponType;

    }

    //method updateMissing: updates information on the coupon we got.
    // returns true if the coupon type is new and false otherwise
    public static boolean updateMissing(int[] missingCoupons, int couponType){
        boolean newCoupon=false;

        if(missingCoupons[couponType]==0) {
            missingCoupons[couponType]=1;
            newCoupon = true;
        }

        return newCoupon;
    }

    //method averageArray: returns the average of values in array
    public static double averageArray(int[] arr){
        double average=0;
        double sum = 0;

        for(int i = 0 ; i < arr.length ; ++i)
            sum = sum + arr[i];

        average = sum / (arr.length);

        return average;

    }
}