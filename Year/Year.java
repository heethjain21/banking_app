package Year;
import java.util.Date;
public class Year
{
    public static Date date = new Date();
    @Deprecated
    int yr = 1900 + date.getYear();
    public int yr(int age)
    {
        age = yr - age;
        return age;
    }
    public String date()
    {
        int d = date.getDate();
        int m = 1 + date.getMonth();
        int y = 1900 + date.getYear();
        String d1 = Integer.toString(d) + "." + Integer.toString(m) + "." + Integer.toString(y);
        return d1;
    }
}
