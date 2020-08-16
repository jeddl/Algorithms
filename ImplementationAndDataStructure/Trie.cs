class TrieNode
{
    public TrieNode[] Children;
    public bool Flag;

    public TrieNode()
    {
        Children = new TrieNode[26];
        for (int i = 0; i < 26; i++)
        {
            Children[i] = null;
        }
        Flag = false;
    }
}

class Trie
{
    private TrieNode _root;

    public Trie()
    {
        _root = new TrieNode();
    }

    public void Insert(string word)
    {
        TrieNode x = _root;
        for (int i = 0; i < word.Length; i++)
        {
            int c = word[i] - 'a';
            if (x.Children[c] == null) x.Children[c] = new TrieNode();
            x = x.Children[c];
        }
        x.Flag = true;
    }

    public bool Search(string word)
    {
        TrieNode x = _root;
        for (int i = 0; i < word.Length; i++)
        {
            int c = word[i] - 'a';
            if (x.Children[c] == null) return false;
            x = x.Children[c];
        }
        return x.Flag;
    }

    public bool StartWith(string prefix)
    {
        var x = _root;
        for (int i = 0; i < word.Length; i++)
        {
            int c = word[i] - 'a';
            if (x.Children[c] == null) return false;
            x = x.Children[c];
        }
        return true;
    }
}
