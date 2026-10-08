package QuestionPracticeJava8;

import java.util.*;
import java.util.stream.Collectors;

class Products{
    int id ;
    String name;
    double price;

    Products(int id ,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

     int getId() {
        return id;
    }

    String getName() {
        return name;
    }

     double getPrice() {
        return price;
    }

}

public class ProductDiscount {
    public static void main(String[] args) {
        Scanner src= new Scanner(System.in);
        List<Products> store = new ArrayList<>();
        System.out.print("Enter number of product: ");
        int size = src.nextInt();
        for(int i = 0 ; i<size;i++){
            System.out.print("Enter name of product: ");
            String name = src.next();
            System.out.print("Enter id of product: ");
            int id = src.nextInt();
            System.out.print("Enter price of product: ");
            double price = src.nextDouble();
            Products products = new Products(id,name,price);
            store.add(products);
        }
        Map<String,Double> result = store.stream()
                .filter(amt -> amt.getPrice() > 1000)
//                .map(amt -> amt.getPrice() - (0.1 * amt.getPrice()))
                .collect(Collectors.toMap(products -> products.getName(),
                        products -> products.getPrice() - ((0.1 * products.getPrice()))));


        System.out.println(result);



    }
}
