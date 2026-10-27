package CoreJavaRevision.OrderStatusManagement;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(2,"Second",3000,Status.PENDING);
        Order order2 = new Order(1,"First",32000,Status.CONFIRMED);
        Order order3 = new Order(3,"Third",33300,Status.SHIPPED);
        order1.display();
        order2.display();
        order3.display();
    }
}
