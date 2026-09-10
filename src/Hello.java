import java.util.Scanner;
class Hello{
    public static void main(String k[]){
        System.out.println("Hello Guys");
        int a = 400;
        int b = 500;
        System.out.println(a+b);

        Scanner scanner =new Scanner(System.in);
        System.out.println(" please enter your number: ");
        int num = scanner.nextInt();


        System.out.println(" please enter next number: ");
        int num2 = scanner.nextInt();
//        int result = num + num2;
        System.out.println("result " + (num + num2));

    }
}