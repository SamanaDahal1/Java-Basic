package oop;
/*
Q11: Inheritance — Basic Parent & Child Class

Create a Person class with:

- name
- age

Create a Students class that inherits from Person.

Student should have:

- course

Requirements:

1. Person should have a parameterized constructor for name and age.
2. Students should inherit from Person using extends.
3. Students should have a parameterized constructor for name, age, and course.
4. Use super() to call the parent constructor.
5. Create displayStudent() to display name, age, and course.

In main():

- Create one Student object.
- Display the student's details.

🆕 New concepts:
- Inheritance
- extends
- super()
*/
class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name=name;
        this.age=age;
    }
    public void displayPerson(){
        System.out.printf("Name: %s\nAge: %d\n",name,age);

    }

}
class Students extends Person{
    String course;
    Students(String name,int age,String course){
        super(name, age);
        this.course=course;
    }
    public void displayStudent(){
        System.out.printf("Name: %s\nAge: %d\nCourse: %s\n",name,age,course);

    }
}

public class QuestionEleven {
    public static void main(String[] args){
        Person person= new Person("Samana", 78);
        Students students=new Students("suhana",22,"BIM");
        students.displayStudent();
        person.displayPerson();



    }
}
