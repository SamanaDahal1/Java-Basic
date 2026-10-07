package QuestionPracticeJava8;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPractice {
    public static void main(String[] args) {
        Consumer<String> print = name->System.out.println("Hello, "+ name);
        Scanner src = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String yourName = src.next();
        print.accept(yourName);

    }
}
