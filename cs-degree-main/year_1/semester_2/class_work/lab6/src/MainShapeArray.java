public class MainShapeArray {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[20];
        getShapes(shapes);

    }
    public static void getShapes(Shape[] shapes){
        System.out.println("Array of shapes:");
        System.out.println("*******************");
        for (int i = 0; i <20 ; i++) {
            int randomInt = randomInteger(0,2);
            double randomD1 = randomDouble(0,10);
            double randomD2 = randomDouble(0,10);
            switch (randomInt){
                case 0:
                    shapes[i]=new Circle(randomD1/2);
                    break;
                case 1:
                    shapes[i]=new Rectangle(randomD1,randomD2);
                    break;
                case 2:
                    shapes[i]=new Square(randomD1);
            }
        }
    }
    public static int randomInteger(int min, int max){
        return (int)(Math.random()*(max-min+1)+min);
    }
    public static double randomDouble(int min, int max){
        return Math.random()*(max-min);
    }


}
