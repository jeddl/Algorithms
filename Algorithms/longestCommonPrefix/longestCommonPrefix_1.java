public class Solution {
    // Iterate each string in the string array and compare the result string with the current string character by character
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }
        int len = strs.length;
        result = strs[0];
        for (int i = 1; i < len; i++) {
            if (strs[i] == "") {
                return "";
            }
            int j = result.length() < strs[i].length() ? result.length() : strs[i].length();
            for (int k = 0; k < j; k ++) {
                if (result.charAt(k) != strs[i].charAt(k)) {
                    result = result.substring(0, k);
                    break;
                }
            }
        }
        
        return result;
    }
}