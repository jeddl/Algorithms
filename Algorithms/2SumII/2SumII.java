public class Solution {
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                count += end - start;
                end--;
            } else {
                start++;
            }
        }
        
        return count;
    }
}