public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int maxLength = 0;
        String longest = new String();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (s.substring(i, j).length() > maxLength) {
                        maxLength = s.substring(i, j).length();
                        longest = s.substring(i, j);
                    }
                }
            }
        }
        return longest;
    }
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}