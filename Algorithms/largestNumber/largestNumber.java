public class Solution {
    public String largestNumber(int[] num) {
        String[] strs = new String[num.length];
        for (int i = 0; i < num.length; ++i) {
            strs[i] = Integer.toString(num[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Note the order -> s2 + s1 compareTo s1 + s2
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        StringBuilder strbuild = new StringBuilder();
        
        for (int i = 0; i < strs.length; ++i) {
            strbuild.append(strs[i]);
        }
        
        String ans = strbuild.toString();
        int index = 0;
        
        // If "0000000" etc.
        while (index < ans.length() && ans.charAt(index) == '0') {
            index++;
        }
        if (index == ans.length()) {
            return "0";
        }
        
        return ans.substring(index);
        
    }
}
