import java.net.*; 
import java.io.*; 
import java.util.StringTokenizer;
import java.util.Arrays;
import java.lang.String;


public class InputThread implements Runnable {
    
    private int[] carsEntered = {0,0,0,0};
    private int[] carsExited = {0,0,0,0};
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
                //System.out.println("echo: " + in.readLine());
                StringTokenizer st = new StringTokenizer(in.readLine(),";");
                while (st.hasMoreTokens()) 
                {
                    String temp = st.nextToken();
                    if(temp.length() == 1)
                    {
                        System.out.println("Ett");
                    }
                    else
                    {
                        breakdownToken(temp);  
                    }
                    System.out.println("this: "+temp);
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
    public void breakdownToken(String data){
        StringTokenizer breakdown = new StringTokenizer(data,":");
        boolean ioCheck = true;
        while(breakdown.hasMoreTokens())
        {
            String current = breakdown.nextToken();
            if(ioCheck == true)
            {
                carsEntered = enterData(carsEntered,current);
            }
            else
            {
                carsExited = enterData(carsExited,current);
            }
            System.out.println(current);
            ioCheck = !ioCheck;
        }
        System.out.println(java.util.Arrays.toString(carsEntered));
        System.out.println(java.util.Arrays.toString(carsExited));
    }
    public int[] enterData(int[] array, String token)
    {
        switch(token){
            case "1":
                array[0]++;
                break;
            case "2":
                array[1]++;
                break;
            case "3":
                array[2]++;
                break;
            case "4":
                array[3]++;
                break;
            default:
                break;
        }
        return array;
    }
}

