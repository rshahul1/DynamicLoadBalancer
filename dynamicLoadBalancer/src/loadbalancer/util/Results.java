package loadbalancer.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface , StdoutDisplayInterface{
    @Override
    public void writeToFile(String s, String s1) {
        BufferedWriter bw = null;
        try {

            File f = new File(s1);

            if (!f.exists()||f.exists()) {
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f);
            bw = new BufferedWriter(fw);


            bw.write(s);
            bw.newLine();

        }catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception e){
                System.out.println("BufferedWriter closing error "+e);
            }
        }

    }

    @Override
    public void writeToStdout(String s) {
        System.out.println(s);

    }
}
