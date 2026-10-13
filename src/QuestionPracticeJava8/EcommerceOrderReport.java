package QuestionPracticeJava8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product2{
    int id;
    String name;
    double price;

    Product2(int id , String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
class OrderItem{
    Product2 product;
    int quantity;

    OrderItem(Product2 product,int quantity){
        this.product=product;
        this.quantity=quantity;
    }
}
class Customer2{
    int id;
    String name;
    String city;

    Customer2(int id ,String name,String city){
        this.id=id;
        this.name=name;
        this.city=city;
    }
}
class Order2 {
    int id;
    Customer2 customer;
    List<OrderItem> items;
    String status;
    LocalDate orderDate;

    Order2(int id , Customer2 customer,List<OrderItem> items,String status,LocalDate orderDate){
        this.id=id;
        this.customer=customer;
        this.items=items;
        this.status= status;
        this.orderDate=orderDate;
    }
}

public class EcommerceOrderReport {
    public static void main(String[] args) {
        List<Order2>  stores = new ArrayList<>();
        Scanner src = new Scanner(System.in);
        System.out.println("Enter number of order: ");
        int size = src.nextInt();
        for(int i = 0 ; i<size;i++){
            System.out.print("Enter name of customer: ");
            int name = src.nextInt();
            System.out.print("Enter Customer ID: ");
            int cusId = src.nextInt();
            System.out.print("Enter Customer's city: ");
            String city= src.next();



        }

    }
}
