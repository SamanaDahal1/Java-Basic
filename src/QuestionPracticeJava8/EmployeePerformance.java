package QuestionPracticeJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Employees{
    int id;
    String name;
    String department;
    double salary;
    double performanceRating;

    Employees (int id ,String department,String name,double salary , double performanceRating){
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
        this.performanceRating=performanceRating;
    }

    String getName() {
        return name;
    }

     int getId() {
        return id;
    }

    String getDepartment() {
        return department;
    }

    double getSalary() {
        return salary;
    }

    double getPerformanceRating() {
        return performanceRating;
    }
}
public class EmployeePerformance {
    public static void main(String[] args) {
            Scanner src = new Scanner(System.in);
        List<Employees> stores = new ArrayList<>();
            System.out.print("Enter number of employee: ");
            int size = src.nextInt();
            for(int i = 0 ; i<size ; i++){
                System.out.print("Enter name of employee: ");
                String name = src.next();
                System.out.print("Enter id of employee: ");
                int id = src.nextInt();
                System.out.print("Enter department of employee: ");
                String  department = src.next();
                System.out.print("Enter salary of employee: ");
                double salary = src.nextDouble();
                System.out.print("Enter performance of employee: ");
                double per = src.nextDouble();
                Employees employees = new Employees(id,department,name,salary,per);
                stores.add(employees);
            }

        Map<String, Double> name = stores.stream()
                .filter(salary -> salary.getSalary() > 50000)
                .filter(performance -> performance.getPerformanceRating() >= 4.0)
                .collect(Collectors.toMap(nam -> nam.getName(), salary -> salary.getSalary() + (0.1 * salary.getSalary())));
            System.out.print(name);



    }
}
