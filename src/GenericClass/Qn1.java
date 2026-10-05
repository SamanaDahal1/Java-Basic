package GenericClass;

import java.util.Map;

class Box<T> {
   private T value;

   Box(T value){
       this.value=value;
   }

   T getValue(){
       return value;
   }
}

public class Qn1 {
    public static void main(String[] args){

       Box<String> string = new Box<>("Hello");
       Box<Integer> integer = new Box<>(23);
       System.out.println(string.getValue());
       System.out.println(integer.getValue());


    }
}
