import java.util.*; 
import java.io.*; 

public class DataAnalyser {
    public void stringAnalyser(BufferedReader data)
    {
        StringTokenizer st = new StringTokenizer("this is a test");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        
    }
}
