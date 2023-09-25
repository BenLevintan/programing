package shapesKITA;

public abstract class Shape {

    String color = "red";
    double Area;
    double Perimeter;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
