# Longest Substring Without Repeating Characters
## Example
Given a string, find the length of the longest substring without repeating characters.

e.g. The longest substring without repeating letters for `abcabcbb` is `abc`, which the length is 3.
For `bbbbb` the longest substring is `b`, with the length of 1.

## Solution
- 2 pointers
- Only focus on the substring between 2 pointers
- Use a dictionary to keep the ones that has been scanned
