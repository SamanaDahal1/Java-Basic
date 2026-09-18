package practiceBasic;

import java.util.Scanner;

public class studentMark {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter Social subject mark: ");
        float social= src.nextFloat();
        System.out.print("Enter Science subject mark: ");
        float science= src.nextFloat();
        System.out.print("Enter Maths subject mark: ");
        float math= src.nextFloat();
        System.out.print("Enter Nepali subject mark: ");
        float nepali= src.nextFloat();
        float sum =0;

        float[] store = new float[4];
        store[0]=social;
        store[1]=science;
        store[2]=math;
        store[3]=nepali;

        for(float element : store) {
            sum += element;
        }
        float average = sum/store.length;
        System.out.println("Sum: "+ sum);
        System.out.println("Average: "+ average);

        if(sum>=320 && sum<=400){
            System.out.println("Grade: A");
        }
        else if (sum>=240 && sum<=319){
            System.out.println("Grade: B");
        }
        else if (sum>=160 && sum<=239){
            System.out.println("Grade: C");
        }
        else if (sum>=0 && sum<=159){
            System.out.println("Grade: F");
        }
        else{
            System.out.println("Invalid ");
        }

        if(sum<400 && sum>160){
            System.out.println("you have passed.");
        }
        else {
            System.out.println("You failed.");
        }
    }
}
