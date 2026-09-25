package CollectionFamework;

import java.util.ArrayList;
import java.util.List;

class Employee{
    int id ;
    String name;
    int salary;

    Employee(int id,String name,int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
}
public class ArrayListPractice {
    public static void main(String[] args){
        Employee employee1 =new Employee(34,"naddie",30000);
        Employee employee2 =new Employee(3,"maddie",51200);
        Employee employee3 =new Employee(4,"saddie",40100);
        List<Employee> a = new ArrayList<Employee>();
        a.add(employee1);
        a.add(employee2);
        a.add(employee3);
        for(Employee b: a){
            System.out.println(b.id+" "+ b.name +" "+b.salary);
        }
        System.out.println();

        Employee employeeGet =a.get(1);
        System.out.println(employeeGet.name+"\n");


        a.remove(0);

        for(Employee b: a){
            System.out.println(b.id+" "+ b.name +" "+b.salary);
        }


        System.out.println(a.contains(employee3)+"\n");


        System.out.println(a.size()+"\n");

        a.set(0,employee1);
        for(Employee b: a){
            System.out.println(b.id+" "+ b.name +" "+b.salary);
        }
    }
}
