package QuestionPracticeJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee{
    int id;
    String name;
    String department;
    double salary;

    Employee (int id, String name,String department,double salary ){
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }
    public String toString(){
        return ("id: " + id + "name: " + name + "department: " + department + "salary: " + salary );
    }
}
public class EmployeeStreamFilter {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();
        System.out.println("Enter number of employee: ");
        int size = src.nextInt();

         for (int i = 0; i<size ;i++){
             System.out.println("Enter name of employee: ");
             String name = src.next();
             System.out.println("Enter id of employee: ");
             int id = src.nextInt();
             System.out.println("Enter department of employee: ");
             String department= src.next();
             System.out.println("Enter salary of employee: ");
             double salary= src.nextDouble();
             Employee employee = new Employee(id,name,department,salary);
             list.add(employee);
         }
         List<Employee> filteredEmp = list.stream()
                 .filter(employee->employee.salary>50000)
                 .toList();

         filteredEmp.forEach(System.out::println);

    }

}
