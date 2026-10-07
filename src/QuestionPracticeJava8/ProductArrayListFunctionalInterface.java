package QuestionPracticeJava8;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

class Product{
    int id ;
    String name;
    int price;

    Product(int id ,String name,int price){
        this.id=id;
        this.name=name;
        this.price=price;

    }

}
public class ProductArrayListFunctionalInterface {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        Scanner src = new Scanner(System.in);
        System.out.println("Enter number of Product: ");
        int size = src.nextInt();;
        for(int i=0;i<size;i++){
            System.out.print("Enter Product id: ");
            int id = src.nextInt();
            System.out.print("Enter Product name: ");
            String name = src.next();
            System.out.print("Enter Product price: ");
            int price = src.nextInt();
            Product product = new Product(id,name,price);
            list.add(product);
        }
        Predicate<Product> checkPrice =product->{
            if(product.price>1000){
                return true;
            }
            else {
                return false;
            }
        };
        list.forEach(product -> {
           if(checkPrice.test(product)){
            System.out.println("Id: "+product.id +"Name: "+ product.name+"Price: "+ product.price);
            }
        });
    }
}
