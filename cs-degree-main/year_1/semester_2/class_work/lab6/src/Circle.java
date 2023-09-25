public class Circle extends Shape{
    protected double radius;


    public Circle(){
        this.radius = 0;
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        setColor(color); // Set the color using the inherited setColor() method from Shape
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }



}
