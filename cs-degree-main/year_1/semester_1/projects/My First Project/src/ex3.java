public class ex3 {
    public static void main(String[] args) {

        int input1=64310;
        int input2=90;
        int num1,num2;
        int weight=1;
        int sum = 0;

        while (input2 != 0 && input1 !=0) {

            if (input1 % 10 > input2 % 10) {
                sum = sum + input2%10 * weight;
                input2 = input2 / 10;
                weight = weight * 10;
            }
            else if(input1 % 10 < input2 % 10){
                sum = sum + input1%10 * weight;
                input1 = input1 / 10;
                weight = weight * 10;
            }
            else {
                sum = sum + input2%10 * weight;
                input2=input2/10;
                input1=input1/10;
                weight = weight*10;
            }
           // System.out.println(sum + "   "  + weight +"    " + input1+"    " + input2 );
        }
        if(input1>0)
            System.out.println(input1+""+sum);
        else if(input2>0)
            System.out.println(input2+""+sum);
        else
            System.out.println(sum);
    }
}
