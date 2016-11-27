class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (k <= 0 || nums == null || nums.length == 0) {
            return 0;
        }
        
        return quickSort(nums, 0, nums.length - 1, nums.length - k + 1);
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
        // Initialize pivot
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
        
        // Return pivot value
        nums[left] = pivot;
        return left;
    }
};