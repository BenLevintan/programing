// Assignment: 1
// Author: Ben Levintan, ID: 318181831

package ex1pizza;

public class PizzaOrderMain {

    public static void main(String[] args){

        Pizza[] list = new Pizza[3];

        PizzaOrder order1 = new PizzaOrder("Haim","Kohen", list);
        order1.addPizza(0, true, false, true);
        order1.addPizza(1, true, false, false);


        PizzaOrder order2 = new PizzaOrder("Eyal" , "Shani", list);
        order2.addPizza(2, true, true, true);  // add p1
        order2.addPizza(2, true, true, true);  // add p2
        order2.addPizza(2, true, true, true);  // add p3

        order1.tab();
        order2.tab();

        if(!order1.equals(order2))
            System.out.println("\nThe orders are NOT equal!!!");
    }

}
