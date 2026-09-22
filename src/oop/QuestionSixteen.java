package oop;

/*
Q16: Polymorphism with Multiple Child Classes

Create a parent class Animal with:

- method sound()
  → print "Animal makes a sound"

Create a Dog class that extends Animal.

- Override sound()
  → print "Dog barks"

Create a Cat class that extends Animal.

- Override sound()
  → print "Cat meows"

In main():

1. Create an Animal reference pointing to a Dog object.
2. Call sound().
3. Create an Animal reference pointing to a Cat object.
4. Call sound().

Example structure:

Animal animal1 = new Dog();
animal1.sound();

Animal animal2 = new Cat();
animal2.sound();

🆕 New concept:
The same parent reference type can refer to different child objects,
and each child can provide its own overridden behavior.
*/
class Animal1{
    void sound(){
        System.out.println("Animals make sound");
    }
}
class Dog1 extends Animal1{
    void sound(){
        super.sound();
        System.out.println("Dog Barks");
    }
}
class  Cat extends Animal1{
    void sound(){
        super.sound();
        System.out.println("Cat Meow");
    }
}
public class QuestionSixteen {
    public static void main(String[] args){
    Animal1 animal1 = new Dog1();
    Animal1 animal2 = new Cat();

    animal1.sound();

    System.out.println();
    animal2.sound();
    }
}

