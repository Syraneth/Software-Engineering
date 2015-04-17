import java.net.*; 
import java.io.*; 
import java.util.StringTokenizer;
import java.util.Arrays;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;


public class InputThread implements Runnable {
    
    private int[] carsEntered = {0,0,0,0};
    private int[] carsExited = {0,0,0,0};
    
    Socket echoSocket; 
    EchoClient eClient;
    TrafficData trafficData;

    InputThread(Socket socket, TrafficData tData)
    {
        echoSocket = socket; 
        trafficData = tData;
    }
    
    @Override
    public void run()
    {
        BufferedReader in = null;

        try {
            System.out.println("Input: ");
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));


            while (true) {
                StringTokenizer st = new StringTokenizer(in.readLine(),";");
                while (st.hasMoreTokens()) 
                {
                    String temp = st.nextToken();
                    if(temp.length() == 1)
                    {
                        //Pedestrian 
                        trafficData.pedestrians.add(temp);
                    }
                    else
                    {
                        //Car
                        breakdownToken(temp);  
                    }
                    System.out.println("this: "+temp);
                    System.out.println(Arrays.toString(trafficData.laneOne.toArray()));
                    System.out.println(Arrays.toString(trafficData.laneTwo.toArray()));
                    System.out.println(Arrays.toString(trafficData.laneThree.toArray()));
                    System.out.println(Arrays.toString(trafficData.laneFour.toArray()));
                    System.out.println(Arrays.toString(trafficData.pedestrians.toArray()));
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
        String lane = "";
        while(breakdown.hasMoreTokens())
        {
            String current = breakdown.nextToken();
            
            if(ioCheck == true)
            {
                lane = current;
                System.out.println(lane);
            }
            else
            {
                carsExited = enterData(carsExited,current, lane);
                lane = "";
            }
            System.out.println(current);
            ioCheck = !ioCheck;
        }
        
    }
    public int[] enterData(int[] array, String token, String lane)
    {
        switch(lane){
            case "1":
                trafficData.laneOne.add(token);
                break;
            case "2":
                trafficData.laneTwo.add(token);
                break;
            case "3":
                trafficData.laneThree.add(token);
                break;
            case "4":
                trafficData.laneFour.add(token);
                break;
            default:
                break;
        }
        return array;
    }
}

