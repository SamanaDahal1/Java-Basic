package ExceptionHandling;

public class ExceptionPropagation {
    void processData(){
        divide();
    }
    void divide(){
        int a = 10/0;
        System.out.println(a);
    }
 public static void main(String[] args){
      ExceptionPropagation exceptionPropagation = new ExceptionPropagation();
      try {
          exceptionPropagation.processData();
      } catch (ArithmeticException e) {
         System.out.println("Cant be divide by 0");
      }
      System.out.println("Thank You");

  }
}
