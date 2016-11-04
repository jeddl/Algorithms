public class Solution {

    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        
        int maxLength = 0;
        for (String str : dict) {
            maxLength = Math.max(str.length(), maxLength);
        }
        
        boolean[] segmentable = new boolean[s.length() + 1];
        segmentable[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int prevWordLength = 1; prevWordLength <= i && prevWordLength <= maxLength; prevWordLength++) {
                if (!segmentable[i - prevWordLength]) {
                    continue;
                }
                String word = s.substring(i - prevWordLength, i);
                if (dict.contains(word)) {
                    segmentable[i] = true;
                    break;
                }
            }
        }
        
        return segmentable[s.length()];
    }
}