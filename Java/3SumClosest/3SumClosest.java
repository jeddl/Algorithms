public class Solution {
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) { continue; }
            
            int start = i + 1, end = numbers.length -1;
            
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                
                if (sum == target) {
                    return sum;
                }
                
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    closest = sum;
                }
                
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        
        return closest;
    }
}
