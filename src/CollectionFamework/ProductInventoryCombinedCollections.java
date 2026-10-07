package CollectionFamework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProductInventoryCombinedCollections {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter number of product you want to store: ");
        int size = src.nextInt();
        src.nextLine();

        HashMap<Integer,String> products = new HashMap<>();
        for(int i = 0; i <size; i++){
            System.out.println("Enter Product BasicQuestion.Name: ");
            String name = src.nextLine();
            System.out.println("Enter Product ID: ");
            int id = src.nextInt();
            src.nextLine();

            products.put(id,name);
        }
        System.out.println(products+"\n");

        Set<Integer> ids = new HashSet<>(products.keySet());
        System.out.println(ids+"\n");

        System.out.print("Enter id to get product name: ");
        int search = src.nextInt();
        if(products.containsKey(search)){
            System.out.println("We sell");
        }
        else {
            System.out.println("We dont sell");
        }
        System.out.println();
        System.out.println(products.get(search)+"\n");

        if(ids.contains(search)){
            System.out.println("IN Stock");
        }
        else {
            System.out.println("OUT Of Stock");
        }
        System.out.println("Enter product id to remove from inventory and Stock: ");
        int rem = src.nextInt();
        products.remove(rem);
        System.out.println("Successfully Removed from Inventory");
        ids.remove(rem);
        System.out.println("Successfully Removed from Stock too\n");

        System.out.println(products);
        System.out.println(ids);

    }
}
