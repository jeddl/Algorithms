public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        
        if (s == null || s.length() == 0) {
            return maxLen;
        }
        
        int start = 0, end = 0;
        HashSet<Character> set = new HashSet<Character>();
        
        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                while (start < end && s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                maxLen = Math.max(maxLen, end - start + 1);
                set.add(s.charAt(end));
            }
            end++;
        }
        
        return maxLen;
    }
}