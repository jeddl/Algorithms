class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children;
    boolean isWord;
    
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode currNode = root;
        for (Character c : word.toCharArray()) {
            if (!currNode.children.containsKey(c)) {
                currNode.children.put(c, new TrieNode());
            }
            currNode = currNode.children.get(c);
        }
        currNode.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return find(word, 0, root);    
    }

    private boolean find(String word, int index, TrieNode currNode) {
        if (index == word.length()) {
            return false;
        }
        
        char c = word.charAt(index);
        
        if (currNode.children.containsKey(c)) {
            if (index == word.length() - 1 && currNode.children.get(c).isWord) {
                return true;
            }
            return find(word, index + 1, currNode.children.get(c));
        } else {
            return false;
        }
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return prefixIsValid(prefix, 0, root);
    }
    
    private boolean prefixIsValid(String prefix, int index, TrieNode currNode) {
        if (index == prefix.length()) {
            return true;
        }

        char c = prefix.charAt(index);
        
        if (currNode.children.containsKey(c)) {
            return prefixIsValid(prefix, index + 1, currNode.children.get(c));
        } else {
            return false;
        }
    }
}