package FileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerWriteFile {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Write what you want to write in a file: ");
        String write = src.nextLine();
        try {
            FileWriter file = new FileWriter("Student.txt");
            file.write(write);
            file.close();
            System.out.println("Successfully Written ");
        }
        catch (IOException e){
            System.out.print("Something went Wrong");
        }
    }
}
