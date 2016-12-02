class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int index = 0;
        
        while (index <= blue ) {
            if (nums[index] == 0) {
                swap(red, index, nums);
                index++;
                red++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(blue, index, nums);
                blue--;
            }
        }
    }
    
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
