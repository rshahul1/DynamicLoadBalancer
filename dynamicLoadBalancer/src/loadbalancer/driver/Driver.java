package loadbalancer.driver;

import loadbalancer.util.FileProcessor;
import loadbalancer.util.Results;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        if ( (args.length != 2) || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {

            System.err.println("Error: Incorrect number of arguments. Program accepts more than 2 arguments.");
            System.exit(0);
        }

        FileProcessor fp=new FileProcessor();
        ArrayList<String> input_data=new ArrayList<String>();
        String[] a=new String[5];
        input_data=fp.readLine(args[0]);

        Results r=new Results();
        String outputString1=" ";


        for(int i=0;i<input_data.size();i++){
            a=input_data.get(i).split(" ");
            if(a[0].equals("CLUSTER_OP__SCALE_UP")){
                outputString1="Cluster Scaled Up";
            }
            else if(a[0].equals("SERVICE_OP__ADD_SERVICE")){
                outputString1="Service Added";
            }
            else if(a[0].equals("REQUEST")){
                outputString1="Processed Request - Service_URL";
            }
            else if(a[0].equals("SERVICE_OP__ADD_INSTANCE")){
                outputString1="Instance Added";
            }
            else if(a[0].equals("SERVICE_OP__REMOVE_SERVICE")) {
                outputString1="Service Removed";
            }
            r.writeToStdout(outputString1);
            r.writeToFile(outputString1,args[1]);
        }
        
    }
}
