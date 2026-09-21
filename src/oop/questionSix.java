package oop;
/* ### Question 6: Static vs Instance

Create a `Company` class with:

* `employeeName`
* `employeeId`
* `companyName`

Requirements:

1. `employeeName` and `employeeId` should be **instance variables**.
2. `companyName` should be a **static variable** shared by all employees.
3. Create a parameterized constructor for `employeeName` and `employeeId`.
4. Create `displayInfo()` to display all details.
5. Create **2 Employee objects**.
6. Change the `companyName` once and display both objects again.

**🆕 New concept:** understanding the difference between **instance data** (each object has its own) and **static data** (shared by all objects).
 */

class Company{
    static String companyName= "Envision tech pvt ltd";
    String employeeName;
    int employeeId;

    Company(String employeeName, int employeeId){
        this.employeeName=employeeName;
        this.employeeId=employeeId;
    }
    public void displayInfo(){
        System.out.printf("Company Name: %s\nEmployee Name: %s \nEmployee Id: %d\n",companyName,employeeName,employeeId);
    }
}
public class questionSix {
    public static void main(String[] args){
        Company emp1=new Company("Sarita",23);
        Company emp2 = new Company("Sajan",21);
        emp1.displayInfo();
        System.out.println();
        emp2.displayInfo();
    }
}
