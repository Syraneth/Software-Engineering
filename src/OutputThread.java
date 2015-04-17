import java.net.*; 
import java.io.*; 
public class OutputThread implements Runnable{
	
    Socket echoSocket;
    TrafficData trafficData;
    

    OutputThread(Socket socket, TrafficData tData)
    {
        echoSocket = socket; 
        trafficData = tData;
    
    }
    
    @Override
    public void run()
    {
        PrintWriter out = null;

        try 
        {
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;

       
            while ((userInput = stdIn.readLine()) != null) 
            {
                out.println(userInput);
                System.out.print ("input: ");
            }
            
         
            
            out.close();
            echoSocket.close();

        } 
        catch (UnknownHostException e) 
        {  
            System.err.println();            
            System.exit(1);           
        } 
        catch (IOException e) {            
            System.err.println();            
            System.exit(1);            
        }

    }
}

