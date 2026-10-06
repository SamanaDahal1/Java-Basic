package Java8Features;

import java.util.function.Supplier;

public class SupplierPractice {
    public static void main(String[] args){
        Supplier<String > supplier = ()->{
            String store = "Hello, Java";
            return store;
        };
        System.out.println(supplier.get());
    }
}
