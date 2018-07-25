
/**
 * Write a description of class CodingBat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recursion1
{
    public int powerN(int base, int n) {
        int prod=1;
        if(base==1 || n==0) return 1;
        else prod= base * powerN(base,n-1);
        return prod;
    }

    public int sumDigits(int n) {
        int sum=0;
        if(n==0)return 0;
        else sum= n%10 + sumDigits(n/10);
        return sum;
    }

    public int triangle(int rows) {
        int block=0;
        if(rows==0)return 0;
        else block= rows + triangle(rows-1);
        return block;
    }

    public int count7(int n) {
        int cont=0;
        if(n==0) return 0;
        else if(n%10==7) cont= 1 + count7(n/10);
        else cont= count7(n/10);
        return cont;
    }

    public int bunnyEars(int bunnies) {
        int ears=0;
        if(bunnies==0) return 0;
        else ears= 2+bunnyEars(bunnies-1);
        return ears;
    }
}
