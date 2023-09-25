// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package payments;
/**
 * The PaymentTest class is used to test the Payment class and demonstrate different payment scenarios.
 */
public class PaymentTest {
        /**
         * The main method creates instances of Payment with different payment methods and prints their details.
         * @param args command-line arguments (unused)
         */
    public static void main(String[] args) {
        // Create a credit card payment

            // Create a credit card payment
            Payment creditCardPayment = new Payment(420, PaymentMethod.CREDIT_CARD);
            System.out.println("Credit Card Payment:");
            creditCardPayment.printPaymentDetails();

            System.out.println();

            // Create a cash payment
            Payment cashPayment = new Payment(42, PaymentMethod.CASH);
            System.out.println("Cash Payment:");
            cashPayment.printPaymentDetails();

            System.out.println();

            // Create a bank transfer payment
            Payment bankTransferPayment = new Payment(4.2, PaymentMethod.BANK_TRANSFER);
            System.out.println("Bank Transfer Payment:");
            bankTransferPayment.printPaymentDetails();
        }

}
