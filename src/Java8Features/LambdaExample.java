package Java8Features;

interface Shape{
    void draw();
}

public class LambdaExample {
    public static void main(String[] args) {
        Shape rectangle = () -> System.out.println("Rectangle ");
        Shape square = () -> System.out.println("Square");
        Shape circle = () -> System.out.println("Circle");
//        rectangle.draw();
//        square.draw();
//        circle.draw();

        print(rectangle);
        print(square);
        print(circle);

    }

    private static void print (Shape shape){
        shape.draw();
    }
}