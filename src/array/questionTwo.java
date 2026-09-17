package array;

public class questionTwo {
    public static void main (String[] args){
        int[] num={1,3,4,6,7,6};

        int small = num[0];
        for(int element : num){
            if ( element < small){
                small=element;
            }
        }
        System.out.println( "Small: "+ small);

        int large = num[0];
        for(int element :num){
            if(element>large){
                large=element;
            }
        }
        System.out.println( "Large: "+ large);
    }

}
