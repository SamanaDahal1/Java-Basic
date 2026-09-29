package CollectionFamework;

import java.util.HashMap;
import java.util.Scanner;

public class StudentIdManagerHashMap {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter number of Student: ");
        int size = src.nextInt();

        HashMap<Integer,String> student = new HashMap<>(size);
        for(int i = 0; i<size;i++){
            System.out.print("Enter Student name: ");
            String name= src.next();
            System.out.print("Enter Student id: ");
            int id = src.nextInt();
            student.put(id,name);
        }
        System.out.println();
        System.out.println(student+"\n");

        System.out.print("Enter Student id to check whether it exists or not: ");
        int check = src.nextInt();
        if(student.containsKey(check)){
            System.out.println("Exist");
        }
        else {
            System.out.println("Doesnt Exist");
        }
        System.out.println();

        System.out.print("Enter Student id to get student's name: ");
        int search = src.nextInt();
        System.out.println(student.get(search) +"\n");

        System.out.print("Enter Student id to remove student's detail: ");
        int remove= src.nextInt();
        System.out.println(student.remove(remove) +"\n");

        System.out.println(student);

    }
}
