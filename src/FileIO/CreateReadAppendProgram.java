package FileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CreateReadAppendProgram {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Write inside file: ");
        String inFile = src.nextLine();
        try {

            FileWriter w = new FileWriter("CRUD.csv" , true);
            w.write(inFile);
            w.close();
            System.out.println("Successfully written");

             String r = Files.readString(Path.of("CRUD.csv"));
             System.out.print(r);

        }
        catch (IOException e){
            System.out.print("Something went wrong");
        }

    }
}
