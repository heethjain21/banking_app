package Menu;
import Delay.Delay;
import Account.Account;
public class Menu
{
    public static Delay obj = new Delay();
    public static Account ac = new Account();
    public static void main()
    {
        System.out.println("***************WeLcOmE To BeSt BaNk***************");
        obj.del();
        obj.del();
        System.out.print("\f");
        ac.main();
    }
}