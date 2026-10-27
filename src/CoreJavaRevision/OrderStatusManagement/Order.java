package CoreJavaRevision.OrderStatusManagement;

public class Order {
    int id;
    String customerName;
    double amount;
    Status status;
    Order(int id,String customerName,double amount,Status status){
        this.id=id;
        this.customerName=customerName;
        this.amount=amount;
        this.status=status;
    }

    void display(){
        System.out.println("Order Id: "+id+"\nCustomer Name: "+customerName+"\nAmount: "+amount+"\nStatus: "+status+"\n");
    }


}
