package oop;

/*
Q15: Polymorphism

Create a parent class Animal with:

- method sound()
  → print "Animal makes a sound"

Create a Dog class that extends Animal.

- Override sound()
  → print "Dog barks"

In main():

Create a Dog object using an Animal reference:

Animal animal = new Dog();

Then call:

animal.sound();

Question:
What will be printed?
*/
class Animals{
    void sound(){
        System.out.println("Animal makes sound");
    }
}
class Dogs extends Animals{
    void sound(){
        super.sound();
        System.out.println("Dog barks");
    }
}
public class QuestionFifteen {
    public static void main(String[] args){
        Animals animals = new Dogs();
        animals.sound();
    }
}
