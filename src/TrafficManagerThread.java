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
        try
        {
            Thread.sleep(500);
            exitCars();
        }
        catch(InterruptedException ie)
        {
           System.out.println("Unable to sleep");
        }
    }
    public void exitCars()
    {

        for(int lane = 1; lane < 6; lane++)
        {
            for (int car = 0; car < 10; car++)
            {
                try{
                    switch(lane)
                    {
                        case 1: 
                            System.out.println("Lane 1: Car exitting on " + trafficData.laneOne.get(0));
                            trafficData.laneOne.remove(0);
                            break;
                        case 2: 
                            System.out.println("Lane 2: Car exitting on " + trafficData.laneTwo.get(0));
                            trafficData.laneTwo.remove(0);
                            break;
                        case 3: 
                            System.out.println("Lane 3: Car exitting on " + trafficData.laneThree.get(0));
                            trafficData.laneThree.remove(0);
                            break;
                        case 4: 
                            System.out.println("Lane 4: Car exitting on " + trafficData.laneFour.get(0));
                            trafficData.laneFour.remove(0);
                            break;
                        case 5: 
                            System.out.println("Pedestrains: Pedestrain crossing on lane " + trafficData.pedestrians.get(0));
                            trafficData.pedestrians.remove(0);
                            break;
                        default:
                            break;

                    }
                }
                catch(Exception i)
                {
                    System.out.println("Lane empty");
                }
                    
            }
        }
        
    }
}
