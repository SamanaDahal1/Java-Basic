package CollectionFamework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class StudentMarksManagerArrayList {
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);
        System.out.print("Enter numbers of student: ");
        int size = src.nextInt();
        ArrayList<Integer> mark = new ArrayList<>(size);
        System.out.println("Enter marks: ");
        for (int i = 0; i < size; i++) {
            int input = src.nextInt();
            mark.add(input);
        }
        System.out.println(mark);
        System.out.println();
        System.out.println("Highest Mark: " + Collections.max(mark));
        System.out.println("Lowest Mark: " + Collections.min(mark));
        int sum = 0;
        for (int a : mark) {
            sum += a;
        }
        double average = sum / size;
        System.out.println("Average mark: " + average);
        System.out.println("Enter a number you want to search: ");
        int search = src.nextInt();
        boolean a =mark.contains(search);
        if (a==true){
            System.out.println("Yes here");
        }
        else {
            System.out.println("No here");

        }


    }
}
