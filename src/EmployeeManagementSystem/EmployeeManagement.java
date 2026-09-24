package EmployeeManagementSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee{
    private String name;
    private int id;
    private int baseSalary;
    abstract int calculate();

    Employee(String name,int id,int baseSalary){
        this.name=name;
        this.id=id;
        this.baseSalary=baseSalary;

    }

    String getName(){
        return name;
    }
    int getId(){
        return id;
    }
    int getBaseSalary(){
        return baseSalary;
    }

}

class Employee1 extends Employee{

    Employee1(String name, int id,int basesalary){
        super(name ,id,basesalary);
    }
     int calculate(){
        return getBaseSalary()+7000;


    }

}
class Manager extends Employee{
    Manager(String name, int id,int basesalary){
        super(name ,id,basesalary);
    }
    int calculate(){
        return getBaseSalary() * 2;
    }
}
class SalePerson extends Employee{
    SalePerson(String name, int id,int basesalary){
        super(name ,id,basesalary);
    }
    int calculate(){
        return getBaseSalary() + 500;
    }
}

class Company{
   private Employee employee;
    private String name;
    private int id;
    private int baseSalary;
    private String position;
    private int choice;
    Scanner scanner= new Scanner(System.in);
    private  ArrayList<Employee> emp = new ArrayList<>();



    void action(){
        while(true) {
            System.out.println("what action you want to performe:\n1. Hire Employee\n" +
                    "2. Fire Employee\n" +
                    "3. Generate Payroll Report\n" +
                    "4. Exit");
            choice = scanner.nextInt();

            if (choice == 1) {
                hire();
            } else if (choice == 2) {
                fire();
            } else if (choice == 3) {
                detail();
            } else if (choice == 4) {
                System.exit(0);
            }
        }
    }

    void hire(){
        System.out.println("Hire Employees Page\n");
        System.out.print("Enter your name: ");
        name = scanner.next();
        System.out.print("Enter your id: ");
        id = scanner.nextInt();
        System.out.print("Enter your position: employee/manager/salesperson ");
        position= scanner.next();
        if (position.equalsIgnoreCase("Employee")){
            employee = new Employee1(name,id,50000);
        } else if (position.equalsIgnoreCase("Manager")){
            employee = new Manager(name,id,80000);
        } else if (position.equalsIgnoreCase("Salesperson")){
            employee = new SalePerson(name,id,30000);
        }
        else{
            System.out.println("invalid Position input");
            return;
        }
        emp.add(employee);

        System.out.println("Employee hired successfully.\n");

    }

    void fire(){
        System.out.println("Fire Employee Page\n");
        for (Employee employee : emp){
            System.out.println("Name: " + employee.getName());
            System.out.println("ID: " + employee.getId()+"\n");
        }
        System.out.print("Enter id to remove employee: ");
        int id = scanner.nextInt();
        if(id==employee.getId()){
            emp.remove(employee);
            System.out.println("Employee Removed\n");
        }

    };
    void detail(){
        System.out.println("Detail of Employees\n");

        for (Employee employee : emp) {
            System.out.println("Name: " +employee.getName());
            System.out.println("ID: " + employee.getId());
            System.out.println("Base Salary: "+employee.getBaseSalary());
            System.out.println("Total: "+employee.calculate()+"\n");

        }
    }

}
public class EmployeeManagement {
    public static void main(String[] args){

        Company company = new Company();
        company.action();


    }
}
