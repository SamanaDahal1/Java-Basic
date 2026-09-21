package oop;

/*### Question 3: Employee Salary

Create an `Employee` class with:

* Fields: `name`, `id`, `position`, `salary`
* Parameterized constructor
* `displayInfo()` method
* `increaseSalary()` method to increase salary by a fixed amount

In `main()`:

* Create **2 Employee objects**
* Display their details
* Increase the salary of one employee
* Display the updated salary

**Focus:** Class, Object, Constructor, `this`, Methods, and changing object data.

 */
class Employee{
    String name;
    int id;
    String position;
    int salary;

    Employee(String name,int id,String position,int salary){
        this.name=name;
        this.id=id;
        this.position=position;
        this.salary=salary;
    }
    public void displayInfo(){
        System.out.printf("Employee detail :\n %s \n %d \n %s \n %d \n", name ,id,position,salary);

    }
    public void increaseSalary(){
        int increase = 8000;
        salary+=increase;
        System.out.println("Total after increasing salary : " + salary);
    }
}
public class questionThree {
    public static void main (String[] args){
        Employee obj1 = new Employee("Sita",2,"Senior developer",100000);
        Employee obj2 = new Employee("Hari",5,"junior developer",75000);
        obj1.displayInfo();
        obj2.displayInfo();
        obj2.increaseSalary();
    }
}

