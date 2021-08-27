import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class DateAndTime
{
    @Deprecated
    public static void main()
    {
        try
        {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            
            String strDate = dateFormat.format(date);
            String strTime = timeFormat.format(date);
            System.out.println("Date = " + strDate);
            System.out.println("Time = " + strTime);
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("xyz.txt"));
            bw.write(strDate + strTime);
            bw.close();
            System.out.println("File Written");
        }
        catch(IOException e)
        {
            System.out.println("Error: Something went wrong. Please try again");
        }
    }
}