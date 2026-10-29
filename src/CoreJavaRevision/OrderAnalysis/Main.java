package CoreJavaRevision.OrderAnalysis;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order(1, "Sashi", "Electronics", 80000, "Done");
        Order order2 = new Order(2, "Ram", "Clothing", 5000, "Done");
        Order order3 = new Order(3, "Hari", "Electronics", 45000, "Pending");
        Order order4 = new Order(4, "Sita", "Grocery", 3000, "Cancelled");
        Order order5 = new Order(5, "Ram", "Electronics", 25000, "Done");
        Order order6 = new Order(6, "Sashi", "Clothing", 8000, "Pending");
        Order order7 = new Order(7, "Hari", "Grocery", 12000, "Done");
        Order order8 = new Order(8, "Ram", "Electronics", 60000, "Done");
        Order order9 = new Order(9, "Sita", "Clothing", 15000, "Done");
        Order order10 = new Order(10, "Sashi", "Electronics", 35000, "Cancelled");
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);
        orderList.add(order6);
        orderList.add(order7);
        orderList.add(order8);
        orderList.add(order9);
        orderList.add(order10);
        //amount greater tha 20000
        List<Order> list = orderList.stream()
                .filter(i -> i.getAmount() > 20000)
                .toList();
        System.out.println("--Amount Above 20000--");
        for(Order order : list){
            System.out.println("Customer Name: "+order.getCustomerName()+
                    "\nAmount: "+order.getAmount());
        }
        //Customer name of Status Done
        List<String> status = orderList.stream()
                .filter(i -> i.getStatus().equalsIgnoreCase("Done"))
                .map(Order::getCustomerName)
                .toList();
        System.out.println("\n--Payment Done--");
        for(String order : status){
            System.out.println("Customer Name: "+order);
        }
        //unique customer name that have least one "Done" order
        List<String> uniqueName = orderList.stream()
                .filter(i -> i.getStatus().equalsIgnoreCase("Done"))
                .map(Order::getCustomerName)
                .distinct()
                .toList();
        System.out.println("\n--Payment Done(unique name)--");
        for(String order : uniqueName){
            System.out.println("Customer Name: "+order);
        }
        //top 3 most expensive orders from highest to lower amount
        List<Order> expensiveOrder = orderList.stream()
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .limit(3)
                .toList();
        System.out.println("\n--Top 3 Expensive Order");
        for(Order order : expensiveOrder){
            System.out.println("Customer Name: "+order.getCustomerName() +
                    "\nAmount: "+ order.getAmount());
        }
        //Calculate amount total amount of all "Done" orders
        double totalAmountOfDoneStatus = orderList.stream()
                .filter(i -> i.getStatus().equalsIgnoreCase("Done"))
                .mapToDouble(Order::getAmount)
                .sum();
        System.out.println("\n--Total Amount of 'Done' Status--\n"+totalAmountOfDoneStatus);

        //Average amount of "Done" order
        OptionalDouble averageAmountOfDoneStatus = orderList.stream()
                .filter(i -> i.getStatus().equalsIgnoreCase("Done"))
                .mapToDouble(Order::getAmount)
                .average();
        System.out.println("\n--Average Amount of 'Done' Status--\n"+averageAmountOfDoneStatus.orElseThrow());

        //Single most expensive Done order
        Optional<Order> mostExpensive = orderList.stream()
                .filter(i -> i.getStatus().equalsIgnoreCase("Done"))
                .max(Comparator.comparing(Order::getAmount));
        mostExpensive.ifPresent(order->{
            System.out.println("\n--Most Expensive Done Order--\nCustomer Name: "+order.getCustomerName() +
                    "\nAmount: "+ order.getAmount());
        });


    }

}
