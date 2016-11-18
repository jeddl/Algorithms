public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int start = 0, end = s.length() - 1;
        
        while (start < end) {
            // Check if character at start is valid
            while (start < s.length() && !isValidChar(s.charAt(start))) {
                start++;
            }
            // If it is empty string
            if (start == s.length()) {
                return true;
            }
            // Check if character at end is valid
            while (end >= 0 && !isValidChar(s.charAt(end))) {
                end--;
            }
            
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                start++;
                end--;
            }
        }
        
        return start >= end;
    }
    
    private boolean isValidChar(Character c) {
        // Letters or Digits are valid
        return Character.isLetter(c) || Character.isDigit(c);
    }
}