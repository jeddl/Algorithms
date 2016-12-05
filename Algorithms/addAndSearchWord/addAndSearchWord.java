public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode currNode = root;
        for (Character c : word.toCharArray()) {
            if (!currNode.children.containsKey(c)) {
                currNode.children.put(c, new TrieNode());
            }
            currNode = currNode.children.get(c);
        }
        currNode.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, 0, root);
    }
    
    private boolean find(String word, int index, TrieNode currNode) {
        if (index == word.length()) {
            if (currNode.children.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
        
        char c = word.charAt(index);
        if (currNode.children.containsKey(c)) {
            if (index == word.length() - 1 && currNode.children.get(c).isWord) {
                return true;
            }
            return find(word, index + 1, currNode.children.get(c));
        } else if (c == '.') {
            boolean hasWord = false;
            for (Map.Entry<Character, TrieNode> child : currNode.children.entrySet()) {
                if (index == word.length() - 1 && child.getValue().isWord) {
                    return true;
                }
                
                if (find(word, index + 1, child.getValue())) {
                    hasWord = true;
                }
            }
            return hasWord;
        } else {
            return false;
        }
    }
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isWord = false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");