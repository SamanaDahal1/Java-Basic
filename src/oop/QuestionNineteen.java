package oop;
/*
Create an interface AnimalActions with:

method sound()

Create a Dog4 class that implements AnimalActions.

Requirements:

AnimalActions should be an interface.
sound() should be declared inside the interface.
Dog4 should use implements AnimalActions.
Dog4 should provide the implementation of sound().
Print "Dog barks".

In main():

Create a Dog4 object.
Call sound().
 */

interface AnimalAction{
     void sound();
}
class Dog4 implements AnimalAction{
    public void sound(){
        System.out.println("Dog barks");
    }
}
public class QuestionNineteen {
    public static void main(String[] args){
        Dog4 dog4 = new Dog4();
        dog4.sound();
    }
}
