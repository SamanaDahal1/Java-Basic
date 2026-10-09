package Multithreading;

public class CreateThreadUsingThread extends Thread {
    @Override
    public void run(){
        for(int i=1 ; i<=5; i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
            CreateThreadUsingThread obj = new CreateThreadUsingThread();
            obj.start();
            System.out.println("Main Thread Finished");

    }}

