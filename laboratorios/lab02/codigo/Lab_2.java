import java.util.*;
public class Lab_2
{
    // Computer the sum of an array
    public static int ArraySum(int[] A)
    {          
        int sum = 0;
        for (int i = 0; i < A.length; i++)
            sum = sum + A[i];
        return sum;
    }

    // Computes the maximum value of an array
    public static int ArrayMax(int[] A)
    {
        int max = A[0];
        for (int i = 0; i < A.length; i++)
            if (A[i] > max)
                max = A[i];
        return max;
    }

    // Sorts an array using Insertion Sort
    public static void InsertionSort(int[] A)
    {
        int temp,j;
        for (int i = 0; i < A.length; i++)
        {
            j = i;
            while (j > 0 && A[j-1] > A[j])
            {
                temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j = j-1;
            }           
        }
        //System.out.println(Arrays.toString(A));
    }

    // Sorts an array using Merge Sort
    // Taken from www.cs.cmu.edu/
    public static void mergeSort(int [ ] a)
    {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];
        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];
        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];
        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    public static void main(String[] args)
    {
        for(int i=100000;i<=500000;i=i+10000){
            System.out.println("Estimated time: " +time(i)+" Array size: "+i);
        }
    }

    public static long time(int n){
        int [] a = generator(n);
        long start = System.currentTimeMillis();
        InsertionSort(a);
        //mergeSort(a);
        long fin = System.currentTimeMillis();    
        return fin-start;
    }

    public static int [] generator(int n){
        int max=5000;
        int [] arr= new int[n];
        Random generator = new Random();
        for(int i=0; i<n;i++){
            arr[i]=generator.nextInt(max);
        }
        return arr;
    }
}

