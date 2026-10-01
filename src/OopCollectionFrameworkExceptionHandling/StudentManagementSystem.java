package OopCollectionFrameworkExceptionHandling;


import java.util.HashMap;

import java.util.InputMismatchException;
import java.util.Scanner;

class Student{
    private int id;
    private String name;
    private int marks;

    Student(int id , String name , int marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
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

public class StudentManagementSystem {
    public static void main(String[] args) {
        HashMap<Integer, Student> detail = new HashMap<>();
        Scanner src = new Scanner(System.in);

        while (true) {
            {
                System.out.println("Enter 1/2/3/4/ for\n" +
                        "1. Add a student\n" +
                        "2. Search for a student by ID\n" +
                        "3. Display all students\n" +
                        "4. Remove student\n"+
                        "5. Exit");
                int choice = src.nextInt();
                if (choice == 1) {
                    int size;
                    try {
                        System.out.println("Enter number of student: ");
                        size = src.nextInt();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Need to enter number ");
                        src.next();
                        continue;
                    }
                    int id;
                    if (size <= 100 && size > 0) {
                        for (int i = 0; i < size; i++) {
                            try {
                                System.out.print("Enter id: ");
                                id = src.nextInt();
                            }
                            catch (InputMismatchException e){
                                System.out.println("Need to enter number");
                                src.next();
                                continue;
                            }
                            if(detail.containsKey(id)){
                                System.out.println("Id already exist");
                            }
                            else {
                            System.out.print("Enter name: ");
                            String name = src.next();
                            System.out.print("Enter marks: ");
                            int marks = src.nextInt();
                            if (marks >= 0 && marks < 101) {
                                Student student = new Student(id, name, marks);
                                detail.put(id, student);
                                System.out.println("Successfully Added\n");
                            } else {
                                System.out.println("Marks must be between 0 and 100.\n");
                            }

                        }
                    }
                    }
                    else {
                        System.out.println("Number of student must be above 0 and below 101\n");
                    }


                }

                else if (choice==2) {
                    System.out.print("Enter id: ");
                    int id = src.nextInt();
                    try {
                        Student student = detail.get(id);
                        System.out.println("Name: " +student.getName());
                        System.out.println("Marks: "+student.getMarks()+ "\n");
                    }
                    catch (NullPointerException e){
                        System.out.println("Student not Found\n");
                    }

                }
                else if (choice==3) {
                    for(Student student : detail.values()) {
                        System.out.println("Students detail: ");
                       System.out.println("Name: "+student.getName());
                       System.out.println("Id: "+student.getId());
                       System.out.println("Mark: "+student.getMarks() +"\n");
                }
                }
                else if (choice==4) {
                    System.out.print("Enter Student Id to remove detail: ");
                    int id = src.nextInt();
                    if(detail.containsKey(id)){
                        detail.remove(id);
                        System.out.println("Removed Successfully");
                    }
                    else {
                        System.out.println("Student not found");
                    }

                }
                else if (choice==5) {
                    System.out.println("Thank you");
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid Input");
                }


            }
        }
    }
}