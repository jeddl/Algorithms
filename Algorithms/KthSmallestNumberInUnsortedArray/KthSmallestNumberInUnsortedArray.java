class Solution {
    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        
        return quickSort(nums, 0, nums.length - 1, k);
    }
    
    private int quickSort(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left];
        }
        
        int position = partition(nums, left, right);
        
        if (position + 1 == target) {
            return nums[position];
        } else if (position + 1 < target) {
            return quickSort(nums, position + 1, right, target);
        } else {
            return quickSort(nums, left, position - 1, target);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        return left;
    }
};