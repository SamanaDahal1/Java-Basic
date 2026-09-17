package array;

public class questionThree {
    public static void main(String[] args){
        int[] num = {1,2,3,4,5};
        int a = 0;
        for(int element : num){
            a+=element;

        }

        System.out.println("Sum: " + a);
        int average = a/num.length;
        System.out.println("Average: "+ average);
    }
}
