import java.net.*; 
import java.io.*; 
public class EchoClient 
{
    public static void main(String[] args)
    {
        String serverHostname = new String("192.168.0.142");
        int portNum = 5000; 
        System.out.println("Attempting to connect to host" + serverHostname + "on port " + portNum); 

        Socket echoSocket = null; 


        try {

                echoSocket = new Socket(serverHostname, portNum);

                OutputThread output = new OutputThread(echoSocket); 
                InputThread input = new InputThread(echoSocket);

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
