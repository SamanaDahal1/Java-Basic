package Java8Features;

interface Addable{
    int addition(int a , int b);
}
//class Aimpl implements Addable{
//    @Override
//    public int addition(int a, int b) {
//        return a+b;
//    }
//}
public class lambdaParameter {
    public static void main(String[] args) {
        Addable aimple =(int a , int b)->a+b;
        int result = aimple.addition(8,9);
        System.out.println(result);

        Addable sub = (int a, int b)-> a-b;
        int result2 = sub.addition(2,2);
        System.out.println(result2);


    }
}

