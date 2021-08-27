package Account;
import java.util.Scanner;
import java.io.*;
import Delay.Delay;
import Assistant.Assistant;
import Year.Year;
import java.security.*;
public class Account
{
    public static Scanner scan = new Scanner(System.in);
    public static Delay obj = new Delay();
    public static Assistant ass = new Assistant();
    public static Year yr = new Year();
    public static void main()
    {
        System.out.println("***************WeLcOmE To My AcCoUnT***************");
        login();
    }
    private static void login()
    {
        String an1;
        obj.del();
        System.out.println("Please enter your Account Number:");
        String an = scan.nextLine();
        int idx = an.length();
        try
        {
            int acno = Integer.parseInt(an);
            an1 = Integer.toString(acno);
            if(idx==5)
            {
                 System.out.println("Enter your password:");
                 String pwd = scan.nextLine();
                 pwd = pwd.trim();
                 int pwdlength = pwd.length();
                 System.out.print("\f");
                 pwdformat(acno,pwdlength);
                 String uniqueid = an1.concat(pwd);
                 match(uniqueid);
            }
            else if(idx<5 || idx>5)
            {
                System.out.println("Error: Account number contains only 5 number digits");
                obj.del();
                obj.del();
                obj.del();
                obj.del();
                System.out.print("\f");
                main();
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: Account number contains only numbers");
            obj.del();
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            main();
        }
    }
    private static void profile(String p)
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(p+".txt"));
            String str;
            while((str = in.readLine()) != null)
            {
                String str2 = str;
                int idx;
                idx = str2.indexOf(";");
                String id = str2.substring(0,idx);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String name = str2.substring(0,idx);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String g = str2.substring(0,idx);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String by = str2.substring(0,idx);
                int age = Integer.parseInt(by);
                age = yr.yr(age);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String caste = str2.substring(0,idx);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String bal1 = str2.substring(0,idx);
                long bal = Long.parseLong(bal1);
                obj.del();
                obj.del();
                obj.del();
                System.out.print("\f");
                System.out.print("*....please wait while assistant makes things ready for you...*");
                //the above sentence is just for the user..(assistant is not getting anything ready for the user)
                obj.del();
                obj.del();
                obj.del();
                System.out.print("\f");
                ass.recieve_identity(id,name,g,age,caste,bal,p);
            }            
        }
        catch(IOException e)
        {
        }
    }
    private static void match(String id)
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("Profiles.txt"));
            String str;
            String p;
            for(int i=1; i<4; i++)
            {
                str = in.readLine();    
                if(str.equals(id))
                    {
                        System.out.println("Data Found");
                        p = "Profile"+i;
                        profile(p);
                        break;
                    }
                    else
                    {
                        if(i<3)
                        {
                        } 
                        else
                        {
                            System.out.println("Error: Account number and password didn't match");
                            System.out.println("Please try again,");
                            obj.del();
                            obj.del();
                            obj.del();
                            System.out.print("\f");
                            main();
                        }
                    }
            } 
        }
        catch(IOException e)
        {
            System.out.println("File not found");
        }
    }
    private static void pwdformat(int an,int pwdlength)
    {
        System.out.println("***************WeLcOmE To My AcCoUnT***************");
        System.out.println("Please enter your Account Number:");
        System.out.println(an);
        System.out.println("Enter your password:");
        for(int i=1;i<=pwdlength;i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}