package oop;
/*
Create an abstract class Animal3 with:

abstract method sound()
normal method sleep()

Requirements:

sound() should be abstract.
sleep() should be a normal method and print "Animal is sleeping".

Create a Dog3 class that extends Animal3.

Implement sound()
Print "Dog barks"

In main():

Create a Dog3 object.
Call sound().
Call sleep().
🆕 New concept

An abstract class can contain both:

abstract methods → child MUST implement
normal methods   → child can directly use/inherit
 */
abstract class Animal3{
    abstract void sound();
    void sleep(){
        System.out.println("Animal is sleeping");
    }
}
 class Dog3 extends Animal3{
    void sound() {
        System.out.println("Dog barks");
    }
}
public class QuestionEighteen {
    public static void main(String[] args){
        Dog3 dog = new Dog3();
        dog.sound();
        dog.sleep();
        }
    }


