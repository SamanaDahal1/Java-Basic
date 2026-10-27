package CoreJavaRevision.OrderStatusManagement;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(2,"Second",3000,Status.PENDING);
        Order order2 = new Order(1,"First",32000,Status.CONFIRMED);
        Order order3 = new Order(3,"Third",33300,Status.SHIPPED);
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        int searchId=3;
        for(Order order : orders){
            if(order.getId()==searchId){
                order.display();
                return;
            }

        }
        System.out.println("Order not found");

    }
}
