package CollectionFamework;

import java.util.ArrayList;
import java.util.List;

class Student{
    int id ;
    String name;
    int marks;

    Student(int id , String name,int marks){
        this.id=id;
        this.name=name;
        this.marks =marks;
    }
}
public class ArrayListPractice2 {
    public static void main(String[] args){
        Student student1 = new Student(4,"samana",80);
        Student student2 = new Student(3,"amana",81);
        Student student3 = new Student(2,"mana",82);
        Student student4 = new Student(1,"ana",83);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        for(Student student:studentList){
            System.out.println(student.id+" "+student.name+" "+student.marks);
        }

        System.out.println();
        Student studentGet =studentList.get(2);
        System.out.println(studentGet.id+" "+ studentGet.name+" "+studentGet.marks+"\n");

        studentList.set(2,student1);
        for(Student student:studentList){
            System.out.println(student.id+" "+student.name+" "+student.marks);
        }

        System.out.println();
        studentList.remove(2);
        for(Student student:studentList){
            System.out.println(student.id+" "+student.name+" "+student.marks);
        }

        System.out.println();
        System.out.println(studentList.contains(student3)+"\n");

        System.out.println(studentList.size());
    }
}
