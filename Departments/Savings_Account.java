package Departments;
import java.util.Scanner;
import java.io.*;
import Assistant.Assistant;
import Delay.Delay;
import Year.Year;
public class Savings_Account
{
    public static Assistant ass = new Assistant();
    public static Delay obj = new Delay();
    public static Scanner scan = new Scanner(System.in);
    public static Year yr = new Year();
    public static void main(String g,int age,String caste,String p)
    {
        ass.face();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(p+"sa.txt"));
            System.out.println(g+", you already have a savings account opened...would you like to see its status?");
            String input = scan.nextLine();
            if(input.matches(".*y.*"))
            {
                String str = br.readLine();
            }
            else
            {
                System.out.println("Ok then, I'll consider it as a 'no' from you\nBut "+g+", remember you cannot open another savings account before closing it");
            }
        }
        catch(IOException e)
        {
            System.out.println(g+", you don't have a savings account opened...would you like to open one?\nIn savings account, you can withdraw/add money anytime but the interest will be given on the minimum balance of the month(Interest Given = 4%)");
            String input = scan.nextLine();
            if(input.matches(".*y.*"))
            {
                sa(g,age,caste,p);
            }
            else
            {
                System.out.println("Ok then, I'll consider it as a 'no' from you");
                reset(g,age,caste,p);        
            }
        }
    }
    private static void sa(String g,int age,String caste,String p)
    {
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        System.out.println(g+", minimum balance to be deposited must between Rs.5 thousand and Rs.50 crore\nWould you like to deposit?");
        String input = scan.nextLine();
        try
        {
            if(input.matches(".*y.*"))
            {
                System.out.print("\f");
                ass.face();
                obj.del();
                obj.del();
                System.out.println(g+", how much money would you like to deposit?");
                double money = scan.nextDouble();
                if(money>5000 && money<500000000)
                {
                    update(g,age,caste,p,money);
                }
                else if(money<5001 || money>500000001)
                {
                    System.out.println("Error: I told you to enter money between Rs.5 thousand and Rs. 5 crore\nPlease try again,");
                    sa(g,age,caste,p);
                }
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: Please enter only numbers");
            sa(g,age,caste,p);
        }
    }
    private static void update(String g,int age,String caste,String p,double money)
    {
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        System.out.println("*please wait while I open your account "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        String date = yr.date();
        String data = money + "," + date + ";";
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(p+"sa.txt"));
            bw.write(data);
            bw.close();
            System.out.println("Account opened "+g);
            reset(g,age,caste,p);
        }
        catch(IOException e)
        {
            System.out.println("Sorry "+g+", could not open your account...please try later");
            reset(g,age,caste,p);
        }
    }
    private static void reset(String g,int age,String caste,String p)
    {
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        System.out.println("*please wait while i load the main screen for you "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        ass.recieve(g,age,caste,p);
    }
}