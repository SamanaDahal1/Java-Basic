package QuestionPracticeJava8;

import java.util.function.Supplier;

public class SupplierPractice {
    public static void main(String[] args) {
        Supplier<String> test = ()->"Java 8";
        System.out.println(test.get());
    }
}
