package loadbalancer.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileProcessor {
    public ArrayList<String> readLine(String filename){
        ArrayList<String> lines=new ArrayList<String>();
        String line = null;

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line=bufferedReader.readLine())!=null) {
                lines.add(line);
            }
            bufferedReader.close();
        }

        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        catch(IOException e) {
            e.printStackTrace();

        }
        return lines;
    }

}
