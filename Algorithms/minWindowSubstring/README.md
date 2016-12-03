# Minimum Window Substring
## Example
Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
```
- If there is no such window in source that covers all characters in target, return the emtpy string "".
- If there are multiple such windows, you are guaranteed that there will always be only one unique 
minimum window in source.
```

e.g. Given `source = "ADOBECODEBANC"`, `target = "ABC"`, the minimum window is `"BANC"`

## Solution
- Hash characters in source and target
