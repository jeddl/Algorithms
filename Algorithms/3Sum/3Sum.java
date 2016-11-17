public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        if (numbers == null || numbers.length < 3) {
            return null;
        }
        Arrays.sort(numbers);
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            
            int start = i + 1, end = numbers.length - 1;
            
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                ArrayList<Integer> temp = new ArrayList<Integer>();
                
                if (sum == 0) {
                    temp.add(numbers[i]);
                    temp.add(numbers[start]);
                    temp.add(numbers[end]);
                    ans.add(temp);
                    start++;
                    end--;
                    
                    // Skip duplicates
                    while (start < end && numbers[start] == numbers[start - 1]) {
                        start++;
                    }
                
                    while (start < end && numbers[end] == numbers[end + 1]) {
                        end--;
                    }
                // Decrease time complexity
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
                
            }
        }
        
        return ans;
    }
}