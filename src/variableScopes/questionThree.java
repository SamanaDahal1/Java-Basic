package variableScopes;

class three{
    static int num = 3;
//    int num =3;
}
public class questionThree {
    public static void main(String[] args) {
        three num1 = new three();
        three num2 = new three();
        three num3 = new three();
        System.out.println(num1.num++);
        System.out.println(num2.num++);
        System.out.println(num3.num++);


    }
}