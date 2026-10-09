package Multithreading;

class A extends Thread{
   public void run() {
       try{
        for (int i = 1; i<=100 ;i++) {
            System.out.println("Hello");
        }
           Thread.sleep(50);
    }catch (InterruptedException e){
           System.out.println("Cant");
       }
   }
}
class B extends Thread{
   public void run(){
        for (int i = 1; i<=100 ;i++){
            System.out.println("Java");
        }
    }
}

public class Practice {
    public static void main(String[] args) throws InterruptedException{
//        A a = new A();
//        B b = new B();

        Thread a = new Thread(new A());
        Thread b = new Thread(new B());
        a.setPriority(Thread.MIN_PRIORITY);
        a.start();
        b.start();

    }
}
