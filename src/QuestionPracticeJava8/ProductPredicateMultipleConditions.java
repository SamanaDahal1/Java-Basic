package QuestionPracticeJava8;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

class Product1{
    int id ;
    String name;
    int price;

    Product1(int id ,String name,int price){
        this.id=id;
        this.name=name;
        this.price=price;

    }

}
public class ProductPredicateMultipleConditions {
    public static void main(String[] args) {
        ArrayList<Product1> list = new ArrayList<>();
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
            Product1 products = new Product1(id,name,price);
            list.add(products);
        }
        Predicate<Product1> checkPriceName = products->{
            if(products.price>1000 && Character.toUpperCase(products.name.charAt(0))=='A'){
                return true;
            }
            else {
                return false;
            }
        };
        list.forEach(products-> {
            if(checkPriceName.test(products)){
                System.out.println("Name: "+products.name+" Id: "+products.id+" Price: "+products.price);
            }
        }  );
    }
}
