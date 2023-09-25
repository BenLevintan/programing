// Assignment: 1
// Author: Ben Levintan, ID: 318181831

package ex1pizza;

public class PizzaOrder {

     String firstName;
     String lastName;

    private final static int MAXPIZZAS = 3;
     Pizza[] list = new Pizza[MAXPIZZAS];

    public int count = 0;

    //PizzaOrder constructor
    // check if Pizza[] is necessary
    public PizzaOrder (String firstName,String lastName,Pizza[] pizzas){
        this.firstName = firstName;
        this.lastName = lastName;
        this.list = new Pizza[MAXPIZZAS];
    }

    public String toString() {
        int total = 0;
        String str = "Customer name - " + this.firstName + " " + this.lastName + "\n";

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                str += list[i].toString() + "\n";
                str += "Pizza price: " + list[i].calcCost() + "\n";
                total += list[i].calcCost();
            }
        }

        str += "Total price: " + total +"\n" + "===============================";

        return str;
    }

    //return a unique int for each pizza config (made as a product of prime numbers)
    public static int PizzaCode(Pizza p){

        int code = p.size+1;

        if(p.extraCheese)
            code = code * 5;
        else
            code = code * 7;
        if(p.olive)
            code = code * 11;
        else
            code = code * 13;
        if(p.onion)
            code = code * 17;
        else
            code = code * 19;

        return code;
    }

    //compares 2 orders
    public boolean equals(PizzaOrder order2){

        if (this.count != order2.count)
            return false;

        if(!this.firstName.equals(order2.firstName))
            return false;

        if(!this.lastName.equals(order2.lastName))
            return false;

        if(this.calcTotal()!=order2.calcTotal())
            return false;

        int orderCode1 = 0;
        int orderCode2 = 0;

        for (int i = 0 ; i < this.count ; ++i){            //adds up all pizza codes to make an order code
            orderCode1 =orderCode1+ PizzaCode(this.list[i]);
            orderCode2 =orderCode2+ PizzaCode(order2.list[i]);
        }

        if(orderCode1!=orderCode2)                         //compare the order codes to see if they are the same
            return false;
        else
            return true;

    }

    //add a pizza to the order
    public void addPizza (int size, boolean extraCheese, boolean olive, boolean onion){

        if(count>=MAXPIZZAS)
            return;

        this.list[this.count] = new Pizza(size,extraCheese,olive,onion);

        count++;
    }

    //calculates the total cost of the order
    public int calcTotal(){

        int total = 0;
        for (int i = 0; i < count; i++) {
            total += list[i].calcCost();
        }
        return total;

    }


    //a method that prints out the order(string already build full before)
    public void tab(){

        System.out.println(this.toString());

    }

}
