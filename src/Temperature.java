import java.util.Scanner;
public class Temperature {
    public static void main(String[] a){
        System.out.println("Celsium to Fahrenheit");
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value you want to convert : ");
        double Cel = s.nextDouble();
        double result = (Cel * 9/5) + 32;
        System.out.println(Cel + " degree Celsium is equal to " +result + " degree Fahrenheit" );

    }
}
