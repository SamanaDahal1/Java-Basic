package FileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFile {
    public static void main(String[] args)throws IOException {
        FileWriter file = new FileWriter("Manager.csv");
        file.write("name , age");
        file.close();
        System.out.println("done");
        try{
        String readFile = Files.readString(Path.of("Manager.csv"));
        String[] hello =readFile.split(",");
        for(String hi : hello) {
            System.out.println(hi.trim());
        }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
