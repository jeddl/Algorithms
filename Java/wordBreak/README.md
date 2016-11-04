# Word Break
## Example
Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

e.g. Given `s = "leetcode", dict = ["leet", "code"]`.

Return true because `"leetcode"` can be break as `"leet code"`.

## Solution
- Dynamic Programming
- Use a boolean array (e.g. `segmentable[i]`) to show if the word formed by first `i` characters can be found in the dictionary
- Two pointers (e.g. `i` and `j`): `i` for looping the string, `j` for checking if first 'i' characters could be broken by `j` as two valid words
- Both `i` and `j` are `<=` the length of the string (NOT index)
