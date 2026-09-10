import java.util.Scanner;
public class Condition {
    public static void main(String[] args){
        Scanner src =new Scanner(System.in);
        System.out.print("Enter first number : ");
        int num1 = src.nextInt();
        System.out.print("Enter second number : ");
        int num2 = src.nextInt();

        System.out.print("Enter operator +.-,*,/,%: ");
        char op = src.next().charAt(0);

        if(op== '+'){
            System.out.println(num1 + num2);
        } else if (op == '-') {
            System.out.println(num1 - num2);
        } else if (op=='*') {
            System.out.println(num1 * num2);
        } else if (op=='/') {
            if (num1 == 0 || num2 ==0){
                System.out.println("Cant take 0");
            }
            else{
                System.out.println(num1/num2);
            }
        } else if (op == '%') {
            System.out.println(num1%num2);

        }
    }
}




//        System.out.print("Enter 1/2/3/4/5 for operator (1 for -,2 for * , 3 for /, 4 for +, 5 for %) : ");
//        int op= src.nextInt();
//        if (op == 4) {
//            System.out.println( num1 + num2);
//        } else if (op == 1) {
//            System.out.println(num1-num2);
//        }else if (op == 2) {
//            System.out.println(num1*num2);
//        } else if (op == 3) {
//            if(num1 ==0) {
//                System.out.println("Can take 0 input in divide");
//            }
//            else if (num2==0) {
//                System.out.println("Can take 0 input in divide");
//            } else {
//                System.out.println(num1 / num2);
//            }
//        } else if (op == 5) {
//            System.out.println(num1%num2);
//        }
