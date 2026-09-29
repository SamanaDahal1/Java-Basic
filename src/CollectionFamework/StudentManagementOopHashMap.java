package CollectionFamework;

import java.util.HashMap;
import java.util.Scanner;

class Students{
    private int id;
    private String name;
    private int marks;

    Students(int id,String name,int marks){
        this.id=id;
        this.name=name;
        this.marks= marks;
    }
    int getId(){
        return id;
    }
    int getMarks(){
        return marks;
    }
    String getName(){
        return name;
    }
}
public class StudentManagementOopHashMap {
    public static void main(String[] args){
        HashMap<Integer,Students> student = new HashMap<>();
        Scanner src = new Scanner(System.in);
        System.out.println("Enter number of Students: ");
        int size = src.nextInt();
        for (int i = 0 ;i<size;i++){
            System.out.print("Enter id: ");
            int id = src.nextInt();
            System.out.print("Enter name: ");
            String name = src.next();
            System.out.print("Enter Mark: ");
            int mark = src.nextInt();
            Students students = new Students(id,name, mark);
            student.put(id,students);
        }
        System.out.println("Added Successfully");
        for(Students students : student.values()) {

            System.out.print("Name: " + students.getName());
            System.out.print(" ID: " + students.getId());
            System.out.println(" Mark: " + students.getMarks());
        }
        System.out.println();

        System.out.print("Enter id to find details: ");
        int id = src.nextInt();
        if(student.containsKey(id)) {
            Students students = student.get(id);
            System.out.print("Name: " + students.getName());
            System.out.println(" Mark: " + students.getMarks());
        }
        else {
            System.out.println("Not found");
        }
        System.out.println();

        System.out.print("Enter id to delete details: ");
        int rem = src.nextInt();
        if(student.containsKey(rem)) {
            student.remove(rem);
            System.out.println("Removed Successfully");
        }
        else {
            System.out.println("Not found");
        }

    }
}
