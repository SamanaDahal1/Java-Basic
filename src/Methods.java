import java.util.Scanner;

public class Methods {
    public static void main(String[] args){
        greet("Sam"); //greet method
        System.out.println(subtract(1000,345)); //subtract method
        System.out.println(square(8)); //square method
        System.out.println(isEven(82)); //isEven method
        System.out.println(max(20,80));

        Methods obj= new Methods();//object
        System.out.println(obj.min(30,40));

        System.out.println(obj.add());// user input so no argument


    }
    //Return type void, displaying msg
    public static void greet(String name){
        System.out.println("Hello, "+name);
    }
    //return type int, subtracting 2 number
    public static int subtract(int a, int b){
        return a-b;
    }
    //return type int
    public static int square(int c){
        return c*c;
    }
    //return type boolean
    public static boolean isEven(int number) {
        return number%2==0 ;
    }
    public static int max(int a, int b){
        if(a<b){
            return b;
        }
        else{
            return a;
        }
    }
    //without static int type
    public int min(int a , int b ){
        if(a<b){
            return a;
        }
        else{
            return b;
        }
    }
    // taking user input
    public double add(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your 1st number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter your 2st number: ");
        double b = scanner.nextDouble();
        System.out.print("Enter your 3st number: ");
        double c = scanner.nextDouble();
        return a+b+c;

    }

}
