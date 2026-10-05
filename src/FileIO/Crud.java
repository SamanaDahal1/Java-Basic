package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Crud {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        while(true) {
            System.out.println("\n\tFile Manager\n=========================");
            System.out.println("Enter 1/2/3/4/5 for\n" +
                    "1. Add\n" +
                    "2. Read\n" +
                    "3. Update\n" +
                    "4. Delete\n" +
                    "5. Exit\n" +
                    "=========================");
            int choice = src.nextInt();
            src.nextLine();
            try {
                if (choice == 1) {
                    FileWriter writeFile = new FileWriter("FileManager.txt", true);
                    System.out.print("Write inside file: ");
                    String addText = src.nextLine();
                    writeFile.write(addText);
                    writeFile.close();
                    System.out.println("Wrote Successfully");
                } else if (choice == 2) {
                    String readFile = Files.readString(Path.of("FileManager.txt"));
                    System.out.println(readFile);
                } else if (choice == 3) {
                    FileWriter upFile = new FileWriter("FileManager.txt");
                    System.out.print("Update file: ");
                    String upText = src.nextLine();
                    upFile.write(upText);
                    upFile.close();
                    System.out.print("Updated Successfully");
                } else if (choice == 4) {
                    File del = new File("FileManager.txt");
                    if (del.delete()) {
                        System.out.println("Deleted Successfully");
                    } else {
                        System.out.print("Deletion Failed");
                    }
                } else if (choice == 5) {
                    System.out.println("Thank You");
                    System.exit(0);
                } else {
                    System.out.println("Invalid Input");
                }

            } catch (IOException e) {
                System.out.print("Something went wrong " + e.getMessage());
            }
        }
    }
}
