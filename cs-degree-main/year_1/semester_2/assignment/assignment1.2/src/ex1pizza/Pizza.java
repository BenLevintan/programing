package ex1pizza;

public class Pizza {

    public int size;
    public boolean extraCheese;
    public boolean olive;
    public boolean onion;

    public Pizza(int size, boolean extraCheese, boolean olive, boolean onion) {

        this.size = size;
        this.extraCheese = extraCheese;
        this.olive = olive;
        this.onion = onion;

    }
    public Pizza(Pizza p) {
        this.size = p.size;
        this.extraCheese = p.extraCheese;
        this.olive = p.olive;
        this.onion = p.onion;

    }
    public Pizza() {
        size=this.size;
        extraCheese = this.extraCheese;
        olive = this.olive;
        onion = this.onion;

    }

    //getters
    public int getSize() {
        return size;
    }

    public boolean getCheeseTopping() {
        return extraCheese;
    }

    public boolean getOnionTopping() {
        return onion;
    }

    public boolean getOliveTopping() {
        return olive;
    }

    //setters
    public void setSize(int size) {
        this.size = size;
    }

    public void setCheeseTopping(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void setOliveTopping(boolean olive) {
        this.olive = olive;
    }

    public void setOnionTopping(boolean onion) {
        this.onion = onion;
    }

    //a method that returns the cost of a pizza
    public int calcCost() {
        int cost = 0;
        int numberOfToppings = 0;

        if (this.extraCheese)
            numberOfToppings++;
        if (this.onion)
            numberOfToppings++;
        if (this.olive)
            numberOfToppings++;


        if (this.size == 0)
            cost = 35 + 6 * numberOfToppings;
        if (this.size == 1)
            cost = 45 + 7 * numberOfToppings;
        if (this.size == 2)
            cost = 60 + 9 * numberOfToppings;

        return cost;
    }

    //a method that  prints the pizza
    public String toString() {

        String str = "Pizza size - ";

        if (this.size == 0)
            str = str + "small ";
        if (this.size == 1)
            str = str + "medium ";
        if (this.size == 2)
            str = str + "large ";

        if (this.extraCheese)
            str = str + "+ extra cheese topping  ";
        if (this.onion)
            str = str + "+ onion topping ";
        if (this.olive)
            str = str + "+ olive topping ";
        if(!this.olive&&!this.onion&&!this.extraCheese)
            str = str + "(with no toppings)";

        return str;

    }

    //checks if 2 pizza's are the same
    public boolean equals(Pizza p) {

        if (this.extraCheese != p.extraCheese)
            return false;
        if (this.olive != p.olive)
            return false;
        if (this.onion != p.onion)
            return false;
        if (this.size != p.size)
            return false;

        return true;
    }

}



