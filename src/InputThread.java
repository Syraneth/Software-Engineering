import java.net.*; 
import java.io.*; 
import java.util.StringTokenizer;
public class InputThread implements Runnable {
    
    Socket echoSocket; 

    InputThread(Socket socket)
    {
            echoSocket = socket; 
    }
    @Override
    public void run()
    {
        BufferedReader in = null;

        try {
            System.out.println("Input: ");
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));


            while (true) {
                System.out.println("echo: " + in.readLine());
                StringTokenizer st = new StringTokenizer(in.readLine(),":;");
                while (st.hasMoreTokens()) 
                {
                    System.out.println("this: "+st.nextToken());
                }
                
            }		
            
        } catch (UnknownHostException e) {  
            System.err.println();
            System.exit(1);  
        } catch (IOException e) { 
            System.err.println();  
            System.exit(1); 
        }
    }
}

