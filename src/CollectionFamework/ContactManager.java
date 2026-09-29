package CollectionFamework;

import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        TreeMap<String, String> contact = new TreeMap<>();
        while(true) {
            System.out.println("Enter 1/2/3/4/5 for\n" +
                    "1. Add Contact\n" +
                    "2. Display Contacts\n" +
                    "3. Search Contact\n" +
                    "4. Delete Contact\n" +
                    "5. Exit");
            int enter = src.nextInt();
            src.nextLine();
            if(enter==1){
                System.out.print("Enter number of contact you want to store: ");
                int size = src.nextInt();
                src.nextLine();
                for (int i = 0; i < size; i++) {
                    System.out.print("Enter Name of a person: ");
                    String name = src.nextLine();
                    System.out.print("Enter Phone Number of a person: ");
                    String phnNum = src.next();
                    src.nextLine();
                    contact.put(name, phnNum);
                }
                System.out.println();
            }
            else if (enter==2) {
                System.out.println(contact+"\n");
            }
            else if (enter==3) {
                System.out.print("Search number by name: ");
                String search = src.nextLine();
                System.out.println(contact.get(search)+"\n");
            }
            else if (enter==4) {
                System.out.print("Enter name to delete its contact : ");
                String rem = src.nextLine();
                contact.remove(rem);
                System.out.println("Deleted Successfully\n");
            }
            else if (enter==5) {
                System.out.println("Thank You");
                System.exit(0);
            }
            else {
                System.out.println("Please Enter Valid number\n");
            }
        }





    }
}

