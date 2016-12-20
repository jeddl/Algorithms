public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = Integer.MIN_VALUE;
        
        for (start = 0; start < s.length(); ++start) {
            while(end < s.length()) {
                if (map.containsKey(s.charAt(end))) {
                    map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
                } else {
                    // Important! Only if k distinct Characters have been reached and
                    // the new coming character is not in HashMap
                    if (map.size() >= k) {
                        break;
                    }
                    map.put(s.charAt(end), 1);
                }
                
                end++;
            }

            maxLen = Math.max(maxLen, end - start);
            
            if(map.containsKey(s.charAt(start))) {
                if (map.get(s.charAt(start)) == 1) {
                    map.remove(s.charAt(start));
                } else {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                }  
            }

        }
        
        return maxLen;
    }
}