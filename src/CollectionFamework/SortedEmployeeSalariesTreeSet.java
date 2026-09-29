package CollectionFamework;

import java.util.Scanner;
import java.util.TreeSet;

public class SortedEmployeeSalariesTreeSet {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter how many salaries to store: " );
        int size = src.nextInt();
        TreeSet<Integer> salaries = new TreeSet<Integer>();
        for (int i = 0 ; i<size ; i++){
            System.out.print("Enter salaries: ");
            int salary = src.nextInt();
            salaries.add(salary);
        }
        System.out.println(salaries +"\n");

        System.out.println("Lowest Salary: "+salaries.first());
        System.out.println("Highest Salary: "+salaries.last()+"\n");

        System.out.print("Enter salary to search: " );
        int search = src.nextInt();
        if(salaries.contains(search)){
            System.out.println("Exist");
        }
        else {
            System.out.println("Doesnt Exist");
        }
        System.out.println();

        System.out.print("Enter salary to remove: " );
        int remove = src.nextInt();
        salaries.remove(remove);
        System.out.println("Removed Successfully\n");

        System.out.println(salaries);



    }
}
