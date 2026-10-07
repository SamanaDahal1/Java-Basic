package CollectionFamework;

import java.util.ArrayList;
import java.util.Scanner;

class Employee1{
    private int id;
    private String name;
    private int salary;

    Employee1(int id,String name, int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    int getSalary(){
        return salary;
    }
}
public class OopCollectionFrameworkEmployeeManagement {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        ArrayList<Employee1> emp = new ArrayList<>();

        while (true){
        System.out.println("\nEnter 1/2/3/4/5 for \n" +
                "1. Add Employee\n" +
                "2. Display Employees\n" +
                "3. Search Employee by ID\n" +
                "4. Remove Employee by ID\n" +
                "5. Exit");

        int choice = src.nextInt();
        if(choice==1){
            System.out.print("Enter number of employees: ");
            int size = src.nextInt();
            src.nextLine();

            for (int i = 0; i<size; i++){
                System.out.print("Enter employees name: ");
                String name= src.nextLine();
                System.out.print("Enter employees id: ");
                int id= src.nextInt();
                src.nextLine();
                System.out.print("Enter employees salary: ");
                int salary= src.nextInt();
                src.nextLine();
                emp.add(new Employee1(id,name,salary));
            }
        }
        else if (choice==2) {
            for(Employee1 employee1: emp) {
                System.out.print("BasicQuestion.Name: " + employee1.getName()+" ");
                System.out.println("ID: " + employee1.getId() + " Salary: " + employee1.getSalary());
        }
        }
        else if (choice==3) {
            System.out.print("Enter ID for employee detail: ");
            int id = src.nextInt();
            for(Employee1 employee1: emp) {
                if(employee1.getId()==id){
                    System.out.println("BasicQuestion.Name: "+ employee1.getName()+ " Salary: "+ employee1.getSalary());
                }
            }

        }
        else if (choice==4) {
            System.out.print("Enter ID to remove detail of an employee: ");
            int id = src.nextInt();
            for(int i = 0 ; i< emp.size();i++) {
                if (emp.get(i).getId() == id) {
                    emp.remove(i);
                    System.out.println("Removed Successfully");
                }
            }

        }
        else if (choice==5) {
            System.out.println("Thank You");
            System.exit(0);
        }
        else {
            System.out.println("Invalid input ");
        }
        }
    }
}
