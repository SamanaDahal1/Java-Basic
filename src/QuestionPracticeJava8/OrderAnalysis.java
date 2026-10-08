package QuestionPracticeJava8;

import java.util.*;
import java.util.stream.Collectors;

class Customer1{
     int id;
     String name;

     Customer1(int id , String name){
         this.id=id;
         this.name=name;
     }

     int getId() {
         return id;
     }

     String getName() {
         return name;
     }
 }
 class Orders{
     int id;
     Customer1 customer;
     String status;
     double amount;

     Orders(int id , String status ,double amount,Customer1 customer){
         this.id= id;
         this.status=status;
         this.amount=amount;
         this.customer=customer;
     }

     int getId() {
         return id;
     }

     String getStatus() {
         return status;
     }

     double getAmount() {
         return amount;
     }
     Customer1 getCustomer(){
         return customer;
     }


 }
public class OrderAnalysis {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter number of Order: ");
        int size = src.nextInt();
        List<Orders> stores = new ArrayList<>();
        for (int i = 0; i<size;i++){
            System.out.print("Enter name of Customer: ");
            String name= src.next();
            System.out.print("Enter id of Customer: ");
            int cusId= src.nextInt();
            System.out.print("Enter id of Order: ");
            int orderId= src.nextInt();
            System.out.print("Enter Status of Order: ");
            String status= src.next();
            System.out.print("Enter amount of Order: ");
            double amount= src.nextDouble();
            Orders orders = new Orders(orderId,status,amount, new Customer1(cusId, name));
            stores.add(orders);
        }
        Map<String, Double> value = stores.stream()
                .filter(check -> "Paid".equalsIgnoreCase(check.status) && check.amount > 5000)
                .collect(Collectors.groupingBy(check -> check.getCustomer().getName(),
                        Collectors.summingDouble(amount -> amount.getAmount())));
        value.forEach((name,amount)->
                System.out.println(name + " = " + amount)
                );

        }


    }

