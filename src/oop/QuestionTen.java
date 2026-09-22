package oop;
/*
Q10: Encapsulation — Setter with Validation

Create a Student1 class with:

- name
- age

Requirements:

1. Make both variables private.
2. Create a parameterized constructor.
3. Create getAge() → return the age.
4. Create setAge(int age):
   - If age is 18 or above, change the age.
   - Otherwise, print "Invalid age".
5. Create displayStudent() → display name and age.

In main():

- Create one Student1 object.
- Display the student.
- Try changing the age to a valid age.
- Display again.
- Try changing the age to an invalid age.
- Display again.

🆕 New concept:
Encapsulation + validation — the setter controls
whether a private variable can be changed.
*/

class Student1{
    private String name;
    private int age;

    Student1 (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo(){
        System.out.printf("Name: %s\nAge: %d\n",name,age);


    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if (age>=18){
            System.out.println("Age changed to : "+ age);
            this.age=age;

        }
        else{
            System.out.println("Invalid age (Cant change): " + age);

        }
    }

}
public class QuestionTen {
    public static void main(String[] args){
        Student1 man1 =new Student1("Love" , 100);
        Student1 man2 =new Student1("Micheal" , 100);
        Student1 man3 =new Student1("Sandy" , 100);

        man1.displayInfo();
        man1.setAge(80);
        man1.displayInfo();
        System.out.println();

        man2.displayInfo();
        man2.setAge(18);
        man2.displayInfo();
        System.out.println();

        man3.displayInfo();
        man3.setAge(13);
        man3.displayInfo();


    }
}
