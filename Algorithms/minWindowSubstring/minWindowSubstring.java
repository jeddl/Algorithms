public class Solution {
    public String minWindow(String source, String target) {
        int minLength = Integer.MAX_VALUE;
        String newStr = "";
        
        int[] targetHash = new int[256];
        int[] sourceHash = new int[256];
        // j is the right side of the window
        int j = 0;
        
        iniTargetHash(targetHash, target);
        
        for (int i = 0; i < source.length(); ++i) {
            while (!isValid(sourceHash, targetHash) && j < source.length()) {
                sourceHash[source.charAt(j)]++;
                j++;
            }
            
            if (isValid(sourceHash, targetHash)) {
                // j - i is the size of the window
                if (minLength > j - i) {
                    minLength = j - i;
                    newStr = source.substring(i, j);
                }
            }
            
            sourceHash[source.charAt(i)]--;
        }
        
        return newStr;
    }
    
    private void iniTargetHash(int[] targetHash, String target) {
        for (char c : target.toCharArray()) {
            targetHash[c]++;
        }
    }
    
    private boolean isValid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < 256; ++i) {
            if (sourceHash[i] < targetHash[i]) {
                return false;
            }
        }
        return true;
    }
}