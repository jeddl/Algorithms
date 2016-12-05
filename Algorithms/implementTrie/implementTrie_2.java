class TrieNode {
    public TrieNode[] children;
    public boolean isWord;
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
    
    public void insert(String word, int index) {
        if (index == word.length()) {
            isWord = true;
            return;
        }
        
        int member = word.charAt(index) - 'a';
        
        if (children[member] == null) {
            children[member] = new TrieNode(); 
        }
        
        children[member].insert(word, index + 1);
    }
    
    public TrieNode find(String word, int index) {
        if (index == word.length()) {
            return this;
        }
        
        int member = word.charAt(index) - 'a';
        
        if (children[member] == null) {
            return null;
        }
        
        return children[member].find(word, index + 1);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return (node != null && node.isWord);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null;
    }
}