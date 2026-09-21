package oop;
/*Create a Product class with:

name
price
quantity

Create a parameterized constructor.

Create these methods:

displayProduct() → display product details.
sellProduct(int soldQuantity) → reduce the quantity by the given amount only if enough stock is available. Otherwise print "Not enough stock".
getStockValue() → return price × quantity.

In main():

Create 2 Product objects.
Display their details.
Sell some quantity from one product.
Display the remaining quantity.
Display the total stock value.

 */

class product{
    String name;
    int price;
    int quantity;

    product (String name,int price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;

    }

    public void displayProduct(){
        System.out.printf("name: %s \nprice: %d \nquantity: %d \n" ,name, price,quantity);
    }
    public int sellProduct(int soldQuantity){
        if(quantity>=soldQuantity){
            quantity-=soldQuantity;
            System.out.println("sold num of stock : "+ soldQuantity);
            System.out.println("Now total left stock: "+quantity);
        }
        else{
            System.out.println("Not enough stock");
        }
        return soldQuantity;
    }
    public int stockValue(){
        return price * quantity;
    }
}

public class questionFive {
    public static void main(String[] args) {
        product pro1 = new product("Brush", 100, 100);
        product pro2 = new product("ToothBrush", 100, 10);
        pro1.displayProduct();
        pro1.sellProduct(20);
        System.out.println("Total stock value: "+ pro1.stockValue());

        System.out.println();

        pro2.displayProduct();
        pro2.sellProduct(20);
        System.out.println("Total stock value: "+ pro2.stockValue());

    }
}