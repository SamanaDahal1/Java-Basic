package FileIO;

import java.io.File;
import java.io.IOException;

public class DeleteFile {
    public static void main(String[] args) throws IOException{
            File file = new File("Student.txt");
            if (file.delete()) {
                System.out.print("Deleted");
            } else {
                System.out.print("No File Found");
            }
    }
}
