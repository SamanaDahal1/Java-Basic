package ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionAndPropagation {
    void processFile() throws FileNotFoundException{
        readFile();

    }
    void readFile() throws FileNotFoundException {
        FileReader reader = new FileReader("text.txt");
        System.out.println(reader);
    }
    public static void main(String[] args){
             CheckedExceptionAndPropagation a = new CheckedExceptionAndPropagation();
             try {
                 a.processFile();
             } catch (FileNotFoundException e) {
                 System.out.println("THis file doent exist");
             }
             System.out.println("Program ended");
    }
}
