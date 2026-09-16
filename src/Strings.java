import java.awt.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
//        String name = "Hello Programming";
//        String result = name.replace(" " , "");
//
//        System.out.println(result.length());
//        String text = ("This text is one tab in.\t");
//        System.out.print(text);
//        System.out.println(name + result );
//
//        String one = "This is a good day to code";
//
//        System.out.println( one.startsWith("day")    );
//        System.out.println( one.startsWith("This", 5) );
//
//        System.out.println( one.endsWith  ("code")    );
//        System.out.println( one.endsWith  ("shower")  );
//
//        String check= ("Hello ");
//        System.out.println(check.isEmpty());
//        System.out.println(check.getBytes(StandardCharsets.UTF_8));

//        int b = 9;
//        String c= String.valueOf(b);
//        System.out.println(c.getClass().getSimpleName());
//        System.out.println(b);
//        System.out.println(c.getClass().getSimpleName());
//        String character = "hello";
//        System.out.println(character.charAt(4));

//        float result = 30;
//        System.out.println(result+1);

//        float num = 2*2+3/2-1*2-1;
//        System.out.println(num);

//        int num = 3;
//        if(num==5){
//            System.out.println("Running");
//        }


//        int num = 5;
//        switch (num) {
//            case 1: {
//                System.out.println("RUN1");
//                break;
//            }
//            case 2: {
//                System.out.println("RUN2");
//                break;
//            }
//            case 3: {
//                System.out.println("RUN3");
//                break;
//            }
//            case 4: {
//                System.out.println("RUN4");
//                break;
//            }
//            case 5: {
//                System.out.println("RUN5");
//                break;
//            }
//            case 6: {
//                System.out.println("RUN6");
//                break;
//            }


//            for (int i = 1; i <= 5; i++) {
//
//                if (i == 3) {
//                    continue;
//                }
//
//                System.out.println(i);
//            }
//
//            System.out.println("Loop finished");

//        int[] num= {11,23,1,3,1};
//
//        for(int i=0;i<num.length;i++){
//            System.out.println(num[i]);
//
//        }

//        int[] num= {11,23,1,3,1};
//        int num2 = num.length;
//        System.out.println(num2);


//        StringBuilder stri = new StringBuilder();
//        stri.append("This");
//        stri.append(" ");
//        stri.append("is");
//        stri.append(" ");
//        stri.append("Fun");
//        System.out.println(stri);
//
//        String a= "This ";
//        String b="is ";
//        String c = a + b;
//        System.out.println(c);
//
//        int a=2;
//        int b =0;
//        if(a==b){
//            System.out.println("Equal");
//        }

//        String[] names={"Sam" , "Ram" , "Sita" , "Hari"};
//        names [0] = "Susma";
//        System.out.println(names[0]);
////        for(int i=0 ; i<names.length; i++){
////            System.out.println(names[i]);
////        }
//        for(String name : names){
//            System.out.println(name);


//        int[] marks = new int[9];
//        marks[0]=1;
//        marks[1]=11;
//        marks[2]=111;
//        marks[3]=12;
//        marks[4]=122;
//        marks[5]=13;
//        marks[6]=133;
//        marks[7]=14;
//        marks[8]=144;
//        for(int mark:marks){
//            System.out.println(mark);
//        }
//
//        Scanner src = new Scanner(System.in);
//        System.out.println(" enter size: ");
//        int num = src.nextInt();
//        int[] number = new int[num];
//        System.out.println("Enter numbers");
//        for(int i=0;i<num;i++){
//            number[i]=src.nextInt();
//        }
//        System.out.println("Enter x value: ");
//        int x =src.nextInt();
//
//
//        System.out.println("Array: ");
//        for(int i=0; i<num;i++){
//            if(x==number[i])
//            System.out.println(i);
//        }
//
//
//          Scanner s =new Scanner(System.in);
//          System.out.print("enter size :");
//          int size = s.nextInt();
//          int[] numberList = new int[size];
//          System.out.println("Enter numbers ");
//          for(int i = 0; i<size;i++){
//              numberList[i]=s.nextInt();
//          }
//
//          int x = 3;
//          System.out.println("array : ");
//          for (int i = 0 ;i<size; i++){
//              if (numberList[i]==x)
//              System.out.println(i + "Matched");
//          }


//        Scanner a = new Scanner(System.in);
//        System.out.print("Enter size: ");
//        int sizeArray = a.nextInt();
//
//        int[] numberArray = new int[sizeArray];
//        for(int i=0 ; i<sizeArray; i++){
//            numberArray[i]=a.nextInt();
//        }
//        System.out.println("Here");
//        for(int i=0 ; i<sizeArray; i++){
//            System.out.println(numberArray[i]);
//        }


//        Scanner s = new Scanner(System.in);
//        System.out.print("Enter size: ");
//        int size = s.nextInt();
//        int[] num = new int [size];
//        System.out.println("Enter num: ");
//        for(int i = 0; i<size; i++){
//            num[i]=s.nextInt();
//        }
//        System.out.println("Here, ");
//        int sum = 0;
//        for (int i = 0; i<size ; i++){
//            sum+=num[i];
//        }
//        System.out.println(sum);


//        Scanner a = new Scanner(System.in);
//        System.out.println("Enter size: ");
//        int size = a.nextInt();
//        System.out.println("Enter number ");
//        int[] number = new int[size];
//        for(int i=0; i<size; i++){
//            number[i]=a.nextInt();
//        }
//        int c=0;
//        System.out.println("here , ");
//        for(int i=0; i<size; i++){
//            if(number[i]>c){
//                c=number[i];
//            }
//        }
//        System.out.println(c);


//        Scanner s =new Scanner(System.in);
//        System.out.println("Enter size: ");
//        int size = s.nextInt();
//        System.out.println("Enter number: ");
//        int[] num= new int[size];
//        for(int i =0; i <size; i++){
//            num[i]=s.nextInt();
//        }
//        System.out.println("Here");
//        int min= num[0];
//        for(int i =0; i <size; i++){
//            if(num[i]>=min){
//                min=num[i];
//            }
//
//
//        }
//        System.out.println(min);



//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter size: ");
//        int size = s.nextInt();
//        System.out.println("Enter num: ");
//        int[] num = new int[size];
//        for(int i =0; i<size;i++){
//            num[i]= s.nextInt();
//        }
//        System.out.println("Even number are: ");
//        int count=0;
//        for(int i =0; i<size;i++){
//
//                if(num[i]%2==0){
//                    count++;
//
//
//            }
//
//        }
//        System.out.println(num[count]);



        String a = "Hello";
        String b = "Hello";

        System.out.println(a == b);
        System.out.println(a.equals(b));



    }

        }


