package FileIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CreateWriteFile {
    public static void main(String[] args) throws IOException {
        FileWriter a = new FileWriter("text.txt");
        String b = "Hello people..... Java\n" +
                "1. I am reading a book.\n" +
                "2. She is cooking dinner.\n" +
                "3. They are playing football.\n" +
                "4. He is running in the park.\n" +
                "5. We are studying for the exam.\n" +
                "6. The dog is barking loudly.\n" +
                "7. You are writing an email.\n" +
                "8. The children are eating ice cream.\n";
        a.write(b);
        System.out.println("Created");
        a.close();

//        String a = Files.readString(Path.of("text.txt"));
//        System.out.print(a);

        try {
            List<String> r = Files.readAllLines(Path.of("text.txt"));
            for(String line : r){
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
