package Delay;
public class Delay
{
    /*public static void del()
    {
        for(int i = -9999999; i<=999999; i++)
        {
             System.out.print("");
             if(i==999)
             {
                 break;
             }
        }
    }
    
     the above delay was made by me using logic but it had a drawback..
     drawback is that the delay timing changes according to the processing speed of machine
     ...hence i used Thread
     */
    public static void del()
    {
       try
       {
           Thread.sleep(800);
           /*here 800 is 800 milliseconds
             Thread is just an sub process in java
             thread.sleep(800) basically means a pause for 800 milliseconds in the execution
           */
       } 
       catch(Exception e)
       {
       }
    }
}
