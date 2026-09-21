package oop;
/*
Product — Small Step Up

Create a Product class with:

name
price
quantity

Create a constructor to initialize them.

Create these methods:

displayProduct() → display product details.
calculateTotal() → return price * quantity.
applyDiscount() → if total price is more than 10,000, apply a 10% discount and return the final price.

In main():

Create 2 Product objects.
Display their details.
Display their total price.
Test the discount method.

New thing: method calling another method + if + calculation + return value.
 */

class Product{
    String name;
    int price;
    int quantity;

    Product(String name, int price, int quantity){
        this.name=name;
        this.price = price;
        this .quantity=quantity;
    }
    public void displayProduct(){
        System.out.printf("this is %s \n %d \n %d \n" ,name, price,quantity);


    }
    public int calculateTotal(){
        return price * quantity;
    }
    public void applyDiscount(){
        if(calculateTotal()>10000){
            int dis = (int)(calculateTotal() * 0.10);
            System.out.println("Total After discount: "+ (calculateTotal() - dis));
        }
        else{
            System.out.println("you wont get any discount ");
        }
    }

}
public class questionFour {
    public static void main(String[] args){
        Product product1 = new Product("Brush" , 100,1000);
        Product product2= new Product("ToothBrush", 100,100);


        product1.displayProduct();
        System.out.println("Total product: "+ product1.calculateTotal());
        product1.applyDiscount();

        System.out.println();

        product2.displayProduct();
        System.out.println("Total product: "+ product2.calculateTotal());
        product2.applyDiscount();

    }

}
