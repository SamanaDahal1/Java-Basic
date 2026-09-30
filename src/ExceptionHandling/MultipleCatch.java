package ExceptionHandling;

import java.util.Scanner;

public class MultipleCatch {
    public static void main(String[] args){

        Scanner src = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = src.nextInt();
        int[] numbers = new int[size];
        for(int i = 0 ;i <size;i++){
            System.out.print("Enter Number: ");
            numbers[i] = src.nextInt();
        }
//        System.out.println("Numbers inside array are: ");
//        for (int num : numbers){
//            System.out.println(num);
//        }
        System.out.println("Enter index to check number belong to that index: ");
        int indexUser = src.nextInt();
        try {
            System.out.println(numbers[indexUser]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Array Index");
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
        System.out.println("Thank you");
    }
}
