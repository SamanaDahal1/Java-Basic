package QuestionPracticeJava8;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

class Student{
    private int id;
    private String name;
    private int marks;

    Student(int id , String name ,int marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }

    int getId(){
        return id;
    }

    String getName(){
        return name;
    }

    int getMarks(){
        return marks;
    }
   public String toString(){
        return "Student{id=" + id + ", name='" + name + "', marks=" + marks + "}";
    }
}
public class OopArrayListPredicateLambda {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student student1 = new Student(1,"Sam",78);
        Student student2 = new Student(2,"Sod",90);
        Student student3 = new Student(3,"Sub",48);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        Predicate<Student> checkMarks = student -> {
            if (student.getMarks() > 60) {
                return true;
            } else {
                return false;
            }
        };

        list.forEach(student->{
            if(checkMarks.test(student)) {
                System.out.println(student);
            }
    });
    }
}

