package QuestionPracticeJava8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestString {
    public static void main(String[] args) {
        List<String> stores = Arrays.asList("Apple","Elephant","Aeroplane");
        Optional<String> max = stores.stream()
                .max(Comparator.comparing(name -> name.length()));

        if(max.isPresent()){
            System.out.printf(max.get());
        }

    }
}
