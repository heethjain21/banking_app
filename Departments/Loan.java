package Departments;
import java.util.*;
import java.io.*;
import Assistant.Assistant;
import Delay.Delay;
import Year.Year;
public class Loan
{
    public static Delay obj = new Delay();
    public static Assistant ass = new Assistant();
    public static Scanner scan = new Scanner(System.in);
    public static Year yr = new Year();
    public static void main(String g,int age,String caste,String loantype,String p)
    {
      try
      {
          BufferedReader br = new BufferedReader(new FileReader(p+"loan.txt"));
          ass.face();
          System.out.println(g+", you have already taken a loan and cannot take another");
          System.out.println("You need to repay the first loan in order to take another");
          reset(g,age,caste,p);
      }
      catch(IOException e)
      {
          start(g,age,caste,loantype,p);
      }
    }
    private static void start(String g,int age,String caste,String loantype,String p)
    {
        try{
        System.out.print("\f");
        ass.face();
        System.out.println("How much money do you want as loan "+g+"?");
        double loanamt = scan.nextInt();
        if(loantype.equals("home"))
        {
           if(loanamt>100000 && loanamt<50000001)
           {
               loan(g,loanamt,age,caste,loantype,p);
           }
           else
           {
              System.out.println("Error: Please enter loan amount between Rs.1 lakh and Rs.5 Crore");
              obj.del();
              obj.del();
              obj.del();
              main(g,age,caste,loantype,p);
           }
        }
        else if(loantype.equals("education"))
        {
            if(loanamt>100000 && loanamt<5000001)
            {
                loan(g,loanamt,age,caste,loantype,p);
            }
            else
            {
              System.out.println("Error: Please enter loan amount between Rs.1 lakh and Rs.50 lakh");
              obj.del();
              obj.del();
              obj.del();
              main(g,age,caste,loantype,p);
            }
        }
        else
        { 
          if(loanamt>499 && loanamt<5000001)
          {
                loan(g,loanamt,age,caste,loantype,p);
          }
          else
          {
              System.out.println("Error: Please enter loan amount between Rs.500 and Rs.50 lakh");
              obj.del();
              obj.del();
              obj.del();
              main(g,age,caste,loantype,p);
          }
        }
      }
      catch(InputMismatchException e)
      {
          System.out.println("Error: Please enter only numbers");
          String output[] = new String[2];
          output[0] = "You can try that next time "+g+", but it seems I need to take some rest now";
          output[1] = "It seems as if I am malfunctioning now "+g+", I should take some rest";
          int rndm = (int) Math.random() * 2;
          System.out.println(output[rndm]);
      }
    }
    private static void loan(String g,double loanamt,int age,String caste,String loantype,String p)
    {
        System.out.print("\f");
        ass.face();
        double P = loanamt;
        double R;
        double N;
        try
        {
        if(loantype.equals("education"))
        {
            R = 8;
            System.out.println("For how many years do you want the Education loan?");
            N = scan.nextDouble();
            if((caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")) && age>59)
            {
                R = 7;
            }
            else if(caste.equals("SC") || caste.equals("ST") || caste.equals("OBC"))
            {
                R = 7.5;
            }
            else if(age>59)
            {
                R = 7.5;
            }
            else
            {
                R = 8;
            }
            double A = calculate_A(P,R,N);
            N = Math.round(N);
            obj.del();
            obj.del();
            System.out.print("\f");
            ass.face();
            obj.del();
            obj.del();
            System.out.println("*please wait while I calculate the amount to be paid by you "+g+"*");
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            ass.face();
            System.out.println(g+", you have to pay Rs. "+A+" in "+N+" years");
            String input = scan.nextLine();
            input = "";
            System.out.print("\f");
            ass.face();
            System.out.println("*please wait while I update your database "+g+"*");
            update(A,p,g,loantype);
            reset(g,age,caste,p);
        }
        else if(loantype.equals("home"))
        {
            R = 9;
            System.out.println("For how many years do you want the Home loan?");
            N = scan.nextDouble();
            if((caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")) && age>59)
            {
                R = 8;
            }
            else if(caste.equals("SC") || caste.equals("ST") || caste.equals("OBC"))
            {
                R = 8.5;
            }
            else if(age>59)
            {
                R = 8.5;
            }
            else
            {
                R = 9;
            }
            double A = calculate_A(P,R,N);
            N = Math.round(N);
            obj.del();
            obj.del();
            System.out.print("\f");
            ass.face();
            obj.del();
            obj.del();
            System.out.println("*please wait while I calculate the amount to be paid by you "+g+"*");
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            ass.face();
            System.out.println(g+", you have to pay Rs. "+A+" in "+N+" years");
            String input = scan.nextLine();
            System.out.print("\f");
            ass.face();
            System.out.println("*please wait while I update your database "+g+"*");
            update(A,p,g,loantype);
            reset(g,age,caste,p);
        }
        else
        {
            R = 10;
            System.out.println("For how many years do you want the Personal loan?");
            N = scan.nextDouble();
            if((caste.equals("SC") || caste.equals("ST") || caste.equals("OBC")) && age>59)
            {
                R = 8.5;
            }
            else if(caste.equals("SC") || caste.equals("ST") || caste.equals("OBC"))
            {
                R = 9.5;
            }
            else if(age>59)
            {
                R = 9.5;
            }
            else
            {
                R = 10;
            }
            double A = calculate_A(P,R,N);
            N = Math.round(N);
            obj.del();
            obj.del();
            System.out.print("\f");
            ass.face();
            obj.del();
            obj.del();
            System.out.println("*please wait while I calculate the amount to be paid by you "+g+"*");
            obj.del();
            obj.del();
            obj.del();
            System.out.print("\f");
            ass.face();
            System.out.println(g+", you have to pay Rs. "+A+" in "+N+" years");
            String input = scan.nextLine();
            System.out.print("\f");
            ass.face();
            System.out.println("*please wait while I update your database "+g+"*");
            update(A,p,g,loantype);
            reset(g,age,caste,p);
        }
      }
      catch(NumberFormatException e)
      {
          System.out.println("Error: Please enter only numbers");
          loan(g,loanamt,age,caste,loantype,p);
      }
    }
    private static void reset(String g,int age,String caste,String p)
    {
        String input = scan.nextLine();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        System.out.println("*please wait while I load the main screen for you "+g+"*");
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.recieve(g,age,caste,p);
    }
    private static double calculate_A(double P,double R,double N)
    {
        double A = Math.rint(Math.pow(P*(1+(R/100)),N));
        //A = Math.round(A);
        //A = A * 100;
        //A = A/100;
        return A;
    }
    private static void update(double A,String p,String g,String loantype)
    {
        obj.del();
        obj.del();
        obj.del();
        System.out.print("\f");
        ass.face();
        obj.del();
        obj.del();
        String date = yr.date();
        String amount = Double.toString(A);
        String data = A + "," + loantype + "," + date;
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(p+"loan.txt"));
            bw.write(data);
            bw.close();
            System.out.print("\f");
            ass.face();
            obj.del();
            obj.del();
            System.out.println("Database Updated "+g);
        }
        catch(IOException e)
        {
            System.out.println("Sorry "+g+", could not update your database");
            System.out.println("Please try again next time"+g);
            System.exit(0);
        }
    }
}