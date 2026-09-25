package CollectionFamework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Student1{
    int id ;
    String name;
    int marks;

    Student1(int id , String name,int marks){
        this.id=id;
        this.name=name;
        this.marks =marks;
    }
}
public class LinkedListPractice {
    public static void main(String[] args){
        Student1 student6 = new Student1(5,"a",79);
        Student1 student1 = new Student1(4,"samana",80);
        Student1 student2 = new Student1(3,"amana",81);
        Student1 student3 = new Student1(2,"mana",82);
        Student1 student4 = new Student1(1,"ana",83);
        Student1 student5 = new Student1(0,"na",84);


        LinkedList<Student1> studentList = new LinkedList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.addFirst(student5);
        studentList.addLast(student6);

        System.out.println("List: ");
        for(Student1 student:studentList){
            System.out.println(+student.id+" "+student.name+" "+student.marks);
        }

        System.out.println();

        Student1 studentGet1 = studentList.getFirst();
        System.out.println("First Element: "+studentGet1.id+" "+studentGet1.name+" "+studentGet1.marks+"\n");

        Student1 studentGetL = studentList.getLast();
        System.out.println("Last Element: "+studentGetL.id+" "+studentGetL.name+" "+studentGetL.marks+"\n");

        studentList.removeLast();
        System.out.println("List After Removing Last Element: ");
        for(Student1 student:studentList){
            System.out.println(+student.id+" "+student.name+" "+student.marks);
        }
        System.out.println();

        studentList.removeFirst();
        System.out.println("List After Removing First Element: ");
        for(Student1 student:studentList){
            System.out.println(+student.id+" "+student.name+" "+student.marks);
        }
        System.out.println();














//        Student1 studentGet =studentList.get(2);
//        System.out.println(studentGet.id+" "+ studentGet.name+" "+studentGet.marks+"\n");
//
//        studentList.set(2,student1);
//        for(Student1 student:studentList){
//            System.out.println(student.id+" "+student.name+" "+student.marks);
//        }
//
//        System.out.println();
//        studentList.remove(2);
//        for(Student1 student:studentList){
//            System.out.println(student.id+" "+student.name+" "+student.marks);
//        }
//
//        System.out.println();
//        System.out.println(studentList.contains(student3)+"\n");
//
//        System.out.println(studentList.size());
    }
}
