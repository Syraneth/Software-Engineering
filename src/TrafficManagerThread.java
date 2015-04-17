import java.net.*; 
import java.io.*; 
public class TrafficManagerThread implements Runnable {
    Socket echoSocket;
    TrafficData trafficData;

    TrafficManagerThread(Socket socket, TrafficData tData)
    {
        echoSocket = socket; 
        trafficData = tData;
    }
    @Override
    public void run()
    {
 
        
    }
}
