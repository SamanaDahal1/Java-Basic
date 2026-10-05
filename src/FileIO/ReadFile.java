package FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
    public static void main(String[] args){
        try {
           String r = Files.readString(Path.of("Students.txt"));
           System.out.print(r);

        } catch (IOException e) {
            System.out.print("Not found");

        }
    }
}
