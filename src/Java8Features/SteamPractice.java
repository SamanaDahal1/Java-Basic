package Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamPractice {
    public static void main(String[] args) {
//        int[] a = {1,2,3,4,5,6};
//        int sum = 0;
//        for(int i= 0;i<a.length;i++){
//            if (a[i]%2 ==0){
//                sum+=a[i];
//            }
//        }
//        int addi = Arrays.stream(a).filter(n->n%2==0).sum();
//        System.out.println(addi);
//
//
//        String[] fruits = {"Apple", "Banana" ,"Orange"};
//        Stream<String> stream = Arrays.stream(fruits);
//
//        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
//        Stream<Integer> integerStream1 = Stream.iterate(0,n->n+1).limit(10);
//        Stream<Integer> integerStream2 = Stream.generate(()->(int) Math.random()*10).limit(5);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,22,3,4,55,4,333,4,55,43,33,44,66);
        List<Integer> listInteger=list.stream()
                .filter(x->x%2==0)
                .collect(Collectors.toList());
        System.out.println(listInteger);

    }

}
