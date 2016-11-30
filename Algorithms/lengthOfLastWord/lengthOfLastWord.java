public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0) {
                if (s.charAt(i) == ' ') {
                    continue;
                } else {
                    length++;
                }
            } else {
                if (s.charAt(i) != ' ') {
                    length++;
                } else {
                    break;
                }
            }
        }
        return length;
    }
}
