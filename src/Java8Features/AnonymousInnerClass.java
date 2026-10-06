package Java8Features;
class Emp{
    int x= 10;

     class Emp2{
        int y = 79;
    }
}
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Emp x = new Emp();
        Emp.Emp2 emp = x.new Emp2();

        System.out.println(x.x);
        System.out.println(emp.y);


    }
}
