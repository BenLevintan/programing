// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package payments;
/**
 * The Payment class represents a payment with an amount, payment method, and reference number.
 */
public class Payment {

    double amount;
    PaymentMethod method;
    String referenceNumber = "REF";
    /**
     * Constructs a Payment object with the specified amount and payment method.
     * Generates a random reference number for the payment.
     * @param amount the amount of the payment
     * @param method the payment method used
     */
    public Payment(double amount, PaymentMethod method){

        this.amount = amount;
        this.method = method;

        int random = (int)(1000000 * Math.random());

        StringBuilder sb = new StringBuilder();

        int i = 6;

        while (i != 0) {
            int digit = random % 10;
            sb.insert(0, digit);
            random /= 10;
            --i;
        }

        this.referenceNumber = referenceNumber + sb.toString();
    }
    /**
     * Prints the details of the payment, including the amount, payment method, and reference number.
     */
    public void printPaymentDetails(){

        System.out.println("Amount: " + amount);
        System.out.println("Method: " + method);
        System.out.println("Reference Number: " + referenceNumber);

    }

}
