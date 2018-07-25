
/**
 * Write a description of class Lab1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lab1
{
    public static int fibonnacci(int n){
        if(n<=1) return n;
        return fibonnacci(n-1)+fibonnacci(n-2);
    }

    public static void test(){
     System.out.println(fibonnacci(10));
     System.out.println(fibonnacci(20));
     System.out.println(fibonnacci(100));
     System.out.println(fibonnacci(1000));
    }
}
