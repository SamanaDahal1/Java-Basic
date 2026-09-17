package functions;

public class questionFour {
    public static void main(String[] args){
        questionFour obj = new questionFour();
        System.out.println(obj.add(2,4));
        System.out.println(obj.add(2,4,8));


    }

    public int add(int a, int b){
        return a+b;
    }
    public int add(int a, int b,int c){
        return a+b+c;
    }
}
