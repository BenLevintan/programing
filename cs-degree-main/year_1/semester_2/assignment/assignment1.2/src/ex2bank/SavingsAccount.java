// Assignment: 1
// Author: Ben Levintan, ID: 318181831

package ex2bank;

public class SavingsAccount {

    private static double annualInterestRate;
    private static int accountCounter=1000;
    private final int ACCOUNTNUMBER=accountCounter-1000;  //starts at 0 and goes +1 for each new account
    public PersonId client;
    private double savingsBalance;

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public int getACCOUNTNUMBER(){
        return this.ACCOUNTNUMBER;
    }

    public SavingsAccount(int savingsBalance,PersonId client){
        accountCounter++;
        this.client = client;
        this.savingsBalance = savingsBalance;
    }

    public SavingsAccount(PersonId client){
        accountCounter++;
        this.client = client;
        this.savingsBalance = 0;
    }

    public double calculateMonthlyInterest(){
        double monthlyInterest = savingsBalance * annualInterestRate / 12;
        savingsBalance += monthlyInterest;
        return savingsBalance;
    }

    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

    public String toString(){
        String str = "Account number: " + ACCOUNTNUMBER + "\n";
        str= str + "Client details: " + this.client.firstName + " " + this.client.sirName + ", address: " + this.client.address;
        str= str + "\nSaving Balance: " + this.savingsBalance;

        return str;
    }

    public boolean equals(SavingsAccount account){
        if(this.ACCOUNTNUMBER==account.ACCOUNTNUMBER)
            return true;
        return false;
    }

}
