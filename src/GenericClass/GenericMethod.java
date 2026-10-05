package GenericClass;
class Test{
    <T> void printValue(T name){
        System.out.println(name);
    }
}
public class GenericMethod {
    public static void main(String[] args){
             Test test = new Test();
             test.printValue("Shyam");
             test.printValue(89);
             test.printValue(8.90);

    }
}
