package practiceBasic;

import java.util.Scanner;

/*Take total minutes as input and convert them into:

Hours
Remaining minutes

 */
public class convertMin {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.println("Enter minutes: ");
        int min = src.nextInt();
        int hour = min/60;

        int afterPoint= min%60;

        System.out.printf("%d hour and %d minutes remaining",hour , afterPoint);


    }
}
