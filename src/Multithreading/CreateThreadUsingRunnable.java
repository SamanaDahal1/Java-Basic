package Multithreading;

public class CreateThreadUsingRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1 ; i <=5; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        CreateThreadUsingRunnable obj = new CreateThreadUsingRunnable();
        Thread pass = new Thread(obj);
        pass.start();
    }
}
