package variableScopes;

class two{
    int a;

}
public class questionTwo {
    public static void main(String[] args){
       two num1 = new two();
       two num2 =new two();
       num1.a=30;
       num2.a=20;
       System.out.println(num1.a);
       System.out.println(num2.a);
    }
}

