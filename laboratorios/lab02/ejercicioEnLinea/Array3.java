
/**
 * Array3
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio
 * @version August 2018;
 */
public class Array3
{
    public boolean linearIn(int[] outer, int[] inner) { 
        int n=0; 
        for(int i=0;i<inner.length;i++){   
            for(int j=0;j<outer.length;j++){     
                if(inner[i]==outer[j]){       
                    n++;       
                    break;     
                }   
            } 
        }
        return n==inner.length;
    }

    public int[] seriesUp(int n) {
        int [] arr=new int[n*(n+1)/2];
        int num=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                arr[num]=j;
                num++;
            }
        }
        return arr;
    }


      public int[] fix34(int[] nums) {
         int index=0;
         for(int i=0;i<nums.length;i++){
             if(nums[i]==3){
                for(int j=index;j<nums.length;j++){
                    if(nums[j]==4){
                    index= j;
                    int aux= nums[j];
                    nums[index]= nums[i+1];
                    nums[i+1]= aux;
                    break;
                    }
                }
             }
          }
      return nums;
      }
}
