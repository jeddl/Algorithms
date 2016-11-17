public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> ans = new ArrayList<String>();
        Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i ++) {
                count[str.charAt(i) - 'a']++;
            }
            
            int hash = getHash(count);
            
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }
            map.get(hash).add(str);
        }
        
        for (ArrayList<String> temp : map.values()) {
            if (temp.size() > 1) {
                ans.addAll(temp);
            }
        }
        
        return ans;
    }
    
    private int getHash(int[] count) {
        int hash = 0;
        int a = 382394;
        int b = 31231;
        
        for (int ele : count) {
            hash = hash * a + ele;
            a = a * b;
        }
        
        return hash;
    }
}