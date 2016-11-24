class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (k > nums.length) {
            return 0;
        }
        
        Arrays.sort(nums);
        int ans = 0;
        
        for (int i = nums.length - 1; i >= k; --i) {
            ans = nums[i];
        }
        
        return ans;
    }
};