package Departments;
import java.util.*;
import java.io.*;
import Delay.Delay;
import Assistant.Assistant;
import Year.Year;
public class Recurring_Deposit
{
    public static Delay obj = new Delay();
    public static Scanner scan = new Scanner(System.in);
    public static Assistant ass = new Assistant();
    public static Year yr = new Year();
    public static void main(String g,int age,String caste,String p)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(p+"rd.txt"));
            ass.face();
            obj.del();
            obj.del();
            System.out.println(g+", you are already having an active scheme and cannot choose another untill current scheme expires");
            String input = scan.nextLine();
            System.out.print("\f");
            reset(g,age,caste,p);
        }
        catch(IOException e)
        {
            ass.face();
            obj.del();
            obj.del();
            System.out.println(g+", It seems like you dont have any scheme activated...would you like to have one?");
            String input = scan.nextLine();
            System.out.print("\f");
            input = input.toLowerCase();
            recurring_deposit(g,age,caste,p,input);
        }
    }
    private static void recurring_deposit(String g,int age,String caste,String p,String input)
    {
        ass.face();
        obj.del();
        obj.del();
        if(input.matches(".*y.*"))
        {
            System.out.println(g+", we provide 5 Recurring Deposit schemes");
            System.out.println("12 months scheme     (Interest Charged = 7.00%)");
            System.out.println("18 months scheme     (Interest Charged = 7.25%)");
            System.out.println("24 months scheme     (Interest Charged = 7.50%)");
            System.out.println("30 months scheme     (Interest Charged = 7.75%)");
            System.out.println("36 months scheme     (Interest Charged = 8.00%)");
            System.out.println("*you can deposit money for the above period every month and you will get the interest in return*");
            input = scan.nextLine();
            input = input.toLowerCase();
            System.out.print("\f");
            ass.face();
            obj.del();
            obj.del();
            if(input.matches(".*12.*" + ".*month.*") || input.matches(".*12.*"))
            {
                System.out.println(g+", how much money would you like to deposit monthly?(Amount should be between Rs.500 and Rs.50000)");
                double money = scan.nextInt();
                input = "12";
                double i = 7;
                update(g,age,caste,p,input,money,i);
            }
            else if(input.matches(".*18.*" + ".*month.*") || input.matches(".*18.*"))
            {
                System.out.println(g+", how much money would you like to deposit monthly?(Amount should be between Rs.500 and Rs.50000)");
                double money = scan.nextInt();
                input = "18";
                double i = 7.25;
                update(g,age,caste,p,input,money,i);
            }
            else if(input.matches(".*24.*" + ".*month.*") || input.matches(".*24.*"))
            {
                System.out.println(g+", how much money would you like to deposit monthly?(Amount should be between Rs.500 and Rs.50000)");
                double money = scan.nextInt();
                input = "24";
                double i = 7.5;
                update(g,age,caste,p,input,money,i);
            }
            else if(input.matches(".*30.*" + ".*month.*") || input.matches(".*30.*"))
            {
                System.out.println(g+", how much money would you like to deposit monthly?(Amount should be between Rs.500 and Rs.50000)");
                double money = scan.nextInt();
                input = "30";
                double i = 7.75;
                update(g,age,caste,p,input,money,i);
            }
            else if(input.matches(".*36.*" + ".*month.*") || input.matches(".*36.*"))
            {
                System.out.println(g+", how much money would you like to deposit monthly?(Amount should be between Rs.500 and Rs.50000)");
                double money = scan.nextInt();
                input = "36";
                double i = 8;
                update(g,age,caste,p,input,money,i);
            }
        }
        else
        {
            System.out.println("I'll take it as a 'no' from your side");
            reset(g,age,caste,p);
        }
    }
    private static void update(String g,int age,String caste,String p,String months,double money,double i)
    {
        int n = Integer.parseInt(months);
        double P = money;
        double r = i;
        double ma = (P*n)+(P*(n*(n+1))*r)/(2*100*12);
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        System.out.println("*please wait while I update your database "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        String date = yr.date();
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(p+"rd.txt"));
            String data = "Amount Deposited = " + money + ",Maturity Amount = " + ma + "," + date + ";";
            bw.write(data);
            bw.close();
            System.out.println("Database updated "+g);
            String input = scan.nextLine();
        }
        catch(IOException e)
        {
            System.out.println("Sorry "+g+", could not update your data\nPlease try again later");
        }
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        reset(g,age,caste,p);
    }
    private static void reset(String g,int age,String caste,String p)
    {
        ass.face();
        obj.del();
        obj.del();
        System.out.println("*please wait while I load the main screen for you "+g+"*");
        ass.recieve(g,age,caste,p);
    }
}