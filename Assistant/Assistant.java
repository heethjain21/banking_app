package Assistant;
import java.util.Scanner;
import java.io.*;
import Delay.Delay;
import Departments.*;
import Year.Year;
public class Assistant
{
    public static Delay obj = new Delay();
    public static Scanner scan = new Scanner(System.in);
    public static Loan loan = new Loan();
    public static Fixed_Deposit fd = new Fixed_Deposit();
    public static Recurring_Deposit rd = new Recurring_Deposit();
    public static Savings_Account sa = new Savings_Account();
    public static Year yr = new Year();
    public static void recieve_identity(String id,String name,String g,int age,String caste,long bal,String p)
    {
        main(g,age,caste,p);
    }
    public static void face()
    {
        System.out.println("+-----------+");
        System.out.println("|  \u25c9     \u25c9  |");
        System.out.println("|     \u25b4     |");
        System.out.println("|     \u25e1     |");
        System.out.println("+-----------+");
    }
    private static void main(String g,int age,String caste,String p)
    {
        if(g.equals("m"))
        {
            g = "Sir";
        }
        else if(g.equals("f"))
        {
            g = "Madam";
        }
        else
        {
            g = "";
        }
        face();
        input(g,age,caste,p);
    }
    private static void input(String g,int age,String caste,String p)
    {
        String input;
        String output[] = new String[2];
        output[0] = "Hello "+g;
        output[1] = "How may i help you "+g+"?";
        for(int i=0;i<=1;i++)
        {
            System.out.println(output[i]);
            input = scan.nextLine();
            input = input.toLowerCase();
            if(i<1)
            {
                input = null;
                System.out.print("\f");
                face();
            }
            if(i==1)
            {
                help(input,g,age,caste,p);
            }
        }
    }
    private static void help(String input,String g,int age,String caste,String p)
    {
        if(input.matches(".*want.*" + ".*loan.*") || input.matches(".*need.*" + ".*loan.*") || input.matches(".*need.*"+".*money.*") || input.matches(".*want.*"+".*money.*") || input.matches(".*require.*"+".*money.*") || input.matches(".*require.*"+".*loan.*") || input.matches(".*get.*"+".*loan.*") || input.matches(".*get.*"+".*money.*"))
        // in th above statement, .* has a role..... dot means any character can be input and star means any number of times iot can be input
        {
            System.out.print("\f");
            face();
            System.out.println(g+", what type of loan would you like to have?\nWe provide:-\nPersonal Loan\nEducation Loan\nHome Loan\n*if you dont understand what is this then please type 'explain'...I will explain it to you in brief*");
            String loantype = scan.nextLine();
            loantype = loantype.toLowerCase();
            if(loantype.matches(".*personal.*"))
            {
                loantype = "personal";
                callloan(input,g,age,caste,loantype,p);
            }
            else if(loantype.matches(".*home.*"))
            {
                loantype = "home";
                callloan(input,g,age,caste,loantype,p);
            }
            else if(loantype.matches(".*education.*"))
            {
                loantype = "education";
                callloan(input,g,age,caste,loantype,p);
            }
            else if(loantype.equals("explain"))
            {
                System.out.print("\f");
                face();
                try
                {
                    BufferedReader in = new BufferedReader(new FileReader("LoanTypes.txt"));
                    String str;
                    while((str = in.readLine()) != null)
                    {
                        System.out.println(str);
                    }
                    String tp = scan.nextLine();
                    tp = null;
                    System.out.print("\f");
                    help(input,g,age,caste,p);
                }
                catch(IOException e)
                {
                    System.out.println("File not Found");
                }
            }
            else
            {
                System.out.println("Sorry "+g+", i cannot understand you...could you please rephrase that?");
                help(input,g,age,caste,p);
            }
        }
        else if(input.matches(".*repay.*" + ".*loan.*") || input.matches(".*return.*" + ".*loan.*"))
        {
            System.out.println(g+", I am upgrading everyday. Currently i cannot do that for you "+g+", but will sure be able to do that in future\nSorry for the inconvenience "+g);
            retry(g,age,caste,p);
        }
        else if(input.matches(".*fixed.*" + ".*deposit.*") || input.matches(".*fix.*" + ".*deposit.*") || input.matches(".*fd.*"))
        {
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            face();
            obj.del();
            obj.del();
            obj.del();
            callfd(g,age,caste,p);
        }
        else if(input.matches(".*ac*" + ".*details.*") || input.matches(".*a/c*" + ".*details.*") || input.matches(".*ac*" + ".*info.*") || input.matches(".*a/c*" + ".*info.*"))
        {
            obj.del();
            obj.del();
            System.out.print("\f");
            face();
            System.out.println("*please wait while I load up your account details*");
            obj.del();
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            face();
            obj.del();
            obj.del();
            try
            {
                BufferedReader br = new BufferedReader(new FileReader(p+".txt"));
                String str;
                str = br.readLine();
                String str2 = str;
                int idx;
                idx = str2.indexOf(";");
                String id = str2.substring(0,idx);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String name = str2.substring(0,idx);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String gender = str2.substring(0,idx);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String by = str2.substring(0,idx);
                age = Integer.parseInt(by);
                age = yr.yr(age);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                caste = str2.substring(0,idx);
                str2 = str2.substring(idx+1);
                idx = str2.indexOf(";");
                String bal1 = str2.substring(0,idx);
                long bal = Long.parseLong(bal1);
                System.out.println(g+", this is your Account Details:");
                System.out.println("Name:                    "+name);
                System.out.println("Gender:                  "+gender);
                System.out.println("Age:                     "+age);
                System.out.println("Account Number:          "+(id.substring(0,5)));
                System.out.println("Caste:                   "+caste);
                System.out.println("Current Account Balance: "+bal);
                String inputt = scan.nextLine();
                retry(g,age,caste,p);
            }
            catch(IOException e)
            {
            }
        }
        else if(input.matches(".*recurring.*" + ".*deposit.*") || input.matches(".*reccuring.*" + ".*deposit.*") || input.matches(".*recuring.*" + ".*deposit.*") || input.matches(".*rd.*"))
        {
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            face();
            callrd(g,age,caste,p);
        }
        else if(input.matches(".*saving.*" + ".*account.*") || input.matches(".*sa.*"))
        {
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            face();
            callsa(g,age,caste,p);
        }
        else if(input.matches(".*bye.*") || input.matches(".*exit.*") || input.matches(".*cya.*") || input.matches(".*quit.*") || input.matches(".*see.*" + ".*you.*"))
        {
            obj.del();
            obj.del();
            System.out.print("\f");
            face();
            System.out.println("Ok then, take care "+g);
            obj.del();
            obj.del();
            System.exit(0);
        }
        else if(input.matches(".*what.*" + ".*my.*" + ".*balance.*"))
        {
            System.out.println("Yes "+g+", but can you tell me which account's balance you want to check?\n*just wanted to confirm "+g+" so that there is no mistake*");
            String inputt = scan.nextLine();
            inputt = inputt.toLowerCase();
            if(inputt.matches(".*saving.*")|| input.matches(".*sa.*"))
            {
                obj.del();
                obj.del();
                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(p+"sa.txt"));
                    String str;
                    str = br.readLine();                
                    int idx = str.indexOf(",");
                    double balance = Double.parseDouble(str.substring(0,idx));
                    System.out.println(g+", your account balance is Rs. "+balance);
                    inputt = scan.next();
                    obj.del();
                    obj.del();
                    obj.del();
                    obj.del();
                    retry(g,age,caste,p);
                }
                catch(IOException e)
                {
                    System.out.println(g+", you don't have an active Savings Account");
                    obj.del();
                    obj.del();
                    obj.del();
                    obj.del();
                    retry(g,age,caste,p);
                }
            }
            else if(inputt.matches(".*current.*") || input.matches(".*curent.*") || input.matches(".*ca.*"))
            {
                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(p+".txt"));
                    String str;
                    str = br.readLine();                
                    int idx = str.lastIndexOf(";");
                    str = str.substring(0,idx);
                    idx = str.lastIndexOf(";");
                    String bal = str.substring(idx+1);
                    double balance = Double.parseDouble(bal);
                    System.out.println(g+", your account balance is Rs. "+balance);
                    inputt = scan.next();
                    obj.del();
                    obj.del();
                    obj.del();
                    obj.del();
                    retry(g,age,caste,p);
                }
                catch(IOException e)
                {
                }
            }
            else if(inputt.matches(""))
            {
                input = null;
                System.out.println("Sorry "+g+", I cannot understand you...could you please repharse that?");
                obj.del();
                obj.del();
                System.out.print("\f");
                retry(g,age,caste,p);
            }
        }
        else if(input.matches(".*nothing.*") || input.matches(".*nm.*"))
        {
            obj.del();
            obj.del();
            System.out.println("Ok then, good bye "+g);
            System.exit(0);
        }
        else
        {
            System.out.println("Sorry "+g+", I cannot understand you...could you please repharse that?");
            obj.del();
            obj.del();
            System.out.print("\f");
            retry(g,age,caste,p);
        }
    }
    private static void callsa(String g,int age,String caste,String p)
    {
        System.out.print("*please wait while I load up your savings account database "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        sa.main(g,age,caste,p);
    }
    private static void callrd(String g,int age,String caste,String p)
    {
        System.out.println("*please wait while I load up the recurring deposit section for you "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        rd.main(g,age,caste,p);
    }
    private static void callfd(String g,int age,String caste,String p)
    {
        System.out.println("*please wait while I load up the fixed deposit section for you "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        fd.main(g,age,caste,p);
    }
    private static void callloan(String input,String g,int age,String caste,String loantype,String p)
    {
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        face();
        obj.del();
        obj.del();
        System.out.println("*please wait while I set up the loan section for you "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        loan.main(g,age,caste,loantype,p);
    }
    public static void recieve(String g,int age,String caste,String p)
    {
        retry(g,age,caste,p);
    }
    private static void retry(String g,int age,String caste,String p)
    {
        System.out.print("\f");
        face();
        obj.del();
        obj.del();
        String input = null;
        System.out.println("How may I help you "+g+"?");
        input = scan.nextLine();
        help(input,g,age,caste,p);
    }
}