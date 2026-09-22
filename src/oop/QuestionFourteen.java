package oop;


/*
Q14: Method Overriding

Create a parent class Animal with:

- method sound()

The sound() method should print:
"Animal makes a sound"

Create a Dog class that extends Animal.

In Dog:
- Override the sound() method.
- Print:
"Dog barks"

In main():

1. Create an Animal object.
2. Call sound().
3. Create a Dog object.
4. Call sound().

🆕 New concept:
Method overriding — a child class provides its own
implementation of a method that already exists in the parent class.
*/
class Animal{
    void sound(){
        System.out.println("Animal makes Sound");
    }
}
class Dog extends Animal{
    @Override
    void sound() {
        super.sound();
        System.out.println("Dog sound");
    }
}
public class QuestionFourteen {
    public static void main(String[] args){
        Animal animal = new Animal();
        Dog dog = new Dog();

        animal.sound();
        System.out.println();
        dog.sound();
    }
}
