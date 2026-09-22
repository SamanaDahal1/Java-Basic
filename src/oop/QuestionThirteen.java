package oop;

/*
Q13: Multilevel Inheritance

Create a Person2 class with:

- name

Create a Student3 class that inherits from Person2 with:

- course

Create a CollegeStudent class that inherits from Student3 with:

- college

Requirements:

1. Person2 should have a parameterized constructor for name.
2. Student3 should extend Person2.
3. Student3 should have a parameterized constructor for name and course.
4. Use super() in Student3.
5. CollegeStudent should extend Student3.
6. CollegeStudent should have a parameterized constructor for name,
   course, and college.
7. Use super() in CollegeStudent.
8. Create displayInfo() in CollegeStudent to display all three details.

In main():

- Create one CollegeStudent object.
- Display all details.

🆕 New concept:
Multilevel inheritance — one class inherits from another child class.

Flow:

Person2
   ↓
Student3
   ↓
CollegeStudent
*/
class Person2{
    String name;
    Person2(String name){
        this.name=name;
    }
}
class Student3 extends Person2{
    String course;
    Student3(String name ,String course){
        super(name);
        this.course=course;
    }
}
class CollegeStudent extends Student3{
    String college;
    CollegeStudent(String name,String course,String college){
        super(name, course);
        this.college=college;
    }
    public void displayInfo(){
        System.out.printf("Name: %s\nCourse: %s\nCollege: %s\n",name,course,college);
    }
}
public class QuestionThirteen {
    public static void main(String[] args){
        CollegeStudent p1 = new CollegeStudent("Sushi","BIM","TU");
        p1.displayInfo();
    }
}
