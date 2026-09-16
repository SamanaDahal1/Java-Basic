package mathOperation;

public class questionFour {
    public static void main(String[] args){
        System.out.println(perimeter(3,5));
        System.out.println(area(4,5));

    }
    public static float perimeter(float length, float width){
        return 2*(length+width);
    }
    public static float area (float length, float width){
        return width * length;
    }
}
