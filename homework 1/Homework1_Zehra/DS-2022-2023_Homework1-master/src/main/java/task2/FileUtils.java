package task2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class FileUtils {

    public static ArrayList<String> readFile(String filePath) throws FileNotFoundException {
       /* File file = new File("filepath");
        Scanner s = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();

        return list;
        */
        //likely that there is an error here, but I couldn't figure it out in time
        
        
        ArrayList<String> lines = new ArrayList<>();

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        scanner.close();

        return lines;


    }
}
