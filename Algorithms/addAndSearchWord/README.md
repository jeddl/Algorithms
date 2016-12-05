# Add and Search Word
## Exmaple
- Design a data structure that supports the following two operations: `addWord(word)` and `search(word)`
- `search(word)` can search a literal word or a regular expression string containing only letters `a-z` or `.`.
- A `.` means it can represent any one letter.
- May assume that all letters are lower case

```
addWord("bad")
addWord("dad")
addWord("mad")
search("pad")  // return false
search("bad")  // return true
search(".ad")  // return true
search("b..")  // return true
```

## Solution
- HashMap Trie
