package FileIO;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException{
        File s = new File("Student.txt");
        if(s.createNewFile()){
            System.out.print("Created ");
        }else{
            System.out.print("NOt created");
        }
    }
}
