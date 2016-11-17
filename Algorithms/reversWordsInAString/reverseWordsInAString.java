public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        String[] splited = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = splited.length - 1; i >= 0; i--) {
            if (!splited.equals("")) {
                result.append(splited[i]).append(" ");
            }
        }
        return result.length() == 0 ? "" : result.substring(0, result.length() - 1);
    }
}