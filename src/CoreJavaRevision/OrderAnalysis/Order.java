package CoreJavaRevision.OrderAnalysis;

public class Order {
    private  int id;
    private String customerName;
    private String category;
    private double amount;
    private String status;

    Order(int id,String customerName,String category,double amount,String status){
        this.id=id;
        this.customerName=customerName;
        this.category=category;
        this.amount=amount;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
