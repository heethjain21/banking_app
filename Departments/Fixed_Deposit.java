package Departments;
import java.util.*;
import java.io.*;
import Assistant.Assistant;
import Delay.Delay;
import Year.Year;
public class Fixed_Deposit
{
    public static Assistant ass = new Assistant();
    public static Delay obj = new Delay();
    public static Scanner scan = new Scanner(System.in);
    public static Year yr = new Year();
    private static void fd(String g,int age,String caste,String p)
    {
        System.out.print("\f");
        ass.face();
        System.out.println(g+", you dont have any Fixed Deposit record, would you like to open one?");
        System.out.println(g+", if you would like to know more about it then type 'explain' and I will give you a brief idea about it");
        String input = scan.nextLine();
        input = input.toLowerCase();
        if(input.equals("explain"))
        {
            System.out.println("A fixed deposit (FD) is a financial instrument which provides you with a higher rate of interest than a regular savings account, until the decided time.");
            main(g,age,caste,p);
        }
        else if(input.matches(".*y.*"))
        {
            obj.del();
            obj.del();
            System.out.print("\f");
            fixed_deposit(g,age,caste,p);
        }
        else if(input.matches("n"))
        {
            System.out.print("\f");
        }
        else
        {
            System.out.println("Sorry, I didn't get you...can you please rephrase that?");
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            main(g,age,caste,p);
        }
    }
    public static void main(String g,int age,String caste,String p)
    {
        try
        {
           ass.face();
           obj.del();
           obj.del();
           BufferedReader br = new BufferedReader(new FileReader(p+"fd.txt"));
           System.out.println(g+", this is your record:");
           String str;
           while((str = br.readLine()) != null)
           {
               System.out.println(str);
           }
           System.out.println("*it is in the format (Maturity Amount,Date of money deposited,type of scheme;)*");
           String input = scan.nextLine();
           reset(g,age,caste,p);
        }
        catch(IOException e)
        {
            fd(g,age,caste,p);
        }
    }
    private static void fixed_deposit(String g,int age,String caste,String p)
    {
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        System.out.println(g+", we provide Fixed Deposit with 3 different schemes:\nYearly\nHalf-Yearly\nQuarterly");
        System.out.println("*if you want to have more information on this, then please tpe 'explain' so that i could give you a brief idea about it and the interest given too*");
        String input = scan.nextLine();
        input = input.toLowerCase();
        if(input.matches(".*yearly.*"))
        {
            fdyearly(g,age,caste,p);
        }
        else if(input.matches(".*half.*" + ".*yearly.*"))
        {
            fdhalfyearly(g,age,caste,p);
        }
        else if(input.matches(".*quarterly.*"))
        {
            fdquarterly(g,age,caste,p);
        }
        else if(input.equals("explain"))
        {
            obj.del();
            obj.del();
            System.out.print("\f");
            ass.face();
            obj.del();
            obj.del();
            System.out.println("Fixed Deposit:");
            System.out.println("Yearly: In this type of deposit, you can invest youe money for a year and cannot remove it before a year            (Interest Charged = 8.2% per annum");
            System.out.println("Half-Yearly: In this type of deposit, you can invest your money for half year and cannot remove it before a year    (Interest Charged = 8% per annum)");
            System.out.println("Quarterly: In this type of deposit, you can invert your money for a quarter year and cannot remove money before that(Interest Charged = 7.8% per annum)");
            System.out.println("*if you want to remove the money before the time decided then you can but you will not get interest on your invested money*");
            String input2 = scan.nextLine();
            obj.del();
            obj.del();
            obj.del();
            fixed_deposit(g,age,caste,p);
        }
        else
        {
            System.out.println("Sorry "+g+", I didn't get you..could you please rephrase that?");
            obj.del();
            obj.del();
            System.out.print("\f");
            fixed_deposit(g,age,caste,p);
        }
    }
    private static void fdyearly(String g, int age, String caste, String p)
    {
      try
      { 
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        String type = "yearly";
        double R = 8.2;
        double T = 1;
        System.out.println("How much money do you want to deposit "+g+"?");
        double P = scan.nextDouble();
        if(P<10000 || P>500000000)
        {
            System.out.println("Error: Amount deposited must be between range Rs.10 thousand and Rs.50 crore");
            fdyearly(g,age,caste,p);
        }
        else{
        if(age>59 && (caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")))
        {
            R = 8.6;
        }
        else if(age>59 || (caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")))
        {
            R = 8.4;
        }
        else
        {
            R = 8.2;
        }
        double res = calculate(P,T,R);
        update(g,res,type,p);
        reset(g,age,caste,p);
      }}
      catch(NumberFormatException e)
      {
          System.out.println("Error: Please enter only numbers");
          fdyearly(g,age,caste,p);
      }
    }
    private static void fdhalfyearly(String g, int age, String caste, String p)
    {   
      try
      {
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        String type = "half-yearly";
        double R = 8;
        double T = 0.5;
        System.out.println("How much money do you want to deposit "+g+"?");
        double P = scan.nextDouble();
        if(P<10000 || P>500000000)
        {
            System.out.println("Error: Amount deposited must be between range Rs.10 thousand and Rs.5 crore");
            fdhalfyearly(g,age,caste,p);
        }
        else{
        if(age>59 && (caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")))
        {
            R = 8.4;
        }
        else if(age>59 || (caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")))
        {
            R = 8.2;
        }
        else
        {
            R = 8;
        }
        double res = calculate(P,T,R);
        update(g,res,type,p);
        reset(g,age,caste,p);
      }}
      catch(NumberFormatException e)
      {
          System.out.println("Error: Please enter only numbers");
          fdhalfyearly(g,age,caste,p);
      }
    }
    private static void fdquarterly(String g, int age, String caste, String p)
    {
      try
      {
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        String type = "quarterly";
        double R = 7.8;
        double T = 0.25;
        System.out.println("How much money do you want to deposit "+g+"?");
        double P = scan.nextDouble();
        if(P<10000 && P>500000000)
        {
            System.out.println("Error: Amount deposited must be between range Rs.10 thousand and Rs.5 crore");
            fdquarterly(g,age,caste,p);
        }
        else{
        if(age>59 && (caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")))
        {
            R = 8.2;
        }
        else if(age>59 || (caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")))
        {
            R = 8;
        }
        else
        {
            R = 7.8;
        }
        double res = calculate(P,T,R);
        update(g,res,type,p);
        reset(g,age,caste,p);
      }}
      catch(NumberFormatException e)
      {
          System.out.println("Error: Please enter only numbers");
          fdquarterly(g,age,caste,p);
      }
    }
    private static double calculate(double P, double T, double R)
    {
        double res;
        res = ((P*T*R)/100) + P;
        return res;
    }
    private static void update(String g, double res, String type, String p)
    {
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        System.out.println("*please wait while I update your data "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        try
        {
            String date = yr.date();
            String data = res + "," + date + "," + type + ";";
            BufferedWriter out = new BufferedWriter(new FileWriter(p+"fd.txt"));
            out.write(data);
            out.close();
            obj.del();
            obj.del();
            System.out.println("Data updated "+g);
            String input = scan.nextLine();
        }
        catch(IOException e)
        {
            obj.del();
            obj.del();
            System.out.println("Sorry "+g+",could not update your data\nPlease try again later");
        }
    }
    private static void reset(String g,int age,String caste,String p)
    {
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        System.out.println("*please wait while i load the main screen for you "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        ass.recieve(g,age,caste,p);
    }
}