package oop;

/*
Q17: Abstraction — Abstract Class

Create an abstract class Animal2 with:

- abstract method sound()

Create a Dog2 class that extends Animal2.

- Implement sound()
- Print: "Dog barks"

In main():

- Create a Dog2 object.
- Call sound().

Important:

1. Animal2 should be abstract.
2. sound() should be abstract.
3. Dog2 must provide the implementation of sound().

🆕 New concept:

An abstract class can define WHAT a child must do,
without defining HOW the child does it.

Animal2 says:
"Every animal must have a sound."

Dog2 decides:
"Dog barks."
*/

abstract class Animal2{
    abstract void sound();
}
class Dog2 extends Animal2{
    void sound(){
        System.out.println("Dog barks");
    }
}
public class QuestionSeventeen {
    public static void main (String[] args){
        Dog2 dog2 = new Dog2();
        dog2.sound();

    }
}
