package QuestionPracticeJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Customers{
    int id ;
    String name;
    String email;
    String city;
    boolean active;

    Customers(int id, String name,String email,String city,boolean active){
        this.id=id;
        this.name=name;
        this.email=email;
        this.city=city;
        this.active=active;
    }

     int getId() {
        return id;
    }
    String getName(){
        return name;
    }

     boolean isActive() {
        return active;
    }

    String getCity() {
        return city;
    }

   String getEmail() {
        return email;
    }
}
public class CustomerSearch {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter number of Customer: ");
        int size = src.nextInt();
        List<Customers> stores = new ArrayList<>();
        for(int i = 0 ; i<size ;i++){
            System.out.print("Enter name of Customer: ");
            String name= src.next();
            System.out.print("Enter id of Customer: ");
            int id = src.nextInt();
            System.out.print("Enter email of Customer: ");
            String email= src.next();
            System.out.print("Enter city of Customer: ");
            String city = src.next();
            System.out.print("if Active (true) if No Active (false: ");
            boolean active = src.nextBoolean();
            Customers customers = new Customers(id,name,email,city,active);
            stores.add(customers);
            System.out.println("\nAdded Sucessfully");
        }
        System.out.print("Enter customer id to search: ");
        int cutId = src.nextInt();


        Optional<Customers> value = stores.stream()
                .filter(id -> id.getId()==cutId)
                .filter(customers -> customers.isActive())
                .findFirst();

        if(value.isPresent()){
            System.out.print("Customer found Active");
        }
        else {
            System.out.print("Customer found Inactive");
        }
    }
}
