package FileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Qn1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner src = new Scanner(System.in);
            System.out.print("Enter number of Students: ");
            int size = src.nextInt();
            for(int i = 0; i<size;i++){
                System.out.print("Enter student id: ");
                int id = src.nextInt();
                System.out.print("Enter student name: ");
                String name = src.next();
                System.out.print("Enter student marks: ");
                int marks = src.nextInt();
                System.out.println();
                list.add("id: " +id +" ");
                list.add("Name: "+name + " ");
                list.add("Marks: "+marks + "\n");
            }


        try {
            FileWriter fileWriter = new FileWriter("student.txt");
            for(String s : list){
                fileWriter.write(s);
            }
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("File Not Found to Write" );
        }

        try {
            String readFile = Files.readString(Path.of("studentss.txt"));
            System.out.println(readFile);
        }
        catch (IOException e){
            System.out.println("File not found to read" );
        }
        System.out.println("Thank you");


    }
}
