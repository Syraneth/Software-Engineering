import java.net.*; 
import java.io.*; 
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class EchoClient 
{
    
    public static void main(String[] args)
    {
        String serverHostname = new String("192.168.0.133");
        int portNum = 5000; 
        System.out.println("Attempting to connect to host" + serverHostname + "on port " + portNum); 

        Socket echoSocket = null; 
        TrafficData trafficData = new TrafficData();

        try {

                echoSocket = new Socket(serverHostname, portNum);

                OutputThread output = new OutputThread(echoSocket, trafficData); 
                InputThread input = new InputThread(echoSocket, trafficData);

                Thread t1 = new Thread(output); 
                Thread t2 = new Thread(input); 

                t1.start();
                t2.start(); 

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }
	

}
