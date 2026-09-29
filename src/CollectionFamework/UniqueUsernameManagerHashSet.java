package CollectionFamework;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueUsernameManagerHashSet {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.println("Enter number of username: ");
        int size = src.nextInt();
        HashSet<String> username = new HashSet<>(size);
        for (int i = 0 ; i <size;i++){
            System.out.println("Enter username: ");
             String name = src.next();
             username.add(name);
        }
        System.out.println(username+"\n");
        System.out.println("Total number of unquie username: "+ username.size() );
        System.out.println();
        System.out.println("Enter username which you want to check: ");
        String check = src.next();
        if(username.contains(check)){
            System.out.println("Username exists");
        }
        else {
            System.out.println("Username doesnt exists");
        }
        System.out.println();
        System.out.println("Enter username which you want to remove: ");
        String remove = src.next();
        username.remove(remove);
        System.out.println();
        System.out.println(username);

    }
}
