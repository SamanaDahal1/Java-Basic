package QuestionPracticeJava8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Get2ndAnd3rdElement {
    public static void main(String[] args) {
        List<Integer> stores = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> value = stores.stream()
                .skip(1).limit(2)
                .toList();
        System.out.println(value);
    }

}
