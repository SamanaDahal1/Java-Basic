package oop;

/*
Q12: Inheritance — Using Parent Methods

Create a Person1 class with:

- name
- age

Create a Student2 class that inherits from Person1.

Student2 should have:

- course

Requirements:

1. Person1 should have a parameterized constructor.
2. Create displayPerson() inside Person1.
3. Student2 should extend Person1.
4. Student2 should have a parameterized constructor.
5. Use super() to call the Person1 constructor.
6. Create displayStudent() inside Student2.
7. In main():
   - Create one Student2 object.
   - Call displayPerson().
   - Call displayStudent().

🆕 New concept:
A child object can use methods inherited from its parent class.
*/
class Person1{
    String name;
    int age;

    Person1(String name ,int age){
        this.name=name;
        this.age=age;
    }
    public void displayPerson1(){
        System.out.printf("Name: %s\nAge: %d\n",name,age);
    }

}
class Student2 extends Person1{
    String course;

    Student2(String name,int age,String course){
        super(name,age);
        this.course=course;

    }
    public void displayStudent2(){
        System.out.printf("Name: %s\nAge: %d\nCourse: %s\n",name,age,course);
    }
}
public class QuestionTwelve {
    public static void main(String[] args){
        Student2 student =new Student2("Sam",21,"Bbs");
        student.displayStudent2();

        System.out.println();
        student.displayPerson1();
    }
}
