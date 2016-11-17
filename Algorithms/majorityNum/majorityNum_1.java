public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int half = nums.size() / 2;
        
        for (int num : nums) {
            int count = 1;
            if (!map.containsKey(num)) {
                map.put(num, count);
            } else {
                count = map.get(num) + 1;
                map.put(num, count);
            }
            
            if (map.get(num) > half) {
                return num;
            }
        }
        
        // Return max value if there is no majority number
        return Integer.MAX_VALUE;
    }
}