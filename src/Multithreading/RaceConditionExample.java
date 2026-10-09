package Multithreading;
class Counters {
    int count = 0;

    void increment() {
        count++;
    }
}
class Task implements Runnable{
    Counters counters;
    Task(Counters counters){
        this.counters=counters;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 100000; i++) {
            counters.increment();
        }
    }
}
public class RaceConditionExample  {
    public static void main(String[] args) throws InterruptedException{
        Counters counters = new Counters();
        Task task = new Task(counters);
        Thread obj1 = new Thread(task);
        Thread obj2 = new Thread(task);
        obj1.start();
        obj2.start();

        obj1.join();
        obj2.join();
        System.out.println("Final count: "+ counters.count );

    }
}
