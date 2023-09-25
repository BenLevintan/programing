// Assignment: 1
// Author: Ben Levintan, ID: 318181831

package ex2bank;

public class SaveingsAccountMain {
    public static void main(String[] args){

        PersonId[] clients = new PersonId[10];
        clients[0] = new PersonId(1000, "Guy", "Cohen", "bareket 24");
        clients[1] = new PersonId(1001, "John", "Doe", "123 Main St");
        clients[2] = new PersonId(1000,"Sam", "Bankman-Fried","the bahamas");

        for(int i = 0 ; i< clients.length ; ++i){
            if(clients[i]!=null)
                System.out.println(clients[i].toString());
        }

        SavingsAccount[] accounts = new SavingsAccount[10];
        accounts[0] = new SavingsAccount(2000,clients[0]);
        accounts[1] = new SavingsAccount(3000,clients[1]);
        accounts[2] = new SavingsAccount(4000,clients[2]);

        SavingsAccount.modifyInterestRate(0.01);

        System.out.println("============================================================\n");

        for(int month = 0; month<3 ; month++){
            System.out.println( "\nthe balance for month number: " + month + "\n==============================================");

             for(int i = 0 ; i< accounts.length ; ++i) {
                    if (accounts[i] != null) {
                        accounts[i].calculateMonthlyInterest();
                        System.out.println("Account number: " + accounts[i].getACCOUNTNUMBER());
                        System.out.println(clients[i].toString() +  "\nbalance is: " + accounts[i].getSavingsBalance()+"\n");
                    }
             }

        }
        SavingsAccount.modifyInterestRate(-0.015);

        System.out.println("\nAccount status after one month update of balance (monthly interest now -0.015):\n");

        for(int i = 0 ; i< accounts.length ; ++i) {
            if (accounts[i] != null) {
                accounts[i].calculateMonthlyInterest();
                System.out.println(clients[i].getFirstName() + " " + clients[i].getLastName() + "'s balance is: " + accounts[i].getSavingsBalance());
            }
        }

    }
}
