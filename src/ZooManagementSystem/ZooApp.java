package ZooManagementSystem;

import java.util.ArrayList;

abstract class Animal {
    private String name;
    private int age;
    public abstract void makeSound();
    public void eat(){
        System.out.println("Animal Eats");
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }

    public void display(){
        System.out.printf("name: %s\nAge: %d\n",name,age);
    }
}

class Lion extends Animal {

    public void makeSound() {
        System.out.println("Sound: Roar");
    }
    Lion(){
        this.setName("Lion");
        this.setAge(3);
    }
    public void eat(){
        System.out.println("Lion eats");
    }

}
class Snake extends Animal {

    public void makeSound() {
        System.out.println("Sound: Hiss");
    }
    Snake(){
        this.setName("Snake");
        this.setAge(3);
    }
    public void eat(){
        System.out.println("Snake Eats");
    }
}
class Parrot extends Animal {

    public void makeSound() {
        System.out.println("Sound: Crimps");
    }
    Parrot(){
        this.setName("Parrot");
        this.setAge(1);
    }
    public void eat(){
        System.out.println("Parrot Eats");
    }
}
class Zoo{

//    Animal[] animals = {new Lion(),new Parrot(),new Snake() };
    ArrayList<Animal> animals = new ArrayList<>();
    public void addAnimal(Animal animal){
        animals.add(animal);
    }



    public void feedAllAnimal(){
        for (Animal animal :animals) {
           animal.eat();
        }
    }
}
public class ZooApp {
    public static void main(String[] args){
        Lion lion = new Lion();
        Parrot parrot= new Parrot();
        Snake snake=new Snake();
        Zoo zoo = new Zoo();
        zoo.addAnimal(lion);
        zoo.addAnimal(parrot);
        zoo.addAnimal(snake);
        System.out.println( );
        lion.makeSound();
        lion.display();
        System.out.println();
        parrot.makeSound();
        parrot.display();
        System.out.println();
        snake.makeSound();
        snake.display();
        System.out.println();
        zoo.feedAllAnimal();
    }
}























