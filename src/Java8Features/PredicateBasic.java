package Java8Features;

import java.util.function.Predicate;

public class PredicateBasic {
    public static void main(String[] args) {
//        Predicate<Integer> p = (num) -> {
//            if(num%2==0){
//                return true;
//            }
//            else {
//                return false;
//            }
//        };
        Predicate<Integer> p =(num)->num%2==0;
       System.out.println( p.test(2));
       System.out.println( p.test(15));

       System.out.println();

       Predicate<String> str = (hello)->hello.isEmpty();
       System.out.println(str.test(""));
        System.out.println(str.test("gaga"));
        System.out.println(str.test(" "));


    }

}
