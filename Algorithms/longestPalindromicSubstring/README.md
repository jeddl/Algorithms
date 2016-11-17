# Find Longest Palindromic Substring
## Example
Return the longest palindromic substring of the given string:
Given `"abcbabc"`, return `"cbabc"`

## Solution 1
- Two pointers `i` and `j`, `i < j`
- Loop the given string `s`, and find the palindrome between `s[i]` and `s[j]`

## Solution 2
- Loop the given string `s` with `i`
- Loop the first half of string with `j`(from `i` to `0`, backward)
- Palindrome starting from `j` to `i`(`pSp'` where `p == p'` `&&` `S` is palindrome)
 - `s[j] == s[i]` `&&` one of the following
 - `i - j <= 2`, since when `s[j] == s[i]`, `i - j == 1`, j and i are adjacent(e.g. `"aa", "bb"`), `i - j == 2`(e.g. `"aba", "cec"`)
 
 OR
 
 - The string between `s[j]` and `s[i]` should be palindrome (`isPalindrome[j + 1][i - 1]`)
