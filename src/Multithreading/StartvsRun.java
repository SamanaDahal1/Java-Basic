package Multithreading;

public class StartvsRun extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is Running" );
    }

    public static void main(String[] args) {
        StartvsRun startvsRun = new StartvsRun();
        startvsRun.run(); //main thread working like normal method
        startvsRun.start(); //new thread is created and working
    }
}
