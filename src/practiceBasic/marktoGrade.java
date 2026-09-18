package practiceBasic;
/*Take marks and print:
90–100 → A
80–89  → B
70–79  → C
60–69  → D
Below 60 → F
*/

import java.util.Scanner;

public class marktoGrade {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter your mark: ");
        int mark = src.nextInt();
        if(mark>=90 && mark<=100){
            System.out.println("Grade: A");
        }
        else if (mark>=80 && mark<=89){
            System.out.println("Grade: B");
        }
        else if (mark>=70 && mark<=79){
            System.out.println("Grade: C");
        } else if (mark>=60 && mark<=69){
            System.out.println("Grade: D");
        }
        else {
            System.out.println("Grade: Fail");
        }

    }
}
