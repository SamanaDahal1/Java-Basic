package QuestionPracticeJava8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class DeliveryCustomer{
    int id;
    String name;

    DeliveryCustomer(int id ,String name){
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
class DeliveryOrder{
    int id ;
    DeliveryCustomer customer;
    double amount;
    String status;
    LocalDate deliveryDate;

    DeliveryOrder(int id , DeliveryCustomer customer,double amount,String status,LocalDate deliveryDate){
        this.id=id;
        this.customer=customer;
        this.amount=amount;
        this.status=status;
        this.deliveryDate=deliveryDate;
    }

    int getId() {
        return id;
    }

    DeliveryCustomer getCustomer() {
        return customer;
    }

    double getAmount() {
        return amount;
    }

    LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    String getStatus() {
        return status;
    }
}
public class OrderDeliveryReport {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter number of delivered order: ");
        int size = src.nextInt();
        List<DeliveryOrder> stores = new ArrayList<>();
        for(int i = 0;i<size; i++){
            System.out.print("Enter name of customer: ");
            String name = src.next();
            System.out.print("Enter id of customer: ");
            int cusId = src.nextInt();
            System.out.print("Enter ordered Id: ");
            int orderId = src.nextInt();
            System.out.print("Enter amount to pay: ");
            double amount= src.nextDouble();
            System.out.print("Enter Status of order: ");
            String status = src.next();
            System.out.print("Enter date of delivery(YYYY-MM-DD): ");
            LocalDate deliveryDate = LocalDate.parse(src.next());
            DeliveryOrder deliveryOrder = new DeliveryOrder(orderId,new DeliveryCustomer(cusId,name),amount,status,deliveryDate);
            stores.add(deliveryOrder);
        }

        System.out.print("Search date of delivery(YYYY-MM-DD) : ");
        LocalDate searchDate = LocalDate.parse(src.next());

        Map<String, Double> value = stores.stream()
                .filter(check -> "Paid".equalsIgnoreCase(check.getStatus()))
                .filter(check -> !check.getDeliveryDate().isAfter(searchDate))
                .filter(check -> check.getAmount() > 3000)
                .collect(Collectors.groupingBy(
                        name -> name.getCustomer().getName(),
                        Collectors.summingDouble(amount -> amount.getAmount())));
        if(value.isEmpty()){
            System.out.println("No Such Data found");
        }
        else {
            System.out.println(value);
        }


    }
}
