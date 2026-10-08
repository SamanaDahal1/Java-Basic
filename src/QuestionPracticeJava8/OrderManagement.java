package QuestionPracticeJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

class Customer{
    int id;
    String name;

    Customer(int id , String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
class Order{
    int orderId;
    int amount;
    String status;
    Customer customer;

    Order(int orderId,int amount,String status,Customer customer ){
        this.orderId=orderId;
        this.amount=amount;
        this.status=status;
        this.customer=customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Name: " + customer.getName() + " Order Id: " + getOrderId() + " Amount: " + getAmount() +" Payment Status: " + getStatus();
    }
}
public class OrderManagement {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        List<Order> stores = new ArrayList<>();
        System.out.print("Enter number of Order: ");
        int size = src.nextInt();
        for(int i = 0 ; i <size;i++){
            System.out.print("Enter name of customer: ");
            String name = src.next();
            System.out.print("Enter customer ID: ");
            int cusId = src.nextInt();
            System.out.print("Enter Order ID of customer: ");
            int orderId = src.nextInt();
            System.out.print("Enter amount to pay of a customer: ");
            int amount = src.nextInt();
            System.out.print("Enter status of payment: ");
            String status = src.next();
            Order order = new Order(orderId,amount,status,new Customer(cusId,name));
            stores.add(order);
        }
//        stores.forEach(System.out::println);

        Optional<Integer> total = stores.stream()
                .filter(order -> "Paid".equalsIgnoreCase(order.getStatus()))
                .map(amt -> amt.getAmount())
                .reduce((a, b) -> a + b);

        if(total.isPresent()){
            System.out.println(total.get());
        }


    }
}
