package FileIO;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args)  {
        try {
            FileWriter w = new FileWriter("Students.txt");
            w.write("Hello Students");
            w.close();
            System.out.print("Succesfully Written");
        } catch (IOException e) {
            System.out.print("Not Written ");
        }


    }
}
