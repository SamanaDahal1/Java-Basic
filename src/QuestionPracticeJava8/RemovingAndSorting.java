package QuestionPracticeJava8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemovingAndSorting {
    public static void main(String[] args) {
        List<Integer> stores = Arrays.asList(2,3,56,2,33,44,598,27,2,3,4);
        List<Integer> result =stores.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        result.forEach(System.out::println);
    }
}
