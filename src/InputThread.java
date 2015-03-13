import java.net.*; 
import java.io.*; 
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
	        in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

	        while (true) {
		    	System.out.println("echo: " + in.readLine());	       
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

