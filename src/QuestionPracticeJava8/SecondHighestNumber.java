package QuestionPracticeJava8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> stores = Arrays.asList(2,2,2);
        List<Integer> value = stores.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .toList();
        System.out.println(value);
    }
}
