package practiceBasic;

/*Take two numbers and an operator:
+
-
*
/
%
Use switch to perform the operation.
*/
import java.util.Scanner;

public class switchcaseCalculator {
    public static void main (String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter your 1st number: ");
        int num1 = src.nextInt();
        System.out.print("Enter your 2nd number: ");
        int num2 = src.nextInt();
        System.out.println("+ for adding \n- for subtracting \n* for Multiplying, \n/ for dividing, \nand % for remainder.");
        System.out.print("Enter your operator sign: ");
        String ope = src.next();
        switch (ope){
            case("+"):
                System.out.println(num1+num2);
                break;
            case("-"):
                System.out.println(num1-num2);
                break;
            case("*"):
                System.out.println(num1*num2);
                break;
            case("/"):
                System.out.println(num1/num2);
                break;
            case("%"):
                System.out.println(num1%num2);
                break;
        }
    }
}
