package CoreJavaRevision.OrderAnalysis;

public class Order {
    private  int id;
    private String customerName;
    private String category;
    private int amount;
    private String status;

    Order(int id,String customerName,String category,int amount,String status){
        this.id=id;
        this.customerName=customerName;
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

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
