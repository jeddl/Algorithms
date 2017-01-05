public class Solution {
    public int maxProduct(int[] nums) {
        int[] tempMax = new int[nums.length + 1];
        int[] tempMin = new int[nums.length + 1];
        int result = nums[0];
        
        tempMax[0] = nums[0];
        tempMin[0] = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > 0) {
                tempMax[i] = Math.max(nums[i], nums[i] * tempMax[i - 1]);
                tempMin[i] = Math.min(nums[i], nums[i] * tempMin[i - 1]);
            } else if (nums[i] < 0) {
                tempMax[i] = Math.max(nums[i], nums[i] * tempMin[i - 1]);
                tempMin[i] = Math.min(nums[i], nums[i] * tempMax[i - 1]);
            } else {
                tempMax[i] = tempMin[i] = 0;
            }
            
            result = Math.max(result, tempMax[i]);
        }
        
        return result;
    }
}