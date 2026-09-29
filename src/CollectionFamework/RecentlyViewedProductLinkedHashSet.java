package CollectionFamework;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class RecentlyViewedProductLinkedHashSet {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter number of product that user viewed: ");
        int size = src.nextInt();
        LinkedHashSet<String> product = new LinkedHashSet<>(size);
        for(int i =0 ; i <size ; i++){
            System.out.print("Enter Product name: ");
            String name = src.next();
            product.add(name);
        }
        System.out.println(product+"\n");

        System.out.print("Enter product name to check whether it exist or not: ");
        String check= src.next();
        if(product.contains(check)){
            System.out.println("Exist");
        }
        else {
            System.out.println("Doesnt Exist");
        }
        System.out.println();

        System.out.print("Enter product name to remove: ");
        String remove= src.next();
        product.remove(remove);
        System.out.println();

        System.out.println(product);
    }

}
