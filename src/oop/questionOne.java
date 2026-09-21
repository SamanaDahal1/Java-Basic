package oop;

/*Ohh 😄 You mean the **original Question 1** you completed.

### Question 1: Student

Create a `Student` class with:

* Fields: `name`, `age`, `course`, `college`
* Parameterized constructor
* `infoPrint()` method to display student details

In `main()`:

* Create **3 Student objects** with different details.
* Call `infoPrint()` for each object.

**Concepts:** Class, Object, Constructor, `this`, Instance Variables, Methods.

 */
class Student{
    String name;
    int age;
    String course;
    String college;

    public void infoPrint(){
        System.out.printf("Student: %s \n %d \n %s \n %s \n " , name ,age,course,college );
    }

    Student(String name,int age,String course,String college ){
        this.name=name;
        this.age=age;
        this.course= course;
        this.college= college;
    }

}
public class questionOne {
    public static void main (String[] args){
        Student s1= new Student("Samana",28,"Bsccs","Herald");
        Student s2= new Student("Sodina",28,"Bca","erald");
        Student s3= new Student("Serina",22,"Bss","rald");

        s1.infoPrint ();
        s2.infoPrint();
        s3.infoPrint();
    }

}
