public class Square extends Rectangle{


    public Square(){
        width = 0;
    }
    public Square(double side){
        this.width=side;
    }

    public Square(double side,String color){
        this.width=side;
        this.color = color;
    }
    
    public double getArea(){
        return width*width;
    }

    public double getPerimeter(){
        return 4 * width;
    }


}
