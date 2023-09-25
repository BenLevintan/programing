public class Rectangle extends Shape{

    protected double width;
    protected double length;

    public Rectangle(){
        this.width=0;
        this.length=0;
    }

    public Rectangle(double width,double length){
        this.width=width;
        this.length=length;
    }

    public Rectangle(double width,double length,String color){
        this.width=width;
        this.length=length;
        this.color=color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    public double getPerimeter(){
        return 2 * (width + length);
    }
}
