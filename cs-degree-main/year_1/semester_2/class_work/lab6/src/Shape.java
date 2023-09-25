public abstract class Shape {

    protected String color = "red";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        String sb="Shape[color =]";

        sb = sb + getColor();

        return sb;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

}
