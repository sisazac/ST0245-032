
/**

 * Recursion2

 * Ejercicios de recursión 2 de codingbat

 * @author Santiago  Isaza Cadavid y Hamilton Smith Gómez Osorio

 * @version Agosto-2018

 */

public class Recursion2

{

    public boolean groupSum6(int start, int[] nums, int target) {
        if(start>=nums.length) return target==0;
        if(nums[start]==6) return groupSum6(start+1,nums,target-nums[start]);
        return groupSum6(start+1,nums,target-nums[start]) || 
        groupSum6(start+1,nums,target);
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length) return target==0;
        return groupNoAdj(start+1,nums,target) ||
        groupNoAdj(start+2,nums,target-nums[start]);
    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if(start>=nums.length) return target==0;
        if (nums[start]%5==0){
            if(start<nums.length-1 && nums[start+1]==1){
                return groupSum5(start+2,nums,target-nums[start]);
            }
            return groupSum5(start+1,nums,target-nums[start]);
        }
        return groupSum5(start+1,nums,target) ||
        groupSum5(start+1,nums,target-nums[start]);
    }


}