
/**
 * Array2
 * @author Santiago Isaza Cdaavid y Hamilton Smith Gómez Osorio
 * @version Agosto 2018
 */
public class Array2
{
    public int countEvens(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) n+=1;
        }
        return n;
    }

    public boolean lucky13(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==3 || nums[i]==1) return false;
        }
        return true;
    }

    public boolean isEverywhere(int[] nums, int val) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=val && nums[i+1]!=val) return false;
        }
        return true;
    }

    public boolean modThree(int[] nums) {
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]%2==0 && nums[i+1]%2==0 && nums[i+2]%2==0) return true;
            if(nums[i]%2==1 && nums[i+1]%2==1 && nums[i+2]%2==1) return true;
        }
        return false;
    }
}
