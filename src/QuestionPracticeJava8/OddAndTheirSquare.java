package QuestionPracticeJava8;

import java.util.Arrays;
import java.util.List;

public class OddAndTheirSquare {
    public static void main(String[] args) {
        List<Integer> stores = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> value = stores.stream()
                .filter(num -> num % 2 != 0)
                .map(num -> num * num)
                .toList();
        value.forEach(System.out::println);
    }
}
