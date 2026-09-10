import java.util.Scanner;
public class greet {
    public static void main(String a[]){
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your name: ");
        int age =scanner.nextInt();

        System.out.println("Happy birthday "+name+ " you have turned " +age);
    }
}
