public class Pizza{

    private int size; // 1 2 or 3
    private boolean extra; // is there extra cheese
    private boolean olives; // are there olives on the pizza
    private boolean onion; // is there onion on the pizza

    public void set(int size, boolean extra,boolean olives,boolean onion){

        this.size = size;
        this.extra = extra;
        this.olives = olives;
        this.onion = onion;

    }

    public Pizza CopyPizzaTo(Pizza Old){

        Pizza New = new Pizza();

        New.size = Old.size;
        New.extra = Old.extra;
        New.olives = Old.olives;
        New.onion = Old.onion;

        return New;
    }    //copying existing Pizza and returns a new one

    public void setSize(int SetSize){

        this.size = SetSize;

    }

    public void setCheeseTopping(boolean SetExtra){

        this.extra = SetExtra;

    }

    public void setOliveTopping(boolean SetOlives){

        this.olives = SetOlives;

    }

    public void setOnionTopping(boolean SetOnion){

        this.onion = SetOnion;

    }

    public int getSize(){

        return size;

    }

    public boolean getExtra(){

        return  extra;

    }

    public boolean getOlivesTopping(){

        return olives;

    }

    public boolean getOnionTopping(){

        return onion;

    }

    public int calcCost(){

        int price = 0;                 //the total price of a pizza
        int numberOfToppings = 0;      //count the number of toppings on the pizza


        if(this.extra)
            numberOfToppings++;
        if(this.onion)
            numberOfToppings++;
        if(this.olives)
            numberOfToppings++;


        switch (this.size){              //calculate pizza cost based different pizza size

            case 0:
                price = 35;
                price = price + 6 * numberOfToppings;
                break;

            case 1:
                price = 45;
                price = price + 7 * numberOfToppings;
                break;

            case 2:
                price = 60;
                price = price + 9 * numberOfToppings;
                break;

            default:
                break;
        }

        return price;

    }

    public String toString(){

        String str = new String();
        String size = new String();

        if(this.size==1)
            size = "medium ";
        if(this.size==2)
            size = "large ";
        else
            size = "small ";

        str =   "Pizza size - " + size ;

        if(this.extra)
            str = str + "+ extra cheese topping ";

        if(this.onion)
            str = str + "+ onions topping ";

        if(this.olives)
            str = str + "+ olives topping ";


        return str;
    }


}
